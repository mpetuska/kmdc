package dev.petuska.kmdc.segmented.button

import dev.petuska.kmdc.core.*

@MDCExternalAPI
@JsModule("@material/segmented-button/segmented-button/constants")
private external object SegmentedButtonModuleConstants {
  @Suppress("interfaceName")
  object events {
    val CHANGE: String
    val SELECTED: String
  }
}

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
  addMdcEventListener(SegmentedButtonModuleConstants.events.SELECTED, listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public fun MDCSegmentedButtonAttrsScope.onChange(listener: MDCEventListener<MDCSegmentedButtonEventDetail>) {
  addMdcEventListener(SegmentedButtonModuleConstants.events.CHANGE, listener)
}

@MDCExternalAPI
@JsModule("@material/segmented-button/segment/constants")
private external object SegmentModuleConstants {
  @Suppress("interfaceName")
  object events {
    val CLICK: String
    val SELECTED: String
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public fun MDCSegmentedButtonSegmentAttrsScope.onSelected(listener: MDCEventListener<MDCSegmentedButtonEventDetail>) {
  addMdcEventListener(SegmentModuleConstants.events.SELECTED, listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public fun MDCSegmentedButtonSegmentAttrsScope.onClicked(listener: MDCEventListener<Number>) {
  addMdcEventListener(SegmentModuleConstants.events.CLICK, listener)
}
