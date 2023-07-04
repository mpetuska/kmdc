package dev.petuska.kmdc.chips.listbox

import androidx.compose.runtime.*
import dev.petuska.kmdc.chips.*
import dev.petuska.kmdc.core.*

public interface MDCChipsListboxScope : MDCChipsScope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCContentDsl
@Composable
public fun MDCChipsListbox(
  overflow: Boolean = false,
  multiselectable: Boolean = false,
  attrs: MDCAttrs<MDCChipsAttrsScope>? = null,
  content: MDCContent<MDCChipsListboxScope>? = null
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
