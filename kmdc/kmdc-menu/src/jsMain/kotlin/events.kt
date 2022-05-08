package dev.petuska.kmdc.menu

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.MDCEventHandler

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu)
 */
@MDCAttrsDsl
public val onSelected: MDCEventHandler<MDCMenuAttrsScope, MDCMenuModule.MDCMenuSelectedEventDetail> =
  MDCEvent(MDCMenuModule.strings.SELECTED_EVENT)
