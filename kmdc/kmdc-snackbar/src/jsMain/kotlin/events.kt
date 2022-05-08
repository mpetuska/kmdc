package dev.petuska.kmdc.snackbar

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEventListener
import dev.petuska.kmdc.core.addMdcEventListener
import kotlin.js.Json

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCAttrsDsl
public fun MDCSnackbarAttrsScope.onOpening(listener: MDCEventListener<Json>) {
  addMdcEventListener("MDCSnackbar:opening", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCAttrsDsl
public fun MDCSnackbarAttrsScope.onOpened(listener: MDCEventListener<Json>) {
  addMdcEventListener("MDCSnackbar:opened", listener)
}

public interface MDCSnackbarCloseEventDetail {
  public val reason: String?
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCAttrsDsl
public fun MDCSnackbarAttrsScope.onClosing(listener: MDCEventListener<MDCSnackbarCloseEventDetail>) {
  addMdcEventListener("MDCSnackbar:closing", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCAttrsDsl
public fun MDCSnackbarAttrsScope.onClosed(listener: MDCEventListener<MDCSnackbarCloseEventDetail>) {
  addMdcEventListener("MDCSnackbar:closed", listener)
}
