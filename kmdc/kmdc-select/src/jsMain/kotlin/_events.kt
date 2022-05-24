package dev.petuska.kmdc.select

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEventListener
import dev.petuska.kmdc.core.addMdcEventListener

public external interface MDCSelectChangeEventDetail {
  public val value: String
  public val index: Int
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-select)
 */
@MDCAttrsDsl
public fun MDCSelectAttrsScope.onChange(listener: MDCEventListener<MDCSelectChangeEventDetail>) {
  addMdcEventListener("MDCSelect:change", listener)
}
