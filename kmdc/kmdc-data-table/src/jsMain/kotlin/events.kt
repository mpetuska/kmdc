package dev.petuska.kmdc.data.table

import dev.petuska.kmdc.core.MDCAttrsDsl

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public fun MDCDataTableAttrsScope.onRowSelectionChanged(listener: (event: MDCDataTableModule.MDCRowSelectionChangedEvent) -> Unit) {
  addEventListener(MDCDataTableModule.events.ROW_SELECTION_CHANGED) {
    listener(it.nativeEvent.unsafeCast<MDCDataTableModule.MDCRowSelectionChangedEvent>())
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public fun MDCDataTableAttrsScope.onRowClick(listener: (event: MDCDataTableModule.MDCRowClickEvent) -> Unit) {
  addEventListener(MDCDataTableModule.events.ROW_CLICK) {
    listener(it.nativeEvent.unsafeCast<MDCDataTableModule.MDCRowClickEvent>())
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public fun MDCDataTableAttrsScope.onSelectedAll(listener: (event: MDCDataTableModule.MDCSelectedAllEvent) -> Unit) {
  addEventListener(MDCDataTableModule.events.SELECTED_ALL) {
    listener(it.nativeEvent.unsafeCast<MDCDataTableModule.MDCSelectedAllEvent>())
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public fun MDCDataTableAttrsScope.onUnselectedAll(listener: (event: MDCDataTableModule.MDCSelectedAllEvent) -> Unit) {
  addEventListener(MDCDataTableModule.events.UNSELECTED_ALL) {
    listener(it.nativeEvent.unsafeCast<MDCDataTableModule.MDCSelectedAllEvent>())
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public fun MDCDataTableAttrsScope.onSorted(listener: (event: MDCDataTableModule.MDCSortedEvent) -> Unit) {
  addEventListener(MDCDataTableModule.events.SORTED) {
    listener(it.nativeEvent.unsafeCast<MDCDataTableModule.MDCSortedEvent>())
  }
}
