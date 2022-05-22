package sandbox

import dev.petuska.katalog.runtime.KatalogConfig
import dev.petuska.katalog.runtime.domain.Katalog
import dev.petuska.katalog.runtime.theme.KatalogTheme
import dev.petuska.kmdc.typography.MDCH4
import dev.petuska.kmdc.typography.MDCH5
import dev.petuska.kmdc.typography.MDCH6
import dev.petuska.kmdc.typography.MDCSubtitle2
import kotlinx.browser.document
import kotlinx.dom.addClass
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.marginBottom
import sandbox.util.requireModule

@KatalogConfig
fun Katalog.Builder.config() {
  requireModule("./sandbox.scss")
  document.body?.addClass("mdc-typography")

  title = "KMDC Sandbox"
  subtitle = "Play around with various KMDC components"
  contentRootUrl = "https://github.com/mpetuska/kmdc/blob/master"
  theme = KatalogTheme(
    highlightColor = Color("#AD26EAF2"),
    katalogTitleRender = {
      MDCH4(it, attrs = {
        style {
          marginBottom(0.em)
        }
      })
    },
    katalogSubtitleRender = {
      MDCSubtitle2(it, attrs = {
        style { }
      })
    },
    navTitleRender = { MDCH6(it) },
    showcaseTitleRender = { MDCH5(it) },
    showcaseDescriptionRender = { MDCSubtitle2(it) },
  )
}
