package dev.petuska.kmdc.segmented.button

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEventListener
import dev.petuska.kmdc.core.addMdcEventListener

public external interface MDCSegmentedButtonEventDetail {
  public val index: Number
  public val selected: Boolean
  public val segmentId: String?
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public fun MDCSegmentedButtonAttrsScope.onSelected(listener: MDCEventListener<MDCSegmentedButtonEventDetail>) {
  addMdcEventListener("selected", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public fun MDCSegmentedButtonAttrsScope.onChange(listener: MDCEventListener<MDCSegmentedButtonEventDetail>) {
  addMdcEventListener("change", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public fun MDCSegmentedButtonSegmentAttrsScope.onSelected(listener: MDCEventListener<MDCSegmentedButtonEventDetail>) {
  addMdcEventListener("selected", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public fun MDCSegmentedButtonSegmentAttrsScope.onClicked(listener: MDCEventListener<Number>) {
  addMdcEventListener("click", listener)
}
