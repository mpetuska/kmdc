package dev.petuska.katalog.runtime.ui

import dev.petuska.katalog.runtime.theme.KatalogTheme
import dev.petuska.katalog.runtime.util.setVariable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.fontFamily
import org.jetbrains.compose.web.css.variable
import org.w3c.dom.HTMLDivElement

internal object KatalogThemeVariables {
  val highlightColor by variable<CSSColorValue>()
}

internal fun AttrsScope<HTMLDivElement>.applyTheme(theme: KatalogTheme) = style {
  setVariable(KatalogThemeVariables.highlightColor, theme.highlightColor)
  fontFamily(value = theme.fontFamily.toTypedArray())
}
