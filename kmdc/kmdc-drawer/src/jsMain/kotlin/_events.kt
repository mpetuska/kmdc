package dev.petuska.kmdc.drawer

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEventListener
import dev.petuska.kmdc.core.addMdcEventListener
import kotlin.js.Json

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-drawer)
 */
@MDCAttrsDsl
public fun MDCDrawerAttrsScope.onOpened(listener: MDCEventListener<Json>) {
  addMdcEventListener("MDCDrawer:opened", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-drawer)
 */
@MDCAttrsDsl
public fun MDCDrawerAttrsScope.onClosed(listener: MDCEventListener<Json>) {
  addMdcEventListener("MDCDrawer:closed", listener)
}
