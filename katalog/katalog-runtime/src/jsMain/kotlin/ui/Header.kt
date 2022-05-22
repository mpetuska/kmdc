package dev.petuska.katalog.runtime.ui

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

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
    katalog.theme.katalogTitleRender(katalog.title)
    katalog.subtitle?.let { katalog.theme.katalogSubtitleRender(it) }
  }
}
