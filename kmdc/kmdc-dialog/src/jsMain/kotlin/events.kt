package dev.petuska.kmdc.dialog

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEventListener
import dev.petuska.kmdc.core.addMdcEventListener
import kotlin.js.Json

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onOpening(listener: MDCEventListener<Json>) {
  addMdcEventListener(MDCDialogModule.strings.OPENING_EVENT, listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onOpened(listener: MDCEventListener<Json>) {
  addMdcEventListener(MDCDialogModule.strings.OPENED_EVENT, listener)
}

public external interface MDCDialogCloseEventDetail {
  public val action: String?
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onClosing(listener: MDCEventListener<MDCDialogCloseEventDetail>) {
  addMdcEventListener(MDCDialogModule.strings.CLOSING_EVENT, listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onClosed(listener: MDCEventListener<MDCDialogCloseEventDetail>) {
  addMdcEventListener(MDCDialogModule.strings.CLOSED_EVENT, listener)
}
