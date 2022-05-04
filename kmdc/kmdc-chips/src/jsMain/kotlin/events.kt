package dev.petuska.kmdc.chips

import dev.petuska.kmdc.core.MDCAttrsDsl

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCAttrsDsl
public fun MDCChipsAttrsScope.onInteraction(listener: (event: MDCChipsModule.MDCChipSet.InteractionEvent) -> Unit) {
  addEventListener("MDCChipSet:interaction") {
    listener(it.nativeEvent.unsafeCast<MDCChipsModule.MDCChipSet.InteractionEvent>())
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCAttrsDsl
public fun MDCChipsAttrsScope.onRemoval(listener: (event: MDCChipsModule.MDCChipSet.RemovalEvent) -> Unit) {
  addEventListener("MDCChipSet:removal") {
    listener(it.nativeEvent.unsafeCast<MDCChipsModule.MDCChipSet.RemovalEvent>())
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCAttrsDsl
public fun MDCChipsAttrsScope.onSelection(listener: (event: MDCChipsModule.MDCChipSet.SelectionEvent) -> Unit) {
  addEventListener("MDCChipSet:selection") {
    listener(it.nativeEvent.unsafeCast<MDCChipsModule.MDCChipSet.SelectionEvent>())
  }
}
