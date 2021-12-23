package local.sandbox.samples

import androidx.compose.runtime.Composable
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
import local.sandbox.engine.Sample
import local.sandbox.engine.Samples
import org.jetbrains.compose.web.css.CSSKeywordValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.keywords.CSSAutoKeyword
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@Suppress("unused")
val TypographySamples = Samples("Typography") {
  @Composable
  fun Render(content: ContentBuilder<HTMLDivElement>) {
    Div(attrs = {
      style {
        border(1.px, LineStyle.Dotted, Color.gray)
        width(CSSKeywordValue("fit-content").unsafeCast<CSSAutoKeyword>())
      }
    }) {
      content()
    }
  }

  var span = 12u
  Sample(span) {
    Render { MDCH1("MDCH1") }
  }
  span = 6u
  Sample(span) {
    Render { MDCH2("MDCH2") }
  }
  Sample(span) {
    Render { MDCH3("MDCH3") }
  }
  span = 4u
  Sample(span) {
    Render { MDCH4("MDCH4") }
  }
  Sample(span) {
    Render { MDCH5("MDCH5") }
  }
  Sample(span) {
    Render { MDCH6("MDCH6") }
  }
  Sample(span) {
    Render { MDCButtonText("MDCButtonText") }
  }
  Sample(span) {
    Render { MDCOverline("MDCOverline") }
  }
  Sample(span) {
    Render { MDCCaption("MDCCaption") }
  }
  span = 3u
  Sample(span) {
    Render { MDCSubtitle1("MDCSubtitle1") }
  }
  Sample(span) {
    Render { MDCSubtitle2("MDCSubtitle2") }
  }
  Sample(span) {
    Render { MDCBody1("MDCBody1") }
  }
  Sample(span) {
    Render { MDCBody2("MDCBody2") }
  }
}
