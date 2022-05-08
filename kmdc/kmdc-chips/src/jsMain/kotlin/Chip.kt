package dev.petuska.kmdc.chips

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.applyContent
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

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
  content: ComposableBuilder<MDCChipScope>?
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
