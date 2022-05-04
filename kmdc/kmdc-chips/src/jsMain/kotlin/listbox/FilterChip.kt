package dev.petuska.kmdc.chips.listbox

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.petuska.kmdc.chips.Chip
import dev.petuska.kmdc.chips.action.MDCChipActionScope
import dev.petuska.kmdc.chips.action.MDCChipActionTypeLocal
import dev.petuska.kmdc.chips.action.Ripple
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.applyContent
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.role
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

public interface MDCFilterChipScope : MDCChipActionScope<HTMLSpanElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
public fun MDCChipsListboxScope.FilterChip(
  id: String,
  selected: Boolean,
  disabled: Boolean = false,
  withPrimaryGraphic: Boolean = false,
  withPrimaryIcon: Boolean = false,
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
  content: ComposableBuilder<MDCFilterChipScope>? = null
) {
  CompositionLocalProvider(MDCChipActionTypeLocal provides "primary") {
    val type = MDCChipActionTypeLocal.current
    Chip(
      id = id,
      disabled = disabled,
      withPrimaryGraphic = withPrimaryGraphic,
      withPrimaryIcon = withPrimaryIcon,
      attrs = {
        classes("mdc-evolution-chip--filter", "mdc-evolution-chip--selectable")
        if (selected) classes("mdc-evolution-chip--selected")
        role("presentation")
      },
      content = {
        Span(attrs = {
          classes("mdc-evolution-chip__action", "mdc-evolution-chip__action--$type")
          role("option")
          aria("selected", selected)
          if (disabled) {
            aria("disabled", disabled)
          }
          applyAttrs(attrs)
        }, content = {
          unsafeCast<MDCFilterChipScope>().Ripple()
          applyContent(content)
        })
      }
    )
  }
}
