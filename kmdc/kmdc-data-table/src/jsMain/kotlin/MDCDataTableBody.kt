@file:Suppress("NOTHING_TO_INLINE")

package dev.petuska.kmdc.data.table

import androidx.compose.runtime.*
import dev.petuska.kmdc.checkbox.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.ContentBuilder
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

public sealed interface MDCDataTableBodyScope : ElementScope<HTMLTableSectionElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public fun MDCDataTableContainerScope.MDCDataTableBody(
  attrs: AttrsBuilder<HTMLTableSectionElement>? = null,
  content: MDCContent<MDCDataTableBodyScope>? = null,
) {
  Tbody(
    attrs = {
      classes("mdc-data-table__content")
      applyAttrs(attrs)
    },
    content = content?.reinterpret()
  )
}

public sealed interface MDCDataTableRowScope : ElementScope<HTMLTableRowElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public fun MDCDataTableBodyScope.MDCDataTableRow(
  attrs: AttrsBuilder<HTMLTableRowElement>? = null,
  selected: Boolean = false,
  content: MDCContent<MDCDataTableRowScope>? = null,
) {
  Tr(
    attrs = {
      classes("mdc-data-table__row")
      if (selected) classes("mdc-data-table__row--selected")
      aria("selected", true)
      applyAttrs(attrs)
    },
    content = content?.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public fun MDCDataTableRowScope.MDCDataTableCell(
  attrs: AttrsBuilder<HTMLTableCellElement>? = null,
  numeric: Boolean = false,
  content: ContentBuilder<HTMLTableCellElement>? = null,
) {
  Td(
    attrs = {
      classes("mdc-data-table__cell")
      if (numeric) classes("mdc-data-table__cell--numeric")
      applyAttrs(attrs)
    },
    content = content?.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public inline fun MDCDataTableRowScope.MDCDataTableCell(
  text: String,
  numeric: Boolean = false,
  noinline attrs: AttrsBuilder<HTMLTableCellElement>? = null,
) {
  MDCDataTableCell(attrs, numeric) { Text(text) }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public fun MDCDataTableRowScope.MDCDataTableHeaderCell(
  attrs: AttrsBuilder<HTMLTableCellElement>? = null,
  numeric: Boolean = false,
  selected: Boolean? = null,
  content: ContentBuilder<HTMLTableCellElement>? = null,
) {
  val id = rememberUniqueDomElementId()
  if (selected != null) {
    MDCDataTableCell(attrs = {
      classes("mdc-data-table__cell--checkbox")
    }) {
      MDCCheckbox(attrs = {
        classes("mdc-data-table__row-checkbox")
      }) {
        MDCCheckboxInput(selected, attrs = {
          aria("labeledby", id)
        })
        MDCCheckboxBackground()
        MDCCheckboxRipple()
      }
    }
  }
  Th(
    attrs = {
      classes("mdc-data-table__cell")
      scope(Scope.Row)
      if (numeric) classes("mdc-data-table__cell--numeric")
      if (selected != null) id(id)
      applyAttrs(attrs)
    },
    content = content?.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public inline fun MDCDataTableRowScope.MDCDataTableHeaderCell(
  text: String,
  numeric: Boolean = false,
  selected: Boolean? = null,
  noinline attrs: AttrsBuilder<HTMLTableCellElement>? = null,
) {
  MDCDataTableHeaderCell(
    attrs = attrs,
    numeric = numeric,
    selected = selected
  ) { Text(text) }
}
