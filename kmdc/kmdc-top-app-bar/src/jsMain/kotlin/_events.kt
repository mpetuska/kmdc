package dev.petuska.kmdc.top.app.bar

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEventListener
import dev.petuska.kmdc.core.addMdcEventListener
import kotlin.js.Json

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCAttrsDsl
public fun MDCTopAppBarAttrsScope.onNav(listener: MDCEventListener<Json>) {
  addMdcEventListener("MDCTopAppBar:nav", listener)
}
