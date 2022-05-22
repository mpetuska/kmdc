package dev.petuska.kmdc.chips.listbox

import androidx.compose.runtime.*
import dev.petuska.kmdc.chips.*
import dev.petuska.kmdc.chips.action.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

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
  touch: Boolean = false,
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
  content: MDCContent<MDCFilterChipScope>? = null
) {
  CompositionLocalProvider(MDCChipActionTypeLocal provides "primary") {
    val type = MDCChipActionTypeLocal.current
    Chip(
      id = id,
      disabled = disabled,
      withPrimaryGraphic = withPrimaryGraphic,
      withPrimaryIcon = withPrimaryIcon,
      touch = touch,
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
