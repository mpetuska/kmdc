package dev.petuska.kmdc.menu.surface

import dev.petuska.kmdc.core.MDCAttrsDsl

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-menu-surface)
 */
@MDCAttrsDsl
public fun MDCMenuSurfaceAttrsScope.onClosed(listener: (event: MDCMenuSurfaceModule.MDCMenuSurfaceClosedEvent) -> Unit) {
  addEventListener(MDCMenuSurfaceModule.strings.CLOSED_EVENT) {
    listener(it.nativeEvent.unsafeCast<MDCMenuSurfaceModule.MDCMenuSurfaceClosedEvent>())
  }
}

@MDCAttrsDsl
public fun MDCMenuSurfaceAttrsScope.onClosing(listener: (event: MDCMenuSurfaceModule.MDCMenuSurfaceClosingEvent) -> Unit) {
  addEventListener(MDCMenuSurfaceModule.strings.CLOSING_EVENT) {
    listener(it.nativeEvent.unsafeCast<MDCMenuSurfaceModule.MDCMenuSurfaceClosingEvent>())
  }
}

@MDCAttrsDsl
public fun MDCMenuSurfaceAttrsScope.onOpened(listener: (event: MDCMenuSurfaceModule.MDCMenuSurfaceOpenedEvent) -> Unit) {
  addEventListener(MDCMenuSurfaceModule.strings.OPENED_EVENT) {
    listener(it.nativeEvent.unsafeCast<MDCMenuSurfaceModule.MDCMenuSurfaceOpenedEvent>())
  }
}
