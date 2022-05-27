package dev.petuska.kmdc.menu

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.core.domain.Point
import dev.petuska.kmdc.list.MDCListLayout
import dev.petuska.kmdc.list.MDCListScope
import dev.petuska.kmdc.list.MDCListSelection
import dev.petuska.kmdc.menu.surface.Corner
import dev.petuska.kmdc.menu.surface.MDCMenuSurfaceAttrsScope
import dev.petuska.kmdc.menu.surface.MDCMenuSurfaceLayout
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLUListElement

@JsModule("@material/menu/mdc-menu.scss")
private external val Style: dynamic

public interface MDCMenuAttrsScope : MDCMenuSurfaceAttrsScope

public interface MDCMenuScope : MDCListScope<HTMLUListElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu)
 */
@MDCContentDsl
@Composable
public fun MDCMenu(
  open: Boolean = false,
  selectedId: Int? = null,
  selectedIds: Collection<Int>? = null,
  fullWidth: Boolean = false,
  fixed: Boolean = false,
  anchorCorner: Corner = Corner.BOTTOM_START,
  quickOpen: Boolean = false,
  hoisted: Boolean = false,
  wrapFocus: Boolean = false,
  defaultFocusState: DefaultFocusState = DefaultFocusState.NONE,
  absolutePosition: Point? = null,
  attrs: MDCAttrs<MDCMenuAttrsScope>? = null,
  content: MDCContent<MDCMenuScope>? = null,
) {
  MDCMenuLayout(
    singleSelect = selectedIds == null,
    fullWidth = fullWidth,
    fixed = fixed,
    attrs = attrs,
    init = {
      MDCProvider(::MDCMenu) {
        MDCStateEffectNew(open, MDCMenu::open)
        MDCStateEffectNew(fixed, MDCMenu::setFixedPosition)
        MDCStateEffectNew(wrapFocus, MDCMenu::wrapFocus)
        MDCStateEffectNew(anchorCorner, MDCMenu::setAnchorCorner)
        MDCStateEffectNew(quickOpen, MDCMenu::quickOpen)
        MDCStateEffectNew(hoisted, MDCMenu::setIsHoisted)
        MDCStateEffectNew(defaultFocusState, MDCMenu::setDefaultFocusState)
        MDCSideEffectNew(absolutePosition) {
          absolutePosition?.let { setAbsolutePosition(it.x, it.y) }
        }
        MDCSideEffectNew(selectedId, selectedIds) {
          singleSelection = selectedIds == null
          selectedIndex = selectedIds?.toTypedArray() ?: selectedId
        }
        it()
      }
    },
    content = content,
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu)
 */
@Composable
@KMDCInternalAPI
public fun MDCMenuLayout(
  singleSelect: Boolean,
  fullWidth: Boolean,
  fixed: Boolean,
  init: MDCComponentInit<ElementScope<HTMLDivElement>> = { it() },
  attrs: MDCAttrs<MDCMenuAttrsScope>?,
  content: MDCContent<MDCMenuScope>?,
) {
  Style
  MDCMenuSurfaceLayout(
    fixed = fixed,
    fullWidth = fullWidth,
    attrs = {
      classes("mdc-menu")
      applyAttrs(attrs)
    }
  ) {
    init {
      MDCListLayout(
        attrs = {
          role("menu")
          attr("aria-hidden", "true")
          attr("aria-orientation", "vertical")
          tabIndex(-1)
        },
        selection = if (singleSelect) MDCListSelection.Single else MDCListSelection.MultiCheckbox,
        content = content.reinterpret()
      )
    }
  }
}
