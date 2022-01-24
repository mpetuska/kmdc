package dev.petuska.kmdc.dialog

import dev.petuska.kmdc.core.MDCAttrsDsl

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onOpening(listener: () -> Unit) {
  addEventListener(MDCDialogConstants.strings.OPENING_EVENT) {
    listener()
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onOpened(listener: () -> Unit) {
  addEventListener(MDCDialogConstants.strings.OPENED_EVENT) {
    listener()
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onClosing(listener: (event: MDCDialogModule.MDCDialogCloseEvent) -> Unit) {
  addEventListener(MDCDialogConstants.strings.CLOSING_EVENT) {
    listener(it.nativeEvent.unsafeCast<MDCDialogModule.MDCDialogCloseEvent>())
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onClosed(listener: (event: MDCDialogModule.MDCDialogCloseEvent) -> Unit) {
  addEventListener(MDCDialogConstants.strings.CLOSED_EVENT) {
    listener(it.nativeEvent.unsafeCast<MDCDialogModule.MDCDialogCloseEvent>())
  }
}
