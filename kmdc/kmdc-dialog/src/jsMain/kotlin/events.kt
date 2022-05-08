package dev.petuska.kmdc.dialog

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.MDCEventHandler

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public val onOpening: MDCEventHandler<MDCDialogAttrsScope, MDCDialogModule.MDCDialogOpenEventDetail> =
  MDCEvent(MDCDialogModule.strings.OPENING_EVENT)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public val onOpened: MDCEventHandler<MDCDialogAttrsScope, MDCDialogModule.MDCDialogOpenEventDetail> =
  MDCEvent(MDCDialogModule.strings.OPENED_EVENT)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public val onClosing: MDCEventHandler<MDCDialogAttrsScope, MDCDialogModule.MDCDialogCloseEventDetail> =
  MDCEvent(MDCDialogModule.strings.CLOSING_EVENT)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public val onClosed: MDCEventHandler<MDCDialogAttrsScope, MDCDialogModule.MDCDialogCloseEventDetail> =
  MDCEvent(MDCDialogModule.strings.CLOSED_EVENT)
