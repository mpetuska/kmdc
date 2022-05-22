package dev.petuska.katalog.runtime.ui

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.domain.Showcase
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

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
  Hr(attrs = {
    style {
      width(100.percent)
      opacity(0.5)
      position(Position.Sticky)
      left(0.em)
    }
  })
  Div(attrs = {
    id("${id}__content")
    classes(ShowcaseBoxStyle.content)
  }) {
    content()
  }
}
