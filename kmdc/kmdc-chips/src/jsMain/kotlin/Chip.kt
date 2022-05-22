package dev.petuska.kmdc.chips

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

public interface MDCChipScope : ElementScope<HTMLSpanElement>

internal val MDCChipDisabledLocal = compositionLocalOf { false }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
internal fun MDCChipsScope.Chip(
  id: String,
  disabled: Boolean,
  withPrimaryGraphic: Boolean,
  withPrimaryIcon: Boolean,
  touch: Boolean,
  attrs: AttrsBuilder<HTMLSpanElement>?,
  content: MDCContent<MDCChipScope>?
) {
  Span(attrs = {
    classes("mdc-evolution-chip")
    if (disabled) classes("mdc-evolution-chip--disabled")
    if (withPrimaryGraphic || withPrimaryIcon) classes("mdc-evolution-chip--with-primary-graphic")
    if (withPrimaryIcon) classes("mdc-evolution-chip--with-primary-icon")
    if (touch) classes("mdc-evolution-chip--touch")
    id(id)
    applyAttrs(attrs)
  }, content = {
    CompositionLocalProvider(MDCChipDisabledLocal provides disabled) {
      applyContent(content)
    }
  })
}
