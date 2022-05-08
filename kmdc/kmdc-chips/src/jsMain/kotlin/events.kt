package dev.petuska.kmdc.chips

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.MDCEventHandler

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCAttrsDsl
public val onInteraction: MDCEventHandler<MDCChipsAttrsScope, MDCChipsModule.MDCChipSet.InteractionEventDetail> =
  MDCEvent("MDCChipSet:interaction")

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCAttrsDsl
public val onRemoval: MDCEventHandler<MDCChipsAttrsScope, MDCChipsModule.MDCChipSet.RemovalEventDetail> =
  MDCEvent("MDCChipSet:removal")

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCAttrsDsl
public val onSelection: MDCEventHandler<MDCChipsAttrsScope, MDCChipsModule.MDCChipSet.SelectionEventDetail> =
  MDCEvent("MDCChipSet:selection")
