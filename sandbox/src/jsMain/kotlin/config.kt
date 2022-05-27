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
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.dom.A
import sandbox.util.requireModule

private external val process: dynamic

@KatalogConfig
fun Katalog.Builder.config() {
  requireModule("./sandbox.scss")
  document.body?.addClass("mdc-typography")

  debug = process.env.NODE_ENV == "development"
  title = "KMDC Katalog"
  subtitle = "Play around with various KMDC components"
  contentRootUrl = "https://github.com/mpetuska/kmdc/blob/master"
  theme = KatalogTheme(
    highlightColor = Color("#6200ee"),
    katalogTitleRender = {
      A(href = "https://github.com/mpetuska/kmdc", attrs = {
        target(ATarget.Blank)
      }) {
        MDCH4(it, attrs = {
          style {
            marginBottom(0.em)
          }
        })
      }
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
