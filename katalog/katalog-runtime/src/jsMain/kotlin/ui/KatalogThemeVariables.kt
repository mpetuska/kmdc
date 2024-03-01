package dev.petuska.katalog.runtime.ui

import dev.petuska.katalog.runtime.theme.*
import dev.petuska.katalog.runtime.util.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.css.*
import org.w3c.dom.*

internal object KatalogThemeVariables {
  val highlightColor by variable<CSSColorValue>()
}

internal fun AttrsScope<HTMLDivElement>.applyTheme(theme: KatalogTheme) = style {
  setVariable(KatalogThemeVariables.highlightColor, theme.highlightColor)
  fontFamily(value = theme.fontFamily.toTypedArray())
}
