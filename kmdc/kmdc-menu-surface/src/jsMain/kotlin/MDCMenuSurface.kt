package dev.petuska.kmdc.menu.surface

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCInitEffect
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.applyContent
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@JsModule("@material/menu-surface/dist/mdc.menu-surface.css")
private external val MDCMenuSurfaceStyle: dynamic

public data class MDCMenuSurfaceOpts(
  public var fixed: Boolean = false,
  public var fullwidth: Boolean = false
)

public interface MDCMenuSurfaceAttrsScope : AttrsScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu-surface)
 */
@MDCDsl
@Composable
public fun MDCMenuSurface(
  opts: Builder<MDCMenuSurfaceOpts>? = null,
  attrs: Builder<MDCMenuSurfaceAttrsScope>? = null,
  content: ContentBuilder<HTMLDivElement>? = null,
) {
  MDCMenuSurfaceStyle
  val options = MDCMenuSurfaceOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-menu-surface")
      if (options.fixed) classes("mdc-menu-surface--fixed")
      if (options.fullwidth) classes("mdc-menu-surface--fullwidth")
      applyAttrs(attrs)
    },
    content = {
      MDCInitEffect(MDCMenuSurfaceModule::MDCMenuSurface)
      applyContent(content)
    }
  )
}
