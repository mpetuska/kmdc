package dev.petuska.kmdc.data.table

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Table
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLTableElement

@JsModule("@material/data-table/mdc-data-table.scss")
private external val Style: dynamic

public interface MDCDataTableAttrsScope : AttrsScope<HTMLDivElement>
public interface MDCDataTableScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCContentDsl
@Composable
public fun MDCDataTable(
  loading: Boolean = false,
  attrs: MDCAttrs<MDCDataTableAttrsScope>? = null,
  content: MDCContent<MDCDataTableScope>? = null,
) {
  Style
  Div(attrs = {
    classes("mdc-data-table")
    applyAttrs(attrs)
  }) {
    MDCProvider(::MDCDataTable) {
      MDCSideEffect(effect = MDCDataTable::layout)
      MDCSideEffect(loading) {
        if (loading) showProgress() else hideProgress()
      }
      applyContent(content)
      unsafeCast<MDCDataTableScope>().ProgressIndicator()
    }
  }
}

public sealed interface MDCDataTableContainerScope : ElementScope<HTMLTableElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCContentDsl
@Composable
public fun MDCDataTableScope.Container(
  attrs: MDCAttrsRaw<HTMLTableElement>? = null,
  content: MDCContent<MDCDataTableContainerScope>? = null,
) {
  Div(
    attrs = {
      classes("mdc-data-table__table-container")
    },
  ) {
    Table(
      attrs = {
        classes("mdc-data-table__table")
        applyAttrs(attrs)
      },
      content = content.reinterpret()
    )
  }
}
