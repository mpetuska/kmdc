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
import dev.petuska.kmdc.core.role
import dev.petuska.kmdc.icon.button.MDCIconButton
import dev.petuska.kmdc.icon.button.MDCIconButtonScope
import org.jetbrains.compose.web.attributes.Scope
import org.jetbrains.compose.web.attributes.scope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Th
import org.jetbrains.compose.web.dom.Thead
import org.jetbrains.compose.web.dom.Tr
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLTableCellElement
import org.w3c.dom.HTMLTableRowElement

public sealed interface MDCDataTableHeaderScope : ElementScope<HTMLTableRowElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public fun MDCDataTableContainerScope.MDCDataTableHeader(
  attrs: AttrsBuilder<HTMLTableRowElement>? = null,
  content: ComposableBuilder<MDCDataTableHeaderScope>? = null,
) {
  Thead {
    Tr(
      attrs = {
        classes("mdc-data-table__header-row")
        applyAttrs(attrs)
      },
      content = content?.imply()
    )
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public fun MDCDataTableHeaderScope.MDCDataTableCell(
  numeric: Boolean = false,
  attrs: AttrsBuilder<HTMLTableCellElement>? = null,
  content: ContentBuilder<HTMLTableCellElement>? = null,
) {
  Th(
    attrs = {
      classes("mdc-data-table__header-cell")
      role("columnheader")
      scope(Scope.Col)
      if (numeric) classes("mdc-data-table__header-cell--numeric")
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
public inline fun MDCDataTableHeaderScope.MDCDataTableCell(
  text: String,
  numeric: Boolean = false,
  noinline attrs: AttrsBuilder<HTMLTableCellElement>? = null,
) {
  MDCDataTableCell(numeric, attrs) { Text(text) }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public inline fun MDCDataTableHeaderScope.MDCDataTableCheckCell(
  selected: Boolean?,
  numeric: Boolean = false,
  label: String? = null,
  noinline attrs: AttrsBuilder<HTMLTableCellElement>? = null,
) {
  MDCDataTableCell(
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public fun MDCDataTableHeaderScope.MDCDataTableSortCell(
  columnId: String,
  numeric: Boolean = false,
  label: String? = null,
  attrs: AttrsBuilder<HTMLTableCellElement>? = null,
  buttonAttrs: AttrsBuilder<HTMLButtonElement>? = null,
  buttonContent: ComposableBuilder<MDCIconButtonScope>? = null,
) {
  val id = rememberUniqueDomElementId()
  MDCDataTableCell(
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
