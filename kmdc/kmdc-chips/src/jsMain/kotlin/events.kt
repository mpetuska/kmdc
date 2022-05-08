package dev.petuska.kmdc.chips

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEventListener
import dev.petuska.kmdc.core.addMdcEventListener

public external interface MDCChipSetInteractionEventDetail {
  public val chipID: String
  public val chipIndex: Int
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCAttrsDsl
public fun MDCChipsAttrsScope.onInteraction(listener: MDCEventListener<MDCChipSetInteractionEventDetail>) {
  addMdcEventListener("MDCChipSet:interaction", listener)
}

public external interface MDCChipSetRemovalEventDetail : MDCChipSetInteractionEventDetail {
  public val isComplete: Boolean
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCAttrsDsl
public fun MDCChipsAttrsScope.onRemoval(listener: MDCEventListener<MDCChipSetRemovalEventDetail>) {
  addMdcEventListener("MDCChipSet:removal", listener)
}

public external interface MDCChipSetSelectionEventDetail : MDCChipSetInteractionEventDetail {
  public val isSelected: Boolean
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCAttrsDsl
public fun MDCChipsAttrsScope.onSelection(listener: MDCEventListener<MDCChipSetSelectionEventDetail>) {
  addMdcEventListener("MDCChipSet:selection", listener)
}
