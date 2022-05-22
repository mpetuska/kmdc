package dev.petuska.kmdc.data.table

import dev.petuska.kmdc.core.*
import org.w3c.dom.*
import kotlin.js.*

public external interface MDCDataTableRowSelectionChangedEventDetail {
  public val rowNumber: Number
  public val rowId: String?
  public val rowIndex: Int
  public val selected: Boolean?
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public fun MDCDataTableAttrsScope.onRowSelectionChanged(listener: MDCEventListener<MDCDataTableRowSelectionChangedEventDetail>) {
  addMdcEventListener(MDCDataTableModule.events.ROW_SELECTION_CHANGED, listener)
}

public external interface MDCDataTableRowClickEventDetail {
  public val rowId: String?
  public val row: HTMLElement
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public fun MDCDataTableAttrsScope.onRowClick(listener: MDCEventListener<MDCDataTableRowClickEventDetail>) {
  addMdcEventListener(MDCDataTableModule.events.ROW_CLICK, listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public fun MDCDataTableAttrsScope.onSelectedAll(listener: MDCEventListener<Json>) {
  addMdcEventListener(MDCDataTableModule.events.SELECTED_ALL, listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public fun MDCDataTableAttrsScope.onUnselectedAll(listener: MDCEventListener<Json>) {
  addMdcEventListener(MDCDataTableModule.events.UNSELECTED_ALL, listener)
}

public external interface MDCDataTableSortActionEventDetail {
  public val columnId: String?
  public val columnIndex: Number
  public val headerCell: HTMLElement
  public val sortValue: MDCDataTableModule.SortValue
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public fun MDCDataTableAttrsScope.onSorted(listener: MDCEventListener<MDCDataTableSortActionEventDetail>) {
  addMdcEventListener(MDCDataTableModule.events.SORTED, listener)
}
