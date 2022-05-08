package dev.petuska.kmdc.slider

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.MDCEventHandler

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-slider)
 */
@MDCAttrsDsl
public val onSliderChange: MDCEventHandler<MDCSliderAttrsScope, MDCSliderModule.MDCSliderChangeEventDetail> =
  MDCEvent(MDCSliderModule.events.CHANGE)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-slider)
 */
@MDCAttrsDsl
public val onSliderInput: MDCEventHandler<MDCSliderAttrsScope, MDCSliderModule.MDCSliderChangeEventDetail> =
  MDCEvent(MDCSliderModule.events.INPUT)
