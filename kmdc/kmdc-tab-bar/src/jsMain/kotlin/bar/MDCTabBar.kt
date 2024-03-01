package dev.petuska.kmdc.tab.bar

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@JsModule("@material/tab-bar/mdc-tab-bar.scss")
private external val Style: dynamic

public interface MDCTabBarAttrsScope : AttrsScope<HTMLDivElement>

internal class MDCTabBarContext {
  internal var tabs: Int by mutableStateOf(0)
}

internal val MDCTabBarContextLocal = strictCompositionLocalOf<MDCTabBarContext>()

public interface MDCTabBarScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab-bar)
 */
@MDCContentDsl
@Composable
public fun MDCTabBar(
  attrs: MDCAttrs<MDCTabBarAttrsScope>? = null,
  content: MDCContent<MDCTabBarScope>? = null
) {
  Style
  val context = remember { MDCTabBarContext() }
  Div(
    attrs = {
      classes("mdc-tab-bar")
      role("tablist")
      applyAttrs(attrs)
    },
    content = {
      CompositionLocalProvider(MDCTabBarContextLocal provides context) {
        MDCProvider(::MDCTabBar, context.tabs) {
          context.tabs = 0
          applyContent(content)
        }
      }
    },
  )
}
