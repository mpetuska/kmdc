package dev.petuska.kmdc.menu

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@JsModule("@material/menu-surface/dist/mdc.menu-surface.css")
public external val MDCMenuSurfaceStyle: dynamic

public data class MDCMenuSurfaceOpts(
  public var style: Style = Style.Default,
) {
  public enum class Style(public vararg val classes: String) {
    Default("mdc-menu-surface"),
    Anchored("mdc-menu-surface--anchor")
  }
}

public class MDCMenuSurfaceScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-menu-surface)
 */
@MDCDsl
@Composable
public fun MDCMenuSurface(
  opts: Builder<MDCMenuSurfaceOpts>? = null,
  attrs: Builder<AttrsBuilder<HTMLDivElement>>? = null,
  content: ComposableBuilder<MDCMenuSurfaceScope>? = null,
) {
  MDCMenuSurfaceStyle
  val options = MDCMenuSurfaceOpts().apply { opts?.invoke(this) }
  Div(attrs = {
    classes(*options.style.classes)
    attrs?.invoke(this)
  }) {
    content?.let { MDCMenuSurfaceScope(this).it() }
  }
}
