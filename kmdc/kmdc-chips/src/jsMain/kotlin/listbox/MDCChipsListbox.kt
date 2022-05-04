package dev.petuska.kmdc.chips.listbox

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.chips.MDCChips
import dev.petuska.kmdc.chips.MDCChipsAttrsScope
import dev.petuska.kmdc.chips.MDCChipsScope
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.reinterpret
import dev.petuska.kmdc.core.role

public interface MDCChipsListboxScope : MDCChipsScope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
public fun MDCChipsListbox(
  overflow: Boolean = false,
  multiselectable: Boolean = false,
  attrs: Builder<MDCChipsAttrsScope>? = null,
  content: ComposableBuilder<MDCChipsListboxScope>? = null
) {
  MDCChips(
    overflow = overflow,
    attrs = {
      role("listbox")
      aria("orientation", "horizontal")
      aria("multiselectable", multiselectable)
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}
