package dev.petuska.kmdc.tab

import dev.petuska.kmdc.core.MDCAttrsDsl

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab)
 */
@MDCAttrsDsl
public fun MDCTabAttrsScope.onInteracted(listener: (value: MDCTabModule.MDCTabInteractedEvent.Detail) -> Unit) {
  addEventListener("MDCTab:interacted") {
    listener(it.nativeEvent.unsafeCast<MDCTabModule.MDCTabInteractedEvent>().detail)
  }
}
