package dev.petuska.katalog.runtime.ui

import androidx.compose.runtime.Composable
import dev.petuska.katalog.runtime.katalog
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.dom.Div

private object KatalogStyle : StyleSheet() {
  val container by style {
    display(DisplayStyle.Flex)
    flexDirection(FlexDirection.Column)
  }
}

@Composable
internal fun Katalog() {
  val theme = katalog.theme
  Style(KatalogStyle)
  Div(attrs = {
    classes(KatalogStyle.container)
    applyTheme(theme)
  }) {
    Header()
    Showcases()
  }
}
