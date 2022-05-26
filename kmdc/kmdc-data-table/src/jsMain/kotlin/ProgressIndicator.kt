package dev.petuska.kmdc.data.table

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.linear.progress.MDCLinearProgress
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCContentDsl
@Composable
public fun MDCDataTableScope.ProgressIndicator(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
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
