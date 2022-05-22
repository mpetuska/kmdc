package sandbox

import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.domain.*
import dev.petuska.katalog.runtime.theme.*
import dev.petuska.kmdc.typography.*
import kotlinx.browser.*
import kotlinx.dom.*
import org.jetbrains.compose.web.css.*
import sandbox.util.*

@KatalogConfig
fun Katalog.Builder.config() {
  requireModule("./sandbox.scss")
  document.body?.addClass("mdc-typography")

  title = "KMDC Sandbox"
  subtitle = "Play around with various KMDC components"
  contentRootUrl = "https://github.com/mpetuska/kmdc/blob/master"
  theme = KatalogTheme(
    highlightColor = Color("#6200ee"),
    katalogTitleRender = {
      MDCH4(it, attrs = {
        style {
          marginBottom(0.em)
        }
      })
    },
    katalogSubtitleRender = { MDCSubtitle2(it) },
    navTitleRender = { it, selected ->
      MDCH6(it, attrs = {
        style {
          if (selected) color(Color.white)
        }
      })
    },
    showcaseTitleRender = { MDCH5(it) },
    showcaseDescriptionRender = { MDCSubtitle2(it) },
  )
}
