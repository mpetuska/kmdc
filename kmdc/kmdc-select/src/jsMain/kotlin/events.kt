package dev.petuska.kmdc.select

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.mdc
import org.w3c.dom.Element

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-select)
 */
@MDCAttrsDsl
public fun <T> MDCSelectAttrsScope<T>.onChange(listener: (value: T) -> Unit) {
  addEventListener(MDCSelectModule.strings.CHANGE_EVENT) {
    val event = it.nativeEvent.unsafeCast<MDCSelectModule.MDCSelectChangeEvent>()
    (event.currentTarget as? Element)
      ?.mdc<MDCSelectModule.MDCSelect<T>> {
        listener(items[event.detail.index])
      }
      ?: console.warn("MDCSelect component - current target not found for change event")
  }
}
