package dev.petuska.kmdc.data.table

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEventListener
import dev.petuska.kmdc.core.addMdcEventListener
import org.w3c.dom.HTMLElement
import kotlin.js.Json

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
public fun MDCDataTableAttrsScope.onRowSelectionChanged(
  listener: MDCEventListener<MDCDataTableRowSelectionChangedEventDetail>
) {
  addMdcEventListener("MDCDataTable:rowSelectionChanged", listener)
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
  addMdcEventListener("MDCDataTable:rowClick", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public fun MDCDataTableAttrsScope.onSelectedAll(listener: MDCEventListener<Json>) {
  addMdcEventListener("MDCDataTable:selectedAll", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public fun MDCDataTableAttrsScope.onUnselectedAll(listener: MDCEventListener<Json>) {
  addMdcEventListener("MDCDataTable:unselectedAll", listener)
}

public external interface MDCDataTableSortActionEventDetail {
  public val columnId: String?
  public val columnIndex: Number
  public val headerCell: HTMLElement
  public val sortValue: SortValue
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public fun MDCDataTableAttrsScope.onSorted(listener: MDCEventListener<MDCDataTableSortActionEventDetail>) {
  addMdcEventListener("MDCDataTable:sorted", listener)
}
