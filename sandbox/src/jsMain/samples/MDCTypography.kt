package samples

import androidx.compose.runtime.Composable
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.core.ContentBuilder
import dev.petuska.kmdc.typography.MDCBody1
import dev.petuska.kmdc.typography.MDCBody2
import dev.petuska.kmdc.typography.MDCButtonText
import dev.petuska.kmdc.typography.MDCCaption
import dev.petuska.kmdc.typography.MDCH1
import dev.petuska.kmdc.typography.MDCH2
import dev.petuska.kmdc.typography.MDCH3
import dev.petuska.kmdc.typography.MDCH4
import dev.petuska.kmdc.typography.MDCH5
import dev.petuska.kmdc.typography.MDCH6
import dev.petuska.kmdc.typography.MDCOverline
import dev.petuska.kmdc.typography.MDCSubtitle1
import dev.petuska.kmdc.typography.MDCSubtitle2
import org.jetbrains.compose.web.css.CSSKeywordValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.keywords.CSSAutoKeyword
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@Composable
@Showcase(id = "MDCTypography")
fun MDCTypography() = InteractiveShowcase(viewModel = {}) {
  Render(first = true) { MDCH1("MDCH1") }
  Render { MDCH2("MDCH2") }
  Render { MDCH3("MDCH3") }
  Render { MDCH4("MDCH4") }
  Render { MDCH5("MDCH5") }
  Render { MDCH6("MDCH6") }
  Render { MDCButtonText("MDCButtonText") }
  Render { MDCOverline("MDCOverline") }
  Render { MDCCaption("MDCCaption") }
  Render { MDCSubtitle1("MDCSubtitle1") }
  Render { MDCSubtitle2("MDCSubtitle2") }
  Render { MDCBody1("MDCBody1") }
  Render { MDCBody2("MDCBody2") }
}

@Composable
private fun Render(first: Boolean = false, content: ContentBuilder<HTMLDivElement>) {
  Div(attrs = {
    style {
      border(1.px, LineStyle.Dotted, Color.gray)
      width(CSSKeywordValue("fit-content").unsafeCast<CSSAutoKeyword>())
      if (!first) marginTop(0.5.em)
    }
  }) {
    content()
  }
}
