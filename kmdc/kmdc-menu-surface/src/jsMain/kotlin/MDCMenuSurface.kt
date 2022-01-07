package dev.petuska.kmdc.menu.surface

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.initialiseMDC
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement

@JsModule("@material/menu-surface/dist/mdc.menu-surface.css")
private external val MDCMenuSurfaceStyle: dynamic

public data class MDCMenuSurfaceOpts(
  public var fixed: Boolean = false,
)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-menu-surface)
 */
@MDCDsl
@Composable
public fun MDCMenuSurface(
  opts: Builder<MDCMenuSurfaceOpts>? = null,
  attrs: Builder<AttrsBuilder<HTMLDivElement>>? = null,
  content: ComposableBuilder<ElementScope<HTMLElement>>? = null,
) {
  MDCMenuSurfaceStyle
  val options = MDCMenuSurfaceOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-menu-surface")
      if (options.fixed) classes("mdc-menu-surface--fixed")
      initialiseMDC(MDCMenuSurfaceModule.MDCMenuSurface::attachTo)
      attrs?.invoke(this)
    },
    content = content
  )
}
