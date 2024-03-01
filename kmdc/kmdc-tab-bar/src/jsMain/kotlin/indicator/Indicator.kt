package dev.petuska.kmdc.tab.indicator

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.tab.MDCTabBaseScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

@JsModule("@material/tab-indicator/mdc-tab-indicator.scss")
private external val Style: dynamic

public enum class MDCTabIndicatorTransition(public vararg val classes: String) {
  Slide, Fade("mdc-tab-indicator--fade")
}

public interface MDCTabIndicatorScope : ElementScope<HTMLSpanElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab-indicator)
 */
@MDCContentDsl
@Composable
public fun MDCTabBaseScope.Indicator(
  active: Boolean = false,
  transition: MDCTabIndicatorTransition = MDCTabIndicatorTransition.Slide,
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContent<MDCTabIndicatorScope>? = null
) {
  Style
  Span(
    attrs = {
      classes("mdc-tab-indicator")
      if (active) classes("mdc-tab-indicator--active")
      classes(transition.classes)
      attrs?.invoke(this)
    },
    content = {
      MDCProvider(::MDCTabIndicator) {
        applyContent(content)
      }
    }
  )
}
