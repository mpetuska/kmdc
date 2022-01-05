package dev.petuska.kmdc.menu.surface

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@JsModule("@material/menu-surface/dist/mdc.menu-surface.css")
private external val MDCMenuSurfaceStyle: dynamic

public class MDCMenuSurfaceAnchorAttrsScope private constructor() : AttrsBuilder<HTMLDivElement>()

public class MDCMenuSurfaceAnchorScope(scope: ElementScope<HTMLDivElement>) :
  ElementScope<HTMLDivElement> by scope

@MDCDsl
@Composable
public fun MDCMenuSurfaceAnchor(
  attrs: Builder<MDCMenuSurfaceAnchorAttrsScope>? = null,
  content: ComposableBuilder<MDCMenuSurfaceAnchorScope>? = null,
) {
  MDCMenuSurfaceStyle
  Div(attrs = {
    classes("mdc-menu-surface--anchor")
    attrs?.invoke(this.unsafeCast<MDCMenuSurfaceAnchorAttrsScope>())
  }) {
    content?.let { MDCMenuSurfaceAnchorScope(this).it() }
  }
}
