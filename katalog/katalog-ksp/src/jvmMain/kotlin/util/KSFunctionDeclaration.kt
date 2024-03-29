package dev.petuska.katalog.plugin.util

import com.google.devtools.ksp.symbol.*
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ksp.*

public fun KSFunctionDeclaration.ref(logger: KatalogLogger): MemberName {
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
