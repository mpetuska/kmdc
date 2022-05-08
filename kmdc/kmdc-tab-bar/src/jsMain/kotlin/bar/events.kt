package dev.petuska.kmdc.tab.bar

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEventListener
import dev.petuska.kmdc.core.addMdcEventListener

public external interface MDCTabBarActivatedEventDetail {
  public val index: Int
  public val tabId: String
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab-bar)
 */
@MDCAttrsDsl
public fun MDCTabBarAttrsScope.onClosing(listener: MDCEventListener<MDCTabBarActivatedEventDetail>) {
  addMdcEventListener("MDCTabBar:activated", listener)
}
