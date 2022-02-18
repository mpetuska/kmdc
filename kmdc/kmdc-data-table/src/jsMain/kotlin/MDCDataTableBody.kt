@file:Suppress("NOTHING_TO_INLINE")

package dev.petuska.kmdc.data.table

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.checkbox.MDCCheckboxBackground
import dev.petuska.kmdc.checkbox.MDCCheckboxInput
import dev.petuska.kmdc.checkbox.MDCCheckboxRipple
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.ContentBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.imply
import dev.petuska.kmdc.core.rememberUniqueDomElementId
import org.jetbrains.compose.web.attributes.Scope
import org.jetbrains.compose.web.attributes.scope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Tbody
import org.jetbrains.compose.web.dom.Td
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Th
import org.jetbrains.compose.web.dom.Tr
import org.w3c.dom.HTMLTableCellElement
import org.w3c.dom.HTMLTableRowElement
import org.w3c.dom.HTMLTableSectionElement

public sealed interface MDCDataTableBodyScope : ElementScope<HTMLTableSectionElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public fun MDCDataTableContainerScope.MDCDataTableBody(
  attrs: AttrsBuilder<HTMLTableSectionElement>? = null,
  content: ComposableBuilder<MDCDataTableBodyScope>? = null,
) {
  Tbody(
    attrs = {
      classes("mdc-data-table__content")
      applyAttrs(attrs)
    },
    content = content?.imply()
  )
}

public sealed interface MDCDataTableRowScope : ElementScope<HTMLTableRowElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public fun MDCDataTableBodyScope.MDCDataTableRow(
  attrs: AttrsBuilder<HTMLTableRowElement>? = null,
  selected: Boolean = false,
  content: ComposableBuilder<MDCDataTableRowScope>? = null,
) {
  Tr(
    attrs = {
      classes("mdc-data-table__row")
      if (selected) classes("mdc-data-table__row--selected")
      aria("selected", true)
      applyAttrs(attrs)
    },
    content = content?.imply()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
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
    content = content?.imply()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
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
    content = content?.imply()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
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
