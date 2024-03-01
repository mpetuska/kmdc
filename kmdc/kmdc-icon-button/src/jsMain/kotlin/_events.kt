package dev.petuska.kmdc.icon.button

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEventListener
import dev.petuska.kmdc.core.addMdcEventListener

public external interface MDCIconButtonToggleChangeEventDetail {
  public val isOn: Boolean
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-icon-button)
 */
@MDCAttrsDsl
public fun MDCIconButtonAttrsScope<*>.onChange(listener: MDCEventListener<MDCIconButtonToggleChangeEventDetail>) {
  addMdcEventListener("MDCIconButtonToggle:change", listener)
}
