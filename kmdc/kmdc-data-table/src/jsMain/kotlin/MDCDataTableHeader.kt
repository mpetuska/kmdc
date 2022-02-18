@file:Suppress("NOTHING_TO_INLINE")

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
import dev.petuska.kmdc.core.role
import dev.petuska.kmdc.data.table.MDCDataTableContainerScope
import org.jetbrains.compose.web.attributes.Scope
import org.jetbrains.compose.web.attributes.scope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Th
import org.jetbrains.compose.web.dom.Thead
import org.jetbrains.compose.web.dom.Tr
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
  attrs: AttrsBuilder<HTMLTableCellElement>? = null,
  numeric: Boolean = false,
  content: ContentBuilder<HTMLTableCellElement>? = null,
) {
  Th(
    attrs = {
      classes("mdc-data-table__header-cell")
      role("columnheader")
      scope(Scope.Col)
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
public inline fun MDCDataTableHeaderScope.MDCDataTableCell(
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
public inline fun MDCDataTableHeaderScope.MDCDataTableCell(
  selected: Boolean?,
  numeric: Boolean = false,
  label: String? = null,
  noinline attrs: AttrsBuilder<HTMLTableCellElement>? = null,
) {
  MDCDataTableCell(attrs = {
    classes("mdc-data-table__header-cell--checkbox")
    applyAttrs(attrs)
  }, numeric) {
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

