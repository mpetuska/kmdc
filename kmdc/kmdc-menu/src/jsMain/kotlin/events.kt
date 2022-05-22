package dev.petuska.kmdc.menu

import dev.petuska.kmdc.core.*
import org.w3c.dom.*

public external interface MDCMenuSelectedEventDetail {
  public val item: Element
  public val index: Int
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu)
 */
@MDCAttrsDsl
public fun MDCMenuAttrsScope.onSelected(listener: MDCEventListener<MDCMenuSelectedEventDetail>) {
  addMdcEventListener("MDCMenu:selected", listener)
}
