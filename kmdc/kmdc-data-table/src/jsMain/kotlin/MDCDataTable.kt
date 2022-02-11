package dev.petuska.kmdc.data.table

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@JsModule("@material/data-table/dist/mdc.data-table.css")
private external val MDCDataTableCSS: dynamic

public class MDCDataTableAttrsScope private constructor() : AttrsBuilder<HTMLDivElement>()
public class MDCDataTableScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

public data class MDCDataTableOpts(
  var showProgress: Boolean = false,
)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public fun MDCDataTable(
  opts: Builder<MDCDataTableOpts>? = null,
  attrs: Builder<MDCDataTableAttrsScope>? = null,
  content: ComposableBuilder<MDCDataTableScope>? = null,
) {
  MDCDataTableCSS
  val options = MDCDataTableOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-data-table")

      attrs?.invoke(unsafeCast<MDCDataTableAttrsScope>())
    }
  ) {

    content?.invoke(MDCDataTableScope((this)))
  }
}
