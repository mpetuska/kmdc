import androidx.compose.web.events.SyntheticEvent
import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.menu.MDCMenuAttrsScope
import dev.petuska.kmdc.menu.MDCMenuModule
import dev.petuska.kmdc.menu.surface.MDCMenuSurfaceModule
import org.w3c.dom.events.EventTarget

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-menu)
 */
@MDCAttrsDsl
public fun MDCMenuAttrsScope.onSelected(listener: (event: MDCMenuModule.MDCMenuSelectedEvent) -> Unit) {
  addEventListener(MDCMenuModule.strings.SELECTED_EVENT) {
    listener(it.nativeEvent.unsafeCast<MDCMenuModule.MDCMenuSelectedEvent>())
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-menu-surface)
 */
@MDCAttrsDsl
public fun MDCMenuAttrsScope.onClosed(listener: (event: SyntheticEvent<EventTarget>) -> Unit) {
  addEventListener(MDCMenuSurfaceModule.strings.CLOSED_EVENT, listener)
}

@MDCAttrsDsl
public fun MDCMenuAttrsScope.onClosing(listener: (event: SyntheticEvent<EventTarget>) -> Unit) {
  addEventListener(MDCMenuSurfaceModule.strings.CLOSING_EVENT, listener)
}

@MDCAttrsDsl
public fun MDCMenuAttrsScope.onOpened(listener: (event: SyntheticEvent<EventTarget>) -> Unit) {
  addEventListener(MDCMenuSurfaceModule.strings.OPENED_EVENT, listener)
}
