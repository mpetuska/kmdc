package dev.petuska.kmdc.chips.grid

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.chips.MDCChips
import dev.petuska.kmdc.chips.MDCChipsAttrsScope
import dev.petuska.kmdc.chips.MDCChipsScope
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.reinterpret
import dev.petuska.kmdc.core.role

public interface MDCChipsGridScope : MDCChipsScope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
public fun MDCChipsGrid(
  overflow: Boolean = false,
  attrs: Builder<MDCChipsAttrsScope>? = null,
  content: ComposableBuilder<MDCChipsGridScope>? = null
) {
  MDCChips(
    overflow = overflow,
    attrs = {
      role("grid")
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}
