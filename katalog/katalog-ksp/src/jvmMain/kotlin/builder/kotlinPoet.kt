package dev.petuska.katalog.plugin.builder

import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import dev.petuska.katalog.plugin.util.Builder

@Target(AnnotationTarget.TYPE)
@DslMarker
public annotation class KotlinPoetBuilderDSL

public inline fun codeBlockOf(
  builder: Builder<@KotlinPoetBuilderDSL CodeBlock.Builder>
): CodeBlock = CodeBlock.builder().apply(builder).build()

public inline fun funOf(
  name: String,
  builder: Builder<@KotlinPoetBuilderDSL FunSpec.Builder>
): FunSpec = FunSpec.builder(name).apply(builder).build()

public inline fun fileOf(
  packageName: String,
  fileName: String,
  builder: Builder<@KotlinPoetBuilderDSL FileSpec.Builder>
): FileSpec = FileSpec.builder(packageName, fileName).apply(builder).build()
