package dev.petuska.kmdc.chips.grid

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.petuska.kmdc.chips.Chip
import dev.petuska.kmdc.chips.action.MDCChipActionScope
import dev.petuska.kmdc.chips.action.MDCChipActionTypeLocal
import dev.petuska.kmdc.core.*
import org.w3c.dom.HTMLButtonElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCContentDsl
@Composable
public fun MDCChipsGridScope.ActionChip(
  id: String,
  disabled: Boolean = false,
  withPrimaryGraphic: Boolean = false,
  withPrimaryIcon: Boolean = false,
  touch: Boolean = false,
  attrs: AttrsBuilder<HTMLButtonElement>? = null,
  content: MDCContent<MDCChipActionScope<HTMLButtonElement>>? = null
) {
  Chip(
    id = id,
    disabled = disabled,
    withPrimaryGraphic = withPrimaryGraphic,
    withPrimaryIcon = withPrimaryIcon,
    touch = touch,
    attrs = {
      role("row")
    },
  ) {
    CompositionLocalProvider(MDCChipActionTypeLocal provides "primary") {
      ChipCell(
        attrs = {
          applyAttrs(attrs)
        },
        content = content,
      )
    }
  }
}
