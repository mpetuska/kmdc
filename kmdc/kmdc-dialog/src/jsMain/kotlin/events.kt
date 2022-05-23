package dev.petuska.kmdc.dialog

import dev.petuska.kmdc.core.*
import kotlin.js.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onOpening(listener: MDCEventListener<Json>) {
  addMdcEventListener("MDCDialog:opening", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onOpened(listener: MDCEventListener<Json>) {
  addMdcEventListener("MDCDialog:opened", listener)
}

public external interface MDCDialogCloseEventDetail {
  public val action: String?
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onClosing(listener: MDCEventListener<MDCDialogCloseEventDetail>) {
  addMdcEventListener("MDCDialog:closing", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onClosed(listener: MDCEventListener<MDCDialogCloseEventDetail>) {
  addMdcEventListener("MDCDialog:closed", listener)
}
