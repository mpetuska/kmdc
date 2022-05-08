package dev.petuska.kmdc.tab

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.MDCEventHandler

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab)
 */
@MDCAttrsDsl
public val onInteracted: MDCEventHandler<MDCTabAttrsScope, MDCTabModule.MDCTabInteractedEventDetail> =
  MDCEvent("MDCTab:interacted")
