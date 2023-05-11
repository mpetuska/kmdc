package dev.petuska.katalog.plugin

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.*
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ksp.*
import dev.petuska.katalog.plugin.builder.*
import dev.petuska.katalog.plugin.domain.*
import dev.petuska.katalog.plugin.util.*
import dev.petuska.katalog.plugin.visitor.*
import java.io.*

public class KatalogSymbolProcessor(
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
            ) { "%$it:M" },
            arguments = mapOf(
              "katalog" to MemberName("dev.petuska.katalog.runtime", "renderKatalog"),
              "config" to config,
            ) + showcaseFns
          )
        }.also(::addCode)
      }.also(::addFunction)
    }.writeTo(codeGenerator, true)
  }
}
