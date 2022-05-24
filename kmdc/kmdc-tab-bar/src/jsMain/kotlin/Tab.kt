package dev.petuska.kmdc.tab

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.tab.scroller.MDCTabScrollerScope
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLButtonElement

@JsModule("@material/tab/dist/mdc.tab.css")
private external val MDCTabCSS: dynamic

public interface MDCTabAttrsScope : AttrsScope<HTMLButtonElement>
public interface MDCTabBaseScope
public interface MDCTabScope : ElementScope<HTMLButtonElement>, MDCTabBaseScope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab)
 */
@MDCDsl
@Composable
public fun MDCTabScrollerScope.Tab(
  active: Boolean = false,
  stacked: Boolean = false,
  minWidth: Boolean = false,
  attrs: MDCAttrs<MDCTabAttrsScope>? = null,
  content: MDCContent<MDCTabScope>? = null
) {
  MDCTabCSS
  context.tabs++
  Button(
    attrs = {
      classes("mdc-tab")
      role("tab")
      aria("selected", active)
      if (active) classes("mdc-tab--active")
      tabIndex(if (active) 0 else -1)
      if (stacked) classes("mdc-tab--stacked")
      if (minWidth) classes("mdc-tab--min-width")
      applyAttrs(attrs)
    },
    content = {
      MDCInitEffect(::MDCTab, stacked, minWidth)
      applyContent(content)
      Span(attrs = { classes("mdc-tab__ripple") })
    }
  )
}
