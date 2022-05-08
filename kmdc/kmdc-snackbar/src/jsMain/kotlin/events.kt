package dev.petuska.kmdc.snackbar

import MDCSnackbarModule
import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.MDCEventHandler

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCAttrsDsl
public val onOpening: MDCEventHandler<MDCSnackbarAttrsScope, MDCSnackbarModule.MDCSnackbarOpenEventDetail> =
  MDCEvent("MDCSnackbar:opening")

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCAttrsDsl
public val onOpened: MDCEventHandler<MDCSnackbarAttrsScope, MDCSnackbarModule.MDCSnackbarOpenEventDetail> =
  MDCEvent("MDCSnackbar:opened")

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCAttrsDsl
public val onClosing: MDCEventHandler<MDCSnackbarAttrsScope, MDCSnackbarModule.MDCSnackbarCloseEventDetail> =
  MDCEvent("MDCSnackbar:closing")

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCAttrsDsl
public val onClosed: MDCEventHandler<MDCSnackbarAttrsScope, MDCSnackbarModule.MDCSnackbarCloseEventDetail> =
  MDCEvent("MDCSnackbar:closed")
