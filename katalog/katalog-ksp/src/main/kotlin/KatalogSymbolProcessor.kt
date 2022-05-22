package dev.petuska.katalog.plugin

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSAnnotation
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ksp.addOriginatingKSFile
import com.squareup.kotlinpoet.ksp.writeTo
import dev.petuska.katalog.plugin.builder.codeBlockOf
import dev.petuska.katalog.plugin.builder.fileOf
import dev.petuska.katalog.plugin.builder.funOf
import dev.petuska.katalog.plugin.domain.ShowcaseData
import dev.petuska.katalog.plugin.domain.ShowcaseName
import dev.petuska.katalog.plugin.util.KatalogLogger
import dev.petuska.katalog.plugin.util.asString
import dev.petuska.katalog.plugin.util.get
import dev.petuska.katalog.plugin.util.ref
import dev.petuska.katalog.plugin.visitor.ShowcaseVisitor
import java.io.File

class KatalogSymbolProcessor(
  private val codeGenerator: CodeGenerator,
  override val logger: KSPLogger,
  private val contentRoot: File?
) : SymbolProcessor, KatalogLogger {
  private val showcases = mutableSetOf<ShowcaseName>()
  private val configs = mutableMapOf<Int, List<KSFunctionDeclaration>>()

  override fun process(resolver: Resolver): List<KSAnnotated> {
    resolver.getSymbolsWithAnnotation("dev.petuska.katalog.runtime.KatalogConfig")
      .filterIsInstance<KSFunctionDeclaration>()
      .groupBy {
        val ann = it.annotations.first { a -> a.shortName.getShortName() == "KatalogConfig" }
        (ann.arguments["priority"]?.value as Int?) ?: 0
      }.let(configs::putAll)

    val showcases = resolver.getSymbolsWithAnnotation("dev.petuska.katalog.runtime.Showcase")
    val visitor = ShowcaseVisitor(resolver.builtIns, codeGenerator, logger, contentRoot)
    showcases.mapNotNull {
      if (it.annotations.any { a -> a.shortName.asString() == "Composable" }) {
        val data = it.annotations.first { a -> a.shortName.getShortName() == "Showcase" }.showcaseData()
        runCatching { it.accept(visitor, data) }.getOrNull()
      } else {
        warn("@Showcase functions must also be marked with @Composable. Skipping...", it)
        null
      }
    }.let(this.showcases::addAll)
    return listOf()
  }

  private fun KSAnnotation.showcaseData(): ShowcaseData {
    return ShowcaseData(
      id = arguments["id"].asString(),
      title = arguments["title"].asString(),
      description = arguments["description"].asString(),
    )
  }

  override fun finish() {
    fileOf("dev.petuska.katalog", "main") {
      val config = codeBlockOf {
        configs.toList().sortedByDescending { it.first }.flatMap { it.second }.forEach { config ->
          addStatement("%M()", config.ref(this@KatalogSymbolProcessor))
        }
      }
      funOf("main") {
        configs.values.flatten().mapNotNull(KSFunctionDeclaration::containingFile).forEach(::addOriginatingKSFile)
        codeBlockOf {
          val showcaseFns = showcases.associateBy { it.simpleName.lowercase() }
          addNamed(
            format = showcaseFns.keys.joinToString(
              prefix = "%katalog:M(showcases = listOf(",
              postfix = "), config = { %config:L })",
              separator = ", "
            ) { "%${it}:M" }, arguments = mapOf(
              "katalog" to MemberName("dev.petuska.katalog.runtime", "renderKatalog"),
              "config" to config,
            ) + showcaseFns
          )
        }.also(::addCode)
      }.also(::addFunction)
    }.writeTo(codeGenerator, true)
  }
}
