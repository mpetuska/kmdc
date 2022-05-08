package dev.petuska.kmdc.tab.indicator

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.classes
import dev.petuska.kmdc.core.initialiseMDC
import dev.petuska.kmdc.tab.MDCTabBaseScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

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
  content: ComposableBuilder<MDCTabIndicatorScope>? = null
) {
  MDCTabIndicatorCSS
  Span(
    attrs = {
      classes("mdc-tab-indicator")
      if (active) classes("mdc-tab-indicator--active")
      classes(transition.classes)
      initialiseMDC(MDCTabIndicatorModule::MDCTabIndicator)
      attrs?.invoke(this)
    },
    content = content?.let { { unsafeCast<MDCTabIndicatorScope>().it() } }
  )
}
