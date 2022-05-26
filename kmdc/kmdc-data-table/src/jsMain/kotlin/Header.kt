package dev.petuska.kmdc.data.table

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.checkbox.MDCCheckboxBackground
import dev.petuska.kmdc.checkbox.MDCCheckboxInput
import dev.petuska.kmdc.checkbox.MDCCheckboxRipple
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.icon.button.MDCIconButton
import dev.petuska.kmdc.icon.button.MDCIconButtonScope
import org.jetbrains.compose.web.attributes.Scope
import org.jetbrains.compose.web.attributes.scope
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLTableCellElement
import org.w3c.dom.HTMLTableRowElement

public interface MDCDataTableHeaderScope : ElementScope<HTMLTableRowElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCContentDsl
@Composable
public fun MDCDataTableContainerScope.MDCDataTableHeader(
  attrs: MDCAttrsRaw<HTMLTableRowElement>? = null,
  content: MDCContent<MDCDataTableHeaderScope>? = null,
) {
  Thead {
    Tr(
      attrs = {
        classes("mdc-data-table__header-row")
        applyAttrs(attrs)
      },
      content = content?.reinterpret()
    )
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCContentDsl
@Composable
public fun MDCDataTableHeaderScope.Cell(
  numeric: Boolean = false,
  attrs: MDCAttrsRaw<HTMLTableCellElement>? = null,
  content: MDCContentRaw<HTMLTableCellElement>? = null,
) {
  Th(
    attrs = {
      classes("mdc-data-table__header-cell")
      role("columnheader")
      scope(Scope.Col)
      if (numeric) classes("mdc-data-table__header-cell--numeric")
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
public fun MDCDataTableHeaderScope.Cell(
  text: String,
  numeric: Boolean = false,
  attrs: MDCAttrsRaw<HTMLTableCellElement>? = null,
) {
  Cell(numeric, attrs) { Text(text) }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCContentDsl
@Composable
public fun MDCDataTableHeaderScope.MDCDataTableCheckCell(
  selected: Boolean?,
  numeric: Boolean = false,
  label: String? = null,
  attrs: MDCAttrsRaw<HTMLTableCellElement>? = null,
) {
  Cell(
    numeric = numeric,
    attrs = {
      classes("mdc-data-table__header-cell--checkbox")
      applyAttrs(attrs)
    }
  ) {
    MDCCheckbox(attrs = {
      classes("mdc-data-table__header-row-checkbox")
    }) {
      MDCCheckboxInput(
        checked = selected,
        attrs = {
          if (label != null) aria("label", label)
        }
      )
      MDCCheckboxBackground()
      MDCCheckboxRipple()
    }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCContentDsl
@Composable
public fun MDCDataTableHeaderScope.MDCDataTableSortCell(
  columnId: String,
  numeric: Boolean = false,
  label: String? = null,
  attrs: MDCAttrsRaw<HTMLTableCellElement>? = null,
  buttonAttrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  buttonContent: MDCContent<MDCIconButtonScope<HTMLButtonElement>>? = null,
) {
  val id = rememberUniqueDomElementId()
  Cell(
    attrs = {
      classes("mdc-data-table__header-cell--with-sort")
      aria("sort", "none")
      attr("data-column-id", columnId)
      applyAttrs(attrs)
    },
    numeric = numeric,
  ) {
    Div(attrs = {
      classes("mdc-data-table__header-cell-wrapper")
    }) {
      MDCIconButton(
        attrs = {
          classes("mdc-data-table__sort-icon-button")
          aria("describedby", id)
          applyAttrs(buttonAttrs)
        },
        content = buttonContent,
      )
      if (label != null) {
        Div(attrs = {
          classes("mdc-data-table__header-cell-label")
        }) { Text(label) }
      }
      Div(attrs = {
        classes("mdc-data-table__sort-status-label")
        aria("hidden", true)
        id(id)
      })
    }
  }
}
