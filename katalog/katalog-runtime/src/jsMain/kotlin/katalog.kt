package dev.petuska.katalog.runtime

import androidx.compose.runtime.Composable
import dev.petuska.katalog.runtime.domain.ShowcaseItem
import kotlinx.browser.document
import kotlinx.dom.appendElement
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

public fun renderKatalog(
  showcases: List<ShowcaseItem>,
  config: @Composable () -> Unit = {}
) {
  document.body?.appendElement("div") {
    id = "katalog"
  }
  renderComposable(rootElementId = "katalog") {
    config()
    showcases.forEach { it.render() }
  }
}

@Composable
private fun ShowcaseItem.render() {
  Div(attrs = {
    id(id)
    classes("katalog-showcase")
  }) {
    Div(attrs = {
      id("${id}__header")
      classes("katalog-showcase-header")
    }) {
      H3 { Text(title) }
      description?.let { H3 { Text(it) } }
    }
    Div(attrs = {
      id("${id}__content")
      classes("katalog-showcase-content")
    }) {
      content()
    }
  }
}
