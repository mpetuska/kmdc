package dev.petuska.kmdc.list

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEventListener
import dev.petuska.kmdc.core.addMdcEventListener

public external interface MDCListActionEventDetail {
  public val index: Int
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-list)
 */
@MDCAttrsDsl
public fun MDCListAttrsScope<*>.onAction(listener: MDCEventListener<MDCListActionEventDetail>) {
  addMdcEventListener("MDCList:action", listener)
}

public external interface MDCListSelectionChangedEventDetail {
  public val changedIndices: IntArray
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-list)
 */
@MDCAttrsDsl
public fun MDCListAttrsScope<*>.onSelectionChanged(listener: MDCEventListener<MDCListSelectionChangedEventDetail>) {
  addMdcEventListener("MDCList:selectionChange", listener)
}
