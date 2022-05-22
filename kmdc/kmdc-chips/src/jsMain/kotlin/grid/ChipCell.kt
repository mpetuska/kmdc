package dev.petuska.kmdc.chips.grid

import androidx.compose.runtime.*
import dev.petuska.kmdc.chips.*
import dev.petuska.kmdc.chips.action.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
internal fun MDCChipScope.ChipCell(
  attrs: AttrsBuilder<HTMLButtonElement>? = null,
  content: MDCContent<MDCChipActionScope<HTMLButtonElement>>? = null
) {
  val type = MDCChipActionTypeLocal.current
  Span(
    attrs = {
      classes("mdc-evolution-chip__cell", "mdc-evolution-chip__cell--$type")
      role("gridcell")
    },
    content = {
      GridAction(attrs, content)
    }
  )
}
