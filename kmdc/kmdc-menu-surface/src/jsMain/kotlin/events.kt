package dev.petuska.kmdc.menu.surface

import androidx.compose.web.events.SyntheticEvent
import dev.petuska.kmdc.core.MDCAttrsDsl
import org.w3c.dom.events.EventTarget

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-menu-surface)
 */
@MDCAttrsDsl
public fun MDCMenuSurfaceAttrsScope.onClosed(listener: (event: SyntheticEvent<EventTarget>) -> Unit) {
  addEventListener(MDCMenuSurfaceModule.strings.CLOSED_EVENT, listener)
}

@MDCAttrsDsl
public fun MDCMenuSurfaceAttrsScope.onClosing(listener: (event: SyntheticEvent<EventTarget>) -> Unit) {
  addEventListener(MDCMenuSurfaceModule.strings.CLOSING_EVENT, listener)
}

@MDCAttrsDsl
public fun MDCMenuSurfaceAttrsScope.onOpened(listener: (event: SyntheticEvent<EventTarget>) -> Unit) {
  addEventListener(MDCMenuSurfaceModule.strings.OPENED_EVENT, listener)
}

