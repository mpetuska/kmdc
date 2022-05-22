package dev.petuska.kmdc.data.table

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCInitEffect
import dev.petuska.kmdc.core.MDCSideEffect
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.applyContent
import dev.petuska.kmdc.core.reinterpret
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Table
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLTableElement

@JsModule("@material/data-table/dist/mdc.data-table.css")
private external val MDCDataTableCSS: dynamic

public sealed interface MDCDataTableAttrsScope : AttrsScope<HTMLDivElement>
public sealed interface MDCDataTableScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public fun MDCDataTable(
  attrs: MDCAttrs<MDCDataTableAttrsScope>? = null,
  content: MDCContent<MDCDataTableScope>? = null,
) {
  MDCDataTableCSS
  Div(
    attrs = {
      classes("mdc-data-table")
      applyAttrs(attrs)
    },
  ) {
    MDCSideEffect(effect = MDCDataTableModule.MDCDataTable::layout)
    applyContent(content)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public fun MDCDataTable(
  loading: Boolean,
  attrs: MDCAttrs<MDCDataTableAttrsScope>? = null,
  content: MDCContent<MDCDataTableScope>? = null,
) {
  MDCDataTable(attrs = {
    applyAttrs(attrs)
  }) {
    MDCInitEffect(MDCDataTableModule::MDCDataTable)
    MDCSideEffect<MDCDataTableModule.MDCDataTable>(loading) {
      if (loading) showProgress() else hideProgress()
    }
    applyContent(content)
    MDCDataTableProgressIndicator()
  }
}

public sealed interface MDCDataTableContainerScope : ElementScope<HTMLTableElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public fun MDCDataTableScope.MDCDataTableContainer(
  attrs: AttrsBuilder<HTMLTableElement>? = null,
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
      content = content?.reinterpret()
    )
  }
}
