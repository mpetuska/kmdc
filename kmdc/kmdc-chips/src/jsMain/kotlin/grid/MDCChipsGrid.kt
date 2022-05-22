package dev.petuska.kmdc.chips.grid

import androidx.compose.runtime.*
import dev.petuska.kmdc.chips.*
import dev.petuska.kmdc.core.*

public interface MDCChipsGridScope : MDCChipsScope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
public fun MDCChipsGrid(
  overflow: Boolean = false,
  attrs: MDCAttrs<MDCChipsAttrsScope>? = null,
  content: MDCContent<MDCChipsGridScope>? = null
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
