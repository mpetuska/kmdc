import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.menu.MDCMenuModule
import dev.petuska.kmdc.menu.MDCMenuScopeAttrsScope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-menu)
 */
@MDCAttrsDsl
public fun MDCMenuScopeAttrsScope.onSelected(listener: (event: MDCMenuModule.MDCMenuSelectedEvent) -> Unit) {
  addEventListener(MDCMenuModule.strings.SELECTED_EVENT) {
    listener(it.nativeEvent.unsafeCast<MDCMenuModule.MDCMenuSelectedEvent>())
  }
}
