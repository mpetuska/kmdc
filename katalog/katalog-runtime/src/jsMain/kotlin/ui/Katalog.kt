package dev.petuska.katalog.runtime.ui

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import org.jetbrains.compose.web.css.*
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
