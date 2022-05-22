package dev.petuska.kmdc.tab.bar

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

@JsModule("@material/tab-bar/dist/mdc.tab-bar.css")
private external val MDCTabBarCSS: dynamic

public interface MDCTabBarAttrsScope : AttrsScope<HTMLDivElement>

internal class MDCTabBarContext {
  internal var tabs: Int by mutableStateOf(0)

  fun applyFrom(other: MDCTabBarContext) {
    tabs = other.tabs
  }
}

public class MDCTabBarScope internal constructor(
  scope: ElementScope<HTMLDivElement>,
  internal val context: MDCTabBarContext
) :
  ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab-bar)
 */
@MDCDsl
@Composable
public fun MDCTabBar(
  attrs: MDCAttrs<MDCTabBarAttrsScope>? = null,
  content: MDCContent<MDCTabBarScope>? = null
) {
  MDCTabBarCSS
  val context = remember { MDCTabBarContext() }
  Div(
    attrs = {
      classes("mdc-tab-bar")
      role("tablist")
      applyAttrs(attrs)
    },
    content = {
      applyContent(content) { MDCTabBarScope(it, context) }
      MDCInitEffect(MDCTabBarModule::MDCTabBar, context.tabs)
    },
  )
}
