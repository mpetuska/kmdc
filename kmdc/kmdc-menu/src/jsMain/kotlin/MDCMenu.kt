package dev.petuska.kmdc.menu

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCSideEffect
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.initialiseMDC
import dev.petuska.kmdc.core.reinterpret
import dev.petuska.kmdc.core.role
import dev.petuska.kmdc.list.MDCList
import dev.petuska.kmdc.list.MDCListScope
import dev.petuska.kmdc.menu.surface.MDCMenuSurface
import dev.petuska.kmdc.menu.surface.MDCMenuSurfaceAttrsScope
import org.w3c.dom.HTMLUListElement

@JsModule("@material/menu/dist/mdc.menu.css")
private external val MDCMenuStyle: dynamic

public data class MDCMenuOpts(
  var open: Boolean = false,
  var fixed: Boolean = false,
  var wrapFocus: Boolean = false,
  var anchorCorner: Byte? = null,
  var selectedIndex: Int? = null,
  var absolutePosition: Point? = null
) {
  public data class Point(var x: Double = 0.0, var y: Double = 0.0)
}

public interface MDCMenuAttrsScope : MDCMenuSurfaceAttrsScope

public interface MDCMenuScope : MDCListScope<HTMLUListElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu)
 */
@MDCDsl
@Composable
public fun MDCMenu(
  opts: Builder<MDCMenuOpts>? = null,
  attrs: Builder<MDCMenuAttrsScope>? = null,
  content: ComposableBuilder<MDCMenuScope>? = null,
) {
  MDCMenuStyle
  val options = MDCMenuOpts().apply { opts?.invoke(this) }
  MDCMenuSurface(attrs = {
    classes("mdc-menu")
    initialiseMDC(MDCMenuModule.MDCMenu::attachTo)
    applyAttrs(attrs)
  }) {
    MDCSideEffect(options.open, MDCMenuModule.MDCMenu::open)
    MDCSideEffect(options.wrapFocus, MDCMenuModule.MDCMenu::wrapFocus)
    MDCSideEffect(options.selectedIndex, MDCMenuModule.MDCMenu::setSelectedIndex)
    MDCSideEffect(options.fixed, MDCMenuModule.MDCMenu::setFixedPosition)
    MDCSideEffect(options.anchorCorner, MDCMenuModule.MDCMenu::setAnchorCorner)
    MDCSideEffect<MDCMenuModule.MDCMenu>(options.absolutePosition) {
      options.absolutePosition?.let { setAbsolutePosition(it.x, it.y) }
    }
    MDCList(
      attrs = {
        role("menu")
        attr("aria-hidden", "true")
        attr("aria-orientation", "vertical")
        tabIndex(-1)
      },
      content = content.reinterpret()
    )
  }
}
