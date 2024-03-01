package dev.petuska.kmdc.slider

import dev.petuska.kmdc.core.*

public external interface MDCSliderChangeEventDetail {
  public val value: Number
  public val thumb: Int
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-slider)
 */
@MDCAttrsDsl
public fun MDCSliderAttrsScope.onChange(listener: MDCEventListener<MDCSliderChangeEventDetail>) {
  addMdcEventListener("MDCSlider:change", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-slider)
 */
@MDCAttrsDsl
public fun MDCSliderAttrsScope.onInput(listener: MDCEventListener<MDCSliderChangeEventDetail>) {
  addMdcEventListener("MDCSlider:input", listener)
}
