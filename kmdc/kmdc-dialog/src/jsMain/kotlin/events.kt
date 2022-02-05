package dev.petuska.kmdc.dialog

import dev.petuska.kmdc.core.MDCAttrsDsl

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onOpening(listener: (event: MDCDialogModule.MDCDialogOpenEvent) -> Unit) {
  addEventListener(MDCDialogModule.strings.OPENING_EVENT) {
    listener(it.nativeEvent.unsafeCast<MDCDialogModule.MDCDialogOpenEvent>())
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onOpened(listener: (event: MDCDialogModule.MDCDialogOpenEvent) -> Unit) {
  addEventListener(MDCDialogModule.strings.OPENED_EVENT) {
    listener(it.nativeEvent.unsafeCast<MDCDialogModule.MDCDialogOpenEvent>())
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onClosing(listener: (event: MDCDialogModule.MDCDialogCloseEvent) -> Unit) {
  addEventListener(MDCDialogModule.strings.CLOSING_EVENT) {
    listener(it.nativeEvent.unsafeCast<MDCDialogModule.MDCDialogCloseEvent>())
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCDialogAttrsScope.onClosed(listener: (event: MDCDialogModule.MDCDialogCloseEvent) -> Unit) {
  addEventListener(MDCDialogModule.strings.CLOSED_EVENT) {
    listener(it.nativeEvent.unsafeCast<MDCDialogModule.MDCDialogCloseEvent>())
  }
}
