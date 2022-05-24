package dev.petuska.katalog.runtime.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import dev.petuska.katalog.runtime.domain.Showcase
import dev.petuska.katalog.runtime.katalog
import dev.petuska.katalog.runtime.layout.Divider
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div

private object ShowcaseBoxStyle : StyleSheet() {
  val header by style {
  }
  val content by style {
    width(100.percent)
  }
}

@Composable
internal fun ShowcaseBox(showcase: Showcase) = with(showcase) {
  LaunchedEffect(showcase) {
    console.asDynamic().clear(); Unit
  }
  val contentRootUrl = katalog.contentRootUrl
  val location = contentRootUrl?.let {
    showcase.location?.let {
      "${contentRootUrl.removeSuffix("/")}/${showcase.location}"
    }
  }
  val theme = katalog.theme
  Div(attrs = {
    id("${id}__header")
    classes(ShowcaseBoxStyle.header)
  }) {
    A(location, attrs = {
      target(ATarget.Blank)
    }) {
      theme.showcaseTitleRender(title)
    }
    description?.let { theme.showcaseDescriptionRender(it) }
  }
  Divider()
  Div(attrs = {
    id("${id}__content")
    classes(ShowcaseBoxStyle.content)
  }) {
    content()
  }
}
