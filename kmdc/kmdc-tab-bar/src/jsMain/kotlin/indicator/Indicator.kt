package dev.petuska.kmdc.tab.indicator

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.tab.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

@JsModule("@material/tab-indicator/dist/mdc.tab-indicator.css")
private external val MDCTabIndicatorCSS: dynamic

public enum class MDCTabIndicatorTransition(public vararg val classes: String) {
  Slide, Fade("mdc-tab-indicator--fade")
}

public interface MDCTabIndicatorScope : ElementScope<HTMLSpanElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab-indicator)
 */
@MDCDsl
@Composable
public fun MDCTabBaseScope.Indicator(
  active: Boolean = false,
  transition: MDCTabIndicatorTransition = MDCTabIndicatorTransition.Slide,
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
  content: MDCContent<MDCTabIndicatorScope>? = null
) {
  MDCTabIndicatorCSS
  Span(
    attrs = {
      classes("mdc-tab-indicator")
      if (active) classes("mdc-tab-indicator--active")
      classes(transition.classes)
      attrs?.invoke(this)
    },
    content = {
      MDCInitEffect(MDCTabIndicatorModule::MDCTabIndicator)
      applyContent(content)
    }
  )
}
