package dev.petuska.kmdc.slider

import dev.petuska.kmdc.core.MDCAttrsDsl

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-slider)
 */
@MDCAttrsDsl
public fun MDCSliderAttrsScope.onSliderChange(listener: (event: MDCSliderModule.MDCSliderChangeEvent) -> Unit) {
  addEventListener(MDCSliderModule.events.CHANGE) {
    listener(it.nativeEvent.unsafeCast<MDCSliderModule.MDCSliderChangeEvent>())
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-slider)
 */
@MDCAttrsDsl
public fun MDCSliderAttrsScope.onSliderInput(listener: (event: MDCSliderModule.MDCSliderChangeEvent) -> Unit) {
  addEventListener(MDCSliderModule.events.INPUT) {
    listener(it.nativeEvent.unsafeCast<MDCSliderModule.MDCSliderChangeEvent>())
  }
}
