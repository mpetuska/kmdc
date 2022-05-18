package dev.petuska.katalog.runtime.component

import androidx.compose.runtime.Composable
import dev.petuska.katalog.runtime.domain.Showcase
import dev.petuska.katalog.runtime.katalog
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.opacity
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Hr
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

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
  Div(attrs = {
    id("${id}__header")
    classes(ShowcaseBoxStyle.header)
  }) {
    A(location, attrs = {
      target(ATarget.Blank)
    }) {
      H3 { Text(title) }
    }
    description?.let { P { Text(it) } }
  }
  Hr(attrs = {
    style {
      width(100.percent)
      opacity(0.5)
    }
  })
  Div(attrs = {
    id("${id}__content")
    classes(ShowcaseBoxStyle.content)
  }) {
    content()
  }
}
