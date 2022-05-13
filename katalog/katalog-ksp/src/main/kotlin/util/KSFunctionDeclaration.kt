package dev.petuska.katalog.plugin.util

import com.google.devtools.ksp.symbol.ClassKind
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ksp.toClassName

fun KSFunctionDeclaration.ref(logger: KatalogLogger): MemberName {
  val isExtension = extensionReceiver != null
  val parent = parentDeclaration
  val pkg = packageName.asString().takeIf(String::isNotBlank)
  return when {
    parent == null -> MemberName(
      pkg ?: logger.error("Root packages not supported!", this),
      simpleName.asString(),
      isExtension = isExtension,
    )
    parent is KSClassDeclaration && parent.classKind == ClassKind.OBJECT -> MemberName(
      parent.toClassName(),
      simpleName.asString(),
      isExtension = isExtension,
    )
    else -> {
      logger.error("Only top-level or object-scoped functions supported!", this)
    }
  }
}
