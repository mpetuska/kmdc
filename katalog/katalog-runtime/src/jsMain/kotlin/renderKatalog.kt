package dev.petuska.katalog.runtime

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.domain.*
import dev.petuska.katalog.runtime.domain.Showcase
import dev.petuska.katalog.runtime.ui.*
import kotlinx.browser.*
import kotlinx.dom.*
import org.jetbrains.compose.web.*
import org.jetbrains.compose.web.css.*

internal val KatalogLocal = staticCompositionLocalOf<Katalog> { error("undefined") }

internal inline val katalog
  @Composable
  get() = KatalogLocal.current

public fun renderKatalog(
  showcases: List<Showcase>,
  config: Katalog.Builder.() -> Unit = {},
) {
  val katalog = Katalog.Builder(showcases = showcases.toMutableList()).apply(config).build()
  setupHTML(katalog)
  renderComposable(rootElementId = "katalog") {
    Style(UtilStyle)
    CompositionLocalProvider(KatalogLocal provides katalog) {
      Katalog()
    }
  }
}

private fun setupHTML(katalog: Katalog) {
  document.getElementById(katalog.id) ?: document.body?.appendElement("div") {
    id = katalog.id
  }
  document.head?.run {
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
    title.textContent = katalog.title
  }
}
