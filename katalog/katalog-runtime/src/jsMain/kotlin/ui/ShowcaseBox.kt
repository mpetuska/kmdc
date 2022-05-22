package dev.petuska.katalog.runtime.ui

import androidx.compose.runtime.Composable
import dev.petuska.katalog.runtime.domain.Showcase
import dev.petuska.katalog.runtime.katalog
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.opacity
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Hr

private object ShowcaseBoxStyle : StyleSheet() {
  val header by style {

  }
  val content by style {
    width(100.percent)
  }
}

@Composable
internal fun ShowcaseBox(showcase: Showcase) = with(showcase) {
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
