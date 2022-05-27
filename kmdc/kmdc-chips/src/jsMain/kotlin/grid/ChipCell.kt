package dev.petuska.kmdc.chips.grid

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.chips.MDCChipScope
import dev.petuska.kmdc.chips.action.MDCChipActionScope
import dev.petuska.kmdc.chips.action.MDCChipActionTypeLocal
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.role
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLButtonElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCContentDsl
@Composable
internal fun MDCChipScope.ChipCell(
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  content: MDCContent<MDCChipActionScope<HTMLButtonElement>>? = null
) {
  val type = MDCChipActionTypeLocal.current
  Span(
    attrs = {
      classes("mdc-evolution-chip__cell", "mdc-evolution-chip__cell--$type")
      role("gridcell")
    },
  ) {
    GridAction(attrs, content)
  }
}
