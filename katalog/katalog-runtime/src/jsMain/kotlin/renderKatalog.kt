package dev.petuska.katalog.runtime

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import dev.petuska.katalog.runtime.domain.Katalog
import dev.petuska.katalog.runtime.domain.Showcase
import dev.petuska.katalog.runtime.ui.Katalog
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.dom.appendElement
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.Element

private val KatalogLocal = staticCompositionLocalOf<Katalog> { error("undefined") }

internal inline val katalog
  @Composable
  get() = KatalogLocal.current

public fun renderKatalog(
  showcases: List<Showcase>,
  config: Katalog.Builder.() -> Unit = {},
) {
  val katalog = Katalog.Builder(showcases = showcases.toMutableList()).apply(config).build()
  val title = setupHTML(katalog)
  window.addEventListener("hashchange", {
    val component = window.location.hash.removePrefix("#").takeIf(String::isNotBlank)
    title?.textContent = katalog.title + (component?.let { " | $it" } ?: "")
  })
  renderComposable(rootElementId = "katalog") {
    Style(UtilStyle)
    CompositionLocalProvider(KatalogLocal provides katalog) {
      Katalog()
    }
  }
}

private fun setupHTML(katalog: Katalog): Element? {
  document.getElementById(katalog.id) ?: document.body?.appendElement("div") {
    id = katalog.id
  }
  return document.head?.run {
    appendElement("link") {
      setAttribute("rel", "preconnect")
      setAttribute("href", "https://fonts.googleapis.com")
    }
    appendElement("link") {
      setAttribute("rel", "preconnect")
      setAttribute("crossorigin", "")
      setAttribute("href", "https://fonts.gstatic.com")
    }
    appendElement("link") {
      setAttribute("rel", "stylesheet")
      setAttribute("href", "https://fonts.googleapis.com/css?family=Roboto:300,400,500")
    }
    val title = getElementsByTagName("title").item(0) ?: appendElement("title") { id = "title" }
    title.apply {
      textContent = katalog.title
    }
  }
}
