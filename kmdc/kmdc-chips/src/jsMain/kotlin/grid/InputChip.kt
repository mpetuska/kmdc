package dev.petuska.kmdc.chips.grid

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import dev.petuska.kmdc.chips.Chip
import dev.petuska.kmdc.chips.MDCChipScope
import dev.petuska.kmdc.chips.action.MDCChipActionIconScope
import dev.petuska.kmdc.chips.action.MDCChipActionScope
import dev.petuska.kmdc.chips.action.MDCChipActionTypeLocal
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.applyContent
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.data
import dev.petuska.kmdc.core.reinterpret
import dev.petuska.kmdc.core.role
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLSpanElement

public interface MDCInputChipScope : MDCChipScope

private val NavigableTrailLocal = compositionLocalOf { true }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
public fun MDCChipsGridScope.InputChip(
  id: String,
  disabled: Boolean = false,
  withPrimaryGraphic: Boolean = false,
  withPrimaryIcon: Boolean = false,
  touch: Boolean = false,
  withTrailingAction: Boolean = false,
  navigableTrailingAction: Boolean = true,
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
  content: MDCContent<MDCInputChipScope>? = null
) {
  Chip(
    id = id,
    disabled = disabled,
    withPrimaryGraphic = withPrimaryGraphic,
    withPrimaryIcon = withPrimaryIcon,
    touch = touch,
    attrs = {
      role("row")
      if (withTrailingAction) classes("mdc-evolution-chip--with-trailing-action")
      applyAttrs(attrs)
    },
    content = {
      CompositionLocalProvider(NavigableTrailLocal provides navigableTrailingAction) {
        applyContent(content)
      }
    }
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
public fun MDCInputChipScope.PrimaryAction(
  attrs: AttrsBuilder<HTMLButtonElement>? = null,
  content: MDCContent<MDCChipActionScope<HTMLButtonElement>>? = null
) {
  val navigableTrail = NavigableTrailLocal.current
  CompositionLocalProvider(MDCChipActionTypeLocal provides "primary") {
    ChipCell(
      attrs = {
        if (!navigableTrail) {
          data("mdc-deletable", true)
        }
        applyAttrs(attrs)
      },
      content = content,
    )
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
public fun MDCInputChipScope.TrailingAction(
  attrs: AttrsBuilder<HTMLButtonElement>? = null,
  content: MDCContent<MDCChipActionIconScope<HTMLButtonElement>>? = null
) {
  val navigableTrail = NavigableTrailLocal.current
  CompositionLocalProvider(MDCChipActionTypeLocal provides "trailing") {
    if (navigableTrail) {
      ChipCell(
        attrs = attrs,
        content = content.reinterpret(),
      )
    } else {
      GridAction(
        attrs = {
          aria("hidden", true)
          data("mdc-deletable", true)
          tabIndex(-1)
          applyAttrs(attrs)
        },
        content = content.reinterpret(),
      )
    }
  }
}
