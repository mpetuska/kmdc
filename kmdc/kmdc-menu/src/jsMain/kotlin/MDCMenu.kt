package dev.petuska.kmdc.menu

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCInitEffect
import dev.petuska.kmdc.core.MDCSideEffect
import dev.petuska.kmdc.core.MDCStateEffect
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.domain.Point
import dev.petuska.kmdc.core.reinterpret
import dev.petuska.kmdc.core.role
import dev.petuska.kmdc.list.MDCListLayout
import dev.petuska.kmdc.list.MDCListScope
import dev.petuska.kmdc.list.MDCListSelection
import dev.petuska.kmdc.menu.surface.Corner
import dev.petuska.kmdc.menu.surface.MDCMenuSurfaceAttrsScope
import dev.petuska.kmdc.menu.surface.MDCMenuSurfaceLayout
import org.w3c.dom.HTMLUListElement

@JsModule("@material/menu/mdc-menu.scss")
private external val Style: dynamic

@MDCAttrsDsl
public interface MDCMenuAttrsScope : MDCMenuSurfaceAttrsScope

@MDCDsl
public interface MDCMenuScope : MDCListScope<HTMLUListElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu)
 */
@MDCDsl
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
  Style
  MDCMenuSurfaceLayout(fixed = fixed, fullWidth = fullWidth, attrs = {
    classes("mdc-menu")
    applyAttrs(attrs)
  }) {
    MDCInitEffect(::MDCMenu)
    MDCStateEffect(open, MDCMenu::open)
    MDCStateEffect(fixed, MDCMenu::setFixedPosition)
    MDCStateEffect(wrapFocus, MDCMenu::wrapFocus)
    MDCStateEffect(anchorCorner, MDCMenu::setAnchorCorner)
    MDCStateEffect(quickOpen, MDCMenu::quickOpen)
    MDCStateEffect(hoisted, MDCMenu::setIsHoisted)
    MDCStateEffect(defaultFocusState, MDCMenu::setDefaultFocusState)
    MDCSideEffect<MDCMenu>(absolutePosition) {
      absolutePosition?.let { setAbsolutePosition(it.x, it.y) }
    }
    MDCSideEffect<MDCMenu>(selectedId, selectedIds) {
      singleSelection = selectedIds == null
      selectedIndex = selectedIds?.toTypedArray() ?: selectedId
    }
    MDCListLayout(
      attrs = {
        role("menu")
        attr("aria-hidden", "true")
        attr("aria-orientation", "vertical")
        tabIndex(-1)
      },
      selection = if (selectedIds == null) MDCListSelection.Single else MDCListSelection.MultiCheckbox,
      content = content.reinterpret()
    )
  }
}
