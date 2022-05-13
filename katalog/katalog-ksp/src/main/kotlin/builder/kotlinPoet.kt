package dev.petuska.katalog.plugin.builder

import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import dev.petuska.katalog.plugin.util.Builder

@Target(AnnotationTarget.TYPE)
@DslMarker
annotation class KotlinPoetBuilderDSL

inline fun codeBlockOf(
  builder: Builder<@KotlinPoetBuilderDSL CodeBlock.Builder>
): CodeBlock = CodeBlock.builder().apply(builder).build()

inline fun funOf(
  name: String,
  builder: Builder<@KotlinPoetBuilderDSL FunSpec.Builder>
): FunSpec = FunSpec.builder(name).apply(builder).build()

inline fun fileOf(
  packageName: String, fileName: String,
  builder: Builder<@KotlinPoetBuilderDSL FileSpec.Builder>
): FileSpec = FileSpec.builder(packageName, fileName).apply(builder).build()
