package dev.petuska.kmdc.tab.scroller

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.tab.bar.MDCTabBarContext
import dev.petuska.kmdc.tab.bar.MDCTabBarScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@JsModule("@material/tab-scroller/mdc-tab-scroller.scss")
private external val Style: dynamic

public interface MDCTabScrollerScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab-scroller)
 */
@MDCContentDsl
@Composable
public fun MDCTabBarScope.Scroller(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCTabScrollerScope>? = null
) {
  Style
  val context = remember { MDCTabBarContext() }
  Div(
    attrs = {
      classes("mdc-tab-scroller")
      applyAttrs(attrs)
    }
  ) {
    MDCProvider(::MDCTabScroller, context.tabs) {
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
}
