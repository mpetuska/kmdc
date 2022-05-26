package dev.petuska.kmdc.data.table

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.checkbox.MDCCheckboxBackground
import dev.petuska.kmdc.checkbox.MDCCheckboxInput
import dev.petuska.kmdc.checkbox.MDCCheckboxRipple
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.Scope
import org.jetbrains.compose.web.attributes.scope
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLTableCellElement
import org.w3c.dom.HTMLTableRowElement
import org.w3c.dom.HTMLTableSectionElement

public interface MDCDataTableBodyScope : ElementScope<HTMLTableSectionElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCContentDsl
@Composable
public fun MDCDataTableContainerScope.Body(
  attrs: MDCAttrsRaw<HTMLTableSectionElement>? = null,
  content: MDCContent<MDCDataTableBodyScope>? = null,
) {
  Tbody(
    attrs = {
      classes("mdc-data-table__content")
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}

public sealed interface MDCDataTableRowScope : ElementScope<HTMLTableRowElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCContentDsl
@Composable
public fun MDCDataTableBodyScope.Row(
  selected: Boolean = false,
  attrs: MDCAttrsRaw<HTMLTableRowElement>? = null,
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
@MDCContentDsl
@Composable
public fun MDCDataTableRowScope.Cell(
  numeric: Boolean = false,
  attrs: MDCAttrsRaw<HTMLTableCellElement>? = null,
  content: MDCContentRaw<HTMLTableCellElement>? = null,
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
@MDCContentDsl
@Composable
public fun MDCDataTableRowScope.Cell(
  text: String,
  numeric: Boolean = false,
  attrs: MDCAttrsRaw<HTMLTableCellElement>? = null,
) {
  Cell(numeric = numeric, attrs = attrs) { Text(text) }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCContentDsl
@Composable
public fun MDCDataTableRowScope.HeaderCell(
  numeric: Boolean = false,
  selected: Boolean? = null,
  attrs: MDCAttrsRaw<HTMLTableCellElement>? = null,
  content: MDCContentRaw<HTMLTableCellElement>? = null,
) {
  val id = rememberUniqueDomElementId()
  if (selected != null) {
    Cell(attrs = {
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
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCContentDsl
@Composable
public fun MDCDataTableRowScope.HeaderCell(
  text: String,
  numeric: Boolean = false,
  selected: Boolean? = null,
  attrs: MDCAttrsRaw<HTMLTableCellElement>? = null,
) {
  HeaderCell(
    attrs = attrs,
    numeric = numeric,
    selected = selected
  ) { Text(text) }
}
