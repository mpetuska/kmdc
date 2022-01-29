import dev.petuska.kmdc.core.MDCAttrsDsl

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun MDCSelectAttrsScope.onChange(listener: (event: MDCSelectModule.MDCSelectChangeEvent) -> Unit) {
  addEventListener(MDCSelectConstants.strings.CHANGE_EVENT) {
    listener(it.nativeEvent.unsafeCast<MDCSelectModule.MDCSelectChangeEvent>())
  }
}
