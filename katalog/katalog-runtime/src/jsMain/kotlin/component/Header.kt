package dev.petuska.katalog.runtime.component

import androidx.compose.runtime.Composable
import dev.petuska.katalog.runtime.katalog
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.Text

private object HeaderStyle : StyleSheet() {
  val container by style {
    display(DisplayStyle.Flex)
    flexDirection(FlexDirection.Column)
    alignItems(AlignItems.Center)
  }
}

@Composable
internal fun Header() {
  Style(HeaderStyle)
  Div(attrs = {
    classes(HeaderStyle.container)
  }) {
    H3 { Text(katalog.title) }
    katalog.subtitle?.let { H4 { Text(it) } }
  }
}
