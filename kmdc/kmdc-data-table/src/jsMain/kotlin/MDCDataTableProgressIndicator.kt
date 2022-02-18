@file:Suppress("NOTHING_TO_INLINE")

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.data.table.MDCDataTableScope
import dev.petuska.kmdc.linear.progress.MDCLinearProgress
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-data-table)
 */
@MDCDsl
@Composable
public fun MDCDataTableScope.MDCDataTableProgressIndicator(
  attrs: AttrsBuilder<HTMLDivElement>? = null,
) {
  Div(
    attrs = {
      classes("mdc-data-table__progress-indicator")
      applyAttrs(attrs)
    }
  ) {
    Div(
      attrs = {
        classes("mdc-data-table__scrim")
      }
    )
    MDCLinearProgress(
      opts = { determinate = false },
      attrs = {
        classes("mdc-data-table__linear-progress")
      },
    )
  }
}
