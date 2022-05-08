package dev.petuska.kmdc.tab.bar

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.MDCEventHandler

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab-bar)
 */
@MDCAttrsDsl
public val onActivated: MDCEventHandler<MDCTabBarAttrsScope, MDCTabBarModule.MDCTabBarActivatedEventDetail> =
  MDCEvent("MDCTab:interacted")
