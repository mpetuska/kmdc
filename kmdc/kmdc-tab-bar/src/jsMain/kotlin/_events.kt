package dev.petuska.kmdc.tab

import dev.petuska.kmdc.core.*

public external interface MDCTabInteractedEventDetail {
  public val tabId: String
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab)
 */
@MDCAttrsDsl
public fun MDCTabAttrsScope.onInteracted(listener: MDCEventListener<MDCTabInteractedEventDetail>) {
  addMdcEventListener("MDCTab:interacted", listener)
}
