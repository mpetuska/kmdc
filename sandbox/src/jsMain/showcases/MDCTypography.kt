package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.kmdc.core.ContentBuilder
import dev.petuska.kmdc.typography.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

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
