package dev.petuska.kmdc.tab.scroller

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.initialiseMDC
import dev.petuska.kmdc.core.reinterpret
import dev.petuska.kmdc.tab.bar.MDCTabBarScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@JsModule("@material/tab-scroller/dist/mdc.tab-scroller.css")
private external val MDCTabScrollerCSS: dynamic

public interface MDCTabScrollerScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab-scroller)
 */
@MDCDsl
@Composable
public fun MDCTabBarScope.Scroller(
  attrs: AttrsBuilder<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCTabScrollerScope>? = null
) {
  MDCTabScrollerCSS
  Div(
    attrs = {
      classes("mdc-tab-scroller")
      initialiseMDC(MDCTabScrollerModule::MDCTabScroller)
      applyAttrs(attrs)
    }
  ) {
    Div(
      attrs = { classes("mdc-tab-scroller__scroll-area") }
    ) {
      Div(
        attrs = { classes("mdc-tab-scroller__scroll-content") },
        content = content.reinterpret()
      )
    }
  }
}
