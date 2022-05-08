package dev.petuska.kmdc.data.table

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.MDCEventHandler
import kotlin.js.Json

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public val onRowSelectionChanged: MDCEventHandler<MDCDataTableAttrsScope, MDCDataTableModule.MDCDataTableRowSelectionChangedEventDetail> =
  MDCEvent(MDCDataTableModule.events.ROW_SELECTION_CHANGED)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public val onRowClick: MDCEventHandler<MDCDataTableAttrsScope, MDCDataTableModule.RowClickEventDetail> =
  MDCEvent(MDCDataTableModule.events.ROW_CLICK)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public val onSelectedAll: MDCEventHandler<MDCDataTableAttrsScope, Json> =
  MDCEvent(MDCDataTableModule.events.SELECTED_ALL)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public val onUnselectedAll: MDCEventHandler<MDCDataTableAttrsScope, Json> =
  MDCEvent(MDCDataTableModule.events.UNSELECTED_ALL)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCAttrsDsl
public val onSorted: MDCEventHandler<MDCDataTableAttrsScope, MDCDataTableModule.SortActionEventDetail> =
  MDCEvent(MDCDataTableModule.events.SORTED)
