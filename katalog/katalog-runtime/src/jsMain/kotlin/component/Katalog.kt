package dev.petuska.katalog.runtime.component

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontFamily
import org.jetbrains.compose.web.dom.Div

private object KatalogStyle : StyleSheet() {
  val container by style {
    display(DisplayStyle.Flex)
    flexDirection(FlexDirection.Column)
    fontFamily("Roboto", "sans-serif")
  }
}

@Composable
internal fun Katalog() {
  Style(KatalogStyle)
  Div(attrs = {
    classes(KatalogStyle.container)
  }) {
    Header()
    Showcases()
  }
}
