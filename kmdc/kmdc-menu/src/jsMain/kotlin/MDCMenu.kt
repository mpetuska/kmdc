package dev.petuska.kmdc.menu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.list.MDCList
import dev.petuska.kmdc.list.MDCListScope
import dev.petuska.kmdc.menu.surface.Corner
import dev.petuska.kmdc.menu.surface.MDCMenuSurface
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLUListElement

@JsModule("@material/menu/dist/mdc.menu.css")
private external val MDCMenuStyle: dynamic

public data class MDCMenuOpts(
  var open: Boolean = false,
  var fixed: Boolean = false,
  var anchorCorner: Corner? = null,
  var selectedIndex: Int? = null,
  var absolutePosition: Point? = null
) {
  public data class Point(var x: Double = 0.0, var y: Double = 0.0)
}

public class MDCMenuScopeAttrsScope private constructor() : AttrsBuilder<HTMLDivElement>()

public class MDCMenuScope<T : HTMLElement>(public val listScope: MDCListScope<T>) :
  ElementScope<T> by listScope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-menu)
 */
@MDCDsl
@Composable
public fun MDCMenu(
  opts: Builder<MDCMenuOpts>? = null,
  attrs: Builder<MDCMenuScopeAttrsScope>? = null,
  content: ComposableBuilder<MDCMenuScope<HTMLUListElement>>? = null,
) {
  var menuMdc by remember { mutableStateOf<MDCMenuModule.MDCMenu?>(null) }
  MDCMenuStyle
  val options = MDCMenuOpts().apply { opts?.invoke(this) }
  MDCMenuSurface(attrs = {
    classes("mdc-menu")
    initialiseMDC(
      MDCMenuModule.MDCMenu::attachTo,
      postInit = { _, mdc -> menuMdc = mdc }
    )
    menuMdc?.let { mdc ->
      mdc.open = options.open
      if (options.fixed) mdc.setFixedPosition(options.fixed)
      options.selectedIndex?.let { mdc.setSelectedIndex(it) }
      options.absolutePosition?.let { mdc.setAbsolutePosition(it.x, it.y) }
      options.anchorCorner?.let { mdc.setAnchorCorner(it) }
    }
    attrs?.invoke(this.unsafeCast<MDCMenuScopeAttrsScope>())
  }) {
    MDCList(attrs = {
      attr("role", "menu")
      attr("aria-hidden", "true")
      attr("aria-orientation", "vertical")
      tabIndex(-1)
    }) {
      content?.let { MDCMenuScope(this).it() }
    }
  }
}
