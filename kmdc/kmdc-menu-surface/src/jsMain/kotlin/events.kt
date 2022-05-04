package dev.petuska.kmdc.menu.surface

import dev.petuska.kmdc.core.MDCAttrsDsl

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu-surface)
 */
@MDCAttrsDsl
public fun MDCMenuSurfaceAttrsScope.onClosed(listener: (event: MDCMenuSurfaceModule.MDCMenuSurfaceEvent) -> Unit) {
  addEventListener(MDCMenuSurfaceModule.strings.CLOSED_EVENT) {
    listener(it.nativeEvent.unsafeCast<MDCMenuSurfaceModule.MDCMenuSurfaceEvent>())
  }
}

@MDCAttrsDsl
public fun MDCMenuSurfaceAttrsScope.onClosing(listener: (event: MDCMenuSurfaceModule.MDCMenuSurfaceEvent) -> Unit) {
  addEventListener(MDCMenuSurfaceModule.strings.CLOSING_EVENT) {
    listener(it.nativeEvent.unsafeCast<MDCMenuSurfaceModule.MDCMenuSurfaceEvent>())
  }
}

@MDCAttrsDsl
public fun MDCMenuSurfaceAttrsScope.onOpened(listener: (event: MDCMenuSurfaceModule.MDCMenuSurfaceEvent) -> Unit) {
  addEventListener(MDCMenuSurfaceModule.strings.OPENED_EVENT) {
    listener(it.nativeEvent.unsafeCast<MDCMenuSurfaceModule.MDCMenuSurfaceEvent>())
  }
}
