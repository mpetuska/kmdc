package dev.petuska.kmdc.segmented.button

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.MDCEventHandler
import dev.petuska.kmdc.core.MDCExternalAPI

@MDCExternalAPI
@JsModule("@material/segmented-button/segmented-button/constants")
private external object SegmentedButtonModuleConstants {
  @Suppress("ClassName")
  object events {
    val CHANGE: String
    val SELECTED: String
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public val onSegmentSelected: MDCEventHandler<MDCSegmentedButtonAttrsScope, MDCSegmentedButtonModule.MDCSegmentedButtonEventDetail> =
  MDCEvent(SegmentedButtonModuleConstants.events.SELECTED)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public val onSegmentChange: MDCEventHandler<MDCSegmentedButtonAttrsScope, MDCSegmentedButtonModule.MDCSegmentedButtonEventDetail> =
  MDCEvent(SegmentedButtonModuleConstants.events.CHANGE)

@JsModule("@material/segmented-button/segment/constants")
private external object SegmentModuleConstants {
  @Suppress("ClassName")
  object events {
    val CLICK: String
    val SELECTED: String
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public val onSelected: MDCEventHandler<MDCSegmentedButtonSegmentAttrsScope, MDCSegmentedButtonModule.MDCSegmentedButtonEventDetail> =
  MDCEvent(SegmentModuleConstants.events.SELECTED)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public val onClicked: MDCEventHandler<MDCSegmentedButtonSegmentAttrsScope, Number> =
  MDCEvent(SegmentModuleConstants.events.CLICK)
