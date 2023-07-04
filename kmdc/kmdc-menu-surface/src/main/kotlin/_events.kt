package dev.petuska.kmdc.menu.surface

import dev.petuska.kmdc.core.*
import org.w3c.dom.*

public interface MDCMenuSurfaceEventDetail {
  public val item: Element
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu-surface)
 */
@MDCAttrsDsl
public fun MDCMenuSurfaceAttrsScope.onClosed(listener: MDCEventListener<MDCMenuSurfaceEventDetail>) {
  addMdcEventListener("MDCMenuSurface:closed", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu-surface)
 */
@MDCAttrsDsl
public fun MDCMenuSurfaceAttrsScope.onClosing(listener: MDCEventListener<MDCMenuSurfaceEventDetail>) {
  addMdcEventListener("MDCMenuSurface:closing", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu-surface)
 */
@MDCAttrsDsl
public fun MDCMenuSurfaceAttrsScope.onOpened(listener: MDCEventListener<MDCMenuSurfaceEventDetail>) {
  addMdcEventListener("MDCMenuSurface:opened", listener)
}
