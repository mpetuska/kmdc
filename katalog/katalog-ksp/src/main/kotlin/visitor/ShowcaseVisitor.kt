package dev.petuska.katalog.plugin.visitor

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.*
import com.google.devtools.ksp.visitor.*
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ksp.*
import dev.petuska.katalog.plugin.builder.*
import dev.petuska.katalog.plugin.domain.*
import dev.petuska.katalog.plugin.util.*
import java.io.*


class ShowcaseVisitor(
  private val builtIns: KSBuiltIns,
  private val codeGenerator: CodeGenerator,
  override val logger: KSPLogger,
  private val contentRoot: File?,
) : KSDefaultVisitor<ShowcaseData, ShowcaseName>(), KatalogLogger {

  override fun visitFunctionDeclaration(function: KSFunctionDeclaration, data: ShowcaseData): ShowcaseName {
    validate(function)
    val name = function.simpleName.getShortName()
    val propName = name + "KatalogShowcase"
    val title = data.title ?: function.simpleName.asString()
    val type = ClassName("dev.petuska.katalog.runtime.domain", "Showcase")

    val funRef = function.ref(this)
    val prop = PropertySpec.builder(propName, type).apply {
      function.containingFile?.let(::addOriginatingKSFile)
      val location = function.location.let {
        if (it is FileLocation) {
          it
        } else {
          null
        }
      }?.let { (filePath, lineNumber) ->
        contentRoot?.let { File(filePath).relativeTo(it) }?.let { "$it#L$lineNumber" }
      }
      codeBlockOf {
        addNamed(
          format = """
                      %showcaseItem:T(
                        id = %id:S,
                        title = %title:S,
                        description = %description:S,
                        location = %location:S,
                        content = {
                          %invocation:L
                        },
                      )
                    """.trimIndent(),
          arguments = mapOf(
            "id" to (data.id ?: function.qualifiedName?.asString() ?: "katalog-showcase--$name"),
            "showcaseItem" to type,
            "invocation" to function.invocation(funRef, title, data.description),
            "title" to title,
            "description" to data.description,
            "location" to location,
          )
        )
      }.also(::initializer)
    }.build()
    fileOf(function.packageName.asString(), propName) {
      addProperty(prop)
    }.writeTo(codeGenerator, true)
    return ShowcaseName(function.packageName.asString(), propName)
  }

  private fun KSFunctionDeclaration.invocation(
    funRef: MemberName,
    title: String,
    description: String?,
  ) = codeBlockOf {
    val args = mutableMapOf<String, Any?>()
    parameters["title"]?.takeIf { it.type.resolve() == builtIns.stringType }?.let {
      args["title"] = title
    }
    parameters["description"]?.takeIf { it.type.resolve() == builtIns.stringType }
      ?.let { args["description"] = description }

    addNamed(
      args.toList().joinToString(separator = ", ", prefix = "%fun:M(", postfix = ")") { (name, _) ->
        "%$name:S"
      }, args + mapOf(
        "fun" to funRef
      )
    )
  }

  private fun validate(function: KSFunctionDeclaration) {
    require(function.extensionReceiver == null) { "Showcase cannot have a receiver. Actual: ${function.extensionReceiver}" }
    require(function.returnType?.resolve() == builtIns.unitType) { "Showcase must return Unit. Actual: ${function.returnType}" }
  }

  override fun defaultHandler(node: KSNode, data: ShowcaseData): ShowcaseName {
    error("Only KSFunctionDeclaration supported. Actual: ${node::class.simpleName}", node)
  }
}
