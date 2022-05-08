package dev.petuska.kmdc.chips.grid

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.petuska.kmdc.chips.Chip
import dev.petuska.kmdc.chips.action.MDCChipActionScope
import dev.petuska.kmdc.chips.action.MDCChipActionTypeLocal
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.role
import org.w3c.dom.HTMLButtonElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
public fun MDCChipsGridScope.ActionChip(
  id: String,
  disabled: Boolean = false,
  withPrimaryGraphic: Boolean = false,
  withPrimaryIcon: Boolean = false,
  attrs: AttrsBuilder<HTMLButtonElement>? = null,
  content: ComposableBuilder<MDCChipActionScope<HTMLButtonElement>>? = null
) {
  Chip(
    id = id,
    disabled = disabled,
    withPrimaryGraphic = withPrimaryGraphic,
    withPrimaryIcon = withPrimaryIcon,
    attrs = {
      role("row")
    },
    content = {
      CompositionLocalProvider(MDCChipActionTypeLocal provides "primary") {
        ChipCell(
          attrs = {
            applyAttrs(attrs)
          },
          content = content,
        )
      }
    }
  )
}