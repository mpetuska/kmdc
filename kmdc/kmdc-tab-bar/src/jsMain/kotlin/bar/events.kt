package dev.petuska.kmdc.tab.bar

import dev.petuska.kmdc.core.MDCAttrsDsl

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-tab-bar)
 */
@MDCAttrsDsl
public fun MDCTabBarAttrsScope.onActivated(listener: (value: MDCTabBarModule.MDCTabBarActivatedEvent.Detail) -> Unit) {
  addEventListener("MDCTab:interacted") {
    listener(it.nativeEvent.unsafeCast<MDCTabBarModule.MDCTabBarActivatedEvent>().detail)
  }
}
