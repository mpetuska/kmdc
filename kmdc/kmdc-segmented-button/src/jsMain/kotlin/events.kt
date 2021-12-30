package dev.petuska.kmdc.segmented.button

import dev.petuska.kmdc.core.MDCAttrsDsl

@JsModule("@material/segmented-button/segmented-button/constants")
private external object SegmentedButtonModuleConstants {
  @Suppress("ClassName")
  object events {
    val CHANGE: String
    val SELECTED: String
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public fun MDCSegmentedButtonAttrsScope.onSegmentSelected(
  listener: (event: MDCSegmentedButtonModule.MDCSegmentedButtonEvent) -> Unit
) {
  addEventListener(SegmentedButtonModuleConstants.events.SELECTED) {
    listener(it.nativeEvent.unsafeCast<MDCSegmentedButtonModule.MDCSegmentedButtonEvent>())
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public fun MDCSegmentedButtonAttrsScope.onSegmentChange(
  listener: (event: MDCSegmentedButtonModule.MDCSegmentedButtonEvent) -> Unit
) {
  addEventListener(SegmentedButtonModuleConstants.events.CHANGE) {
    listener(it.nativeEvent.unsafeCast<MDCSegmentedButtonModule.MDCSegmentedButtonEvent>())
  }
}

@JsModule("@material/segmented-button/segment/constants")
private external object SegmentModuleConstants {
  @Suppress("ClassName")
  object events {
    val CLICK: String
    val SELECTED: String
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public fun MDCSegmentedButtonSegmentAttrsScope.onSegmentSelected(
  listener: (event: MDCSegmentedButtonModule.MDCSegmentedButtonSegmentEvent) -> Unit
) {
  addEventListener(SegmentModuleConstants.events.SELECTED) {
    listener(it.nativeEvent.unsafeCast<MDCSegmentedButtonModule.MDCSegmentedButtonSegmentEvent>())
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public fun MDCSegmentedButtonSegmentAttrsScope.onSegmentClick(
  listener: (event: MDCSegmentedButtonModule.MDCSegmentedButtonSegmentClickEvent) -> Unit
) {
  addEventListener(SegmentModuleConstants.events.CLICK) {
    listener(it.nativeEvent.unsafeCast<MDCSegmentedButtonModule.MDCSegmentedButtonSegmentClickEvent>())
  }
}
