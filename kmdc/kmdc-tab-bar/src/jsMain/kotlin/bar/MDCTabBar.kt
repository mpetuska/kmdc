package dev.petuska.kmdc.tab.bar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCInitEffect
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.applyContent
import dev.petuska.kmdc.core.role
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

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
  attrs: Builder<MDCTabBarAttrsScope>? = null,
  content: ComposableBuilder<MDCTabBarScope>? = null
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
