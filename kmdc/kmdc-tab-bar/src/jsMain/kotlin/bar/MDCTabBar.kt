package dev.petuska.kmdc.tab.bar

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.initialiseMDC
import dev.petuska.kmdc.core.reinterpret
import dev.petuska.kmdc.core.role
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@JsModule("@material/tab-bar/dist/mdc.tab-bar.css")
private external val MDCTabBarCSS: dynamic

public interface MDCTabBarAttrsScope : AttrsScope<HTMLDivElement>
public interface MDCTabBarScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-tab-bar)
 */
@MDCDsl
@Composable
public fun MDCTabBar(
  attrs: Builder<MDCTabBarAttrsScope>? = null,
  content: ComposableBuilder<MDCTabBarScope>? = null
) {
  MDCTabBarCSS
  Div(
    attrs = {
      classes("mdc-tab-bar")
      role("tablist")
      initialiseMDC(MDCTabBarModule::MDCTabBar)
      applyAttrs(attrs)
    },
    content = content.reinterpret(),
  )
}
