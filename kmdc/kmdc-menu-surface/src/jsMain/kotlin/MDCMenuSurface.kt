package dev.petuska.kmdc.menu.surface

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.core.domain.Point
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@JsModule("@material/menu-surface/mdc-menu-surface.scss")
private external val Style: dynamic

public interface MDCMenuSurfaceAttrsScope : AttrsScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu-surface)
 */
@MDCContentDsl
@Composable
public fun MDCMenuSurface(
  open: Boolean = false,
  fixed: Boolean = false,
  fullWidth: Boolean = false,
  anchorCorner: Corner = Corner.TOP_LEFT,
  quickOpen: Boolean = false,
  hoisted: Boolean = false,
  absolutePosition: Point? = null,
  restoreFocusOnClose: Boolean = true,
  attrs: MDCAttrs<MDCMenuSurfaceAttrsScope>? = null,
  content: MDCContentRaw<HTMLDivElement>? = null,
) {
  MDCMenuSurfaceLayout(fixed = fixed, fullWidth = fullWidth, attrs = attrs) {
    MDCProvider(::MDCMenuSurface) {
      MDCStateEffect(fixed, MDCMenuSurface::setFixedPosition)
      MDCStateEffect(quickOpen, MDCMenuSurface::quickOpen)
      MDCStateEffect(anchorCorner, MDCMenuSurface::setAnchorCorner)
      MDCStateEffect(hoisted, MDCMenuSurface::setIsHoisted)
      MDCSideEffect(absolutePosition) {
        absolutePosition?.let { (x, y) -> setAbsolutePosition(x, y) }
      }
      MDCSideEffect(open) {
        if (open) open() else close(!restoreFocusOnClose)
      }
      applyContent(content)
    }
  }
}

@KMDCInternalAPI
@Composable
public fun MDCMenuSurfaceLayout(
  fixed: Boolean = false,
  fullWidth: Boolean = false,
  attrs: MDCAttrs<MDCMenuSurfaceAttrsScope>? = null,
  content: ContentBuilder<HTMLDivElement>? = null,
) {
  Style
  Div(
    attrs = {
      classes("mdc-menu-surface")
      if (fixed) classes("mdc-menu-surface--fixed")
      if (fullWidth) classes("mdc-menu-surface--fullwidth")
      applyAttrs(attrs)
    },
    content = {
      applyContent(content)
    }
  )
}
