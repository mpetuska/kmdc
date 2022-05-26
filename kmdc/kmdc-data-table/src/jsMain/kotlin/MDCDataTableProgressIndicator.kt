@file:Suppress("NOTHING_TO_INLINE")

package dev.petuska.kmdc.data.table

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.linear.progress.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-data-table)
 */
@MDCContentDsl
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
