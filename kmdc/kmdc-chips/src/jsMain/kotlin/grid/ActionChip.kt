package dev.petuska.kmdc.chips.grid

import androidx.compose.runtime.*
import dev.petuska.kmdc.chips.*
import dev.petuska.kmdc.chips.action.*
import dev.petuska.kmdc.core.*
import org.w3c.dom.*

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
