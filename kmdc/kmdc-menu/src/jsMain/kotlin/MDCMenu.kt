package dev.petuska.kmdc.menu

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.list.MDCList
import dev.petuska.kmdc.list.MDCListScope
import dev.petuska.kmdc.menu.surface.Corner
import dev.petuska.kmdc.menu.surface.MDCMenuSurface
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement
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

public class MDCMenuAttrsScope private constructor() : AttrsBuilder<HTMLDivElement>()

public class MDCMenuScope(scope: ElementScope<HTMLUListElement>) : MDCListScope<HTMLUListElement>(scope)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-menu)
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
    attrs?.invoke(this.unsafeCast<MDCMenuAttrsScope>())
  }) {
    DomSideEffect(options.open) { scope ->
      scope.mdc<MDCMenuModule.MDCMenu> { open = options.open }
    }
    DomSideEffect(options.fixed) { scope ->
      scope.mdc<MDCMenuModule.MDCMenu> { setFixedPosition(options.fixed) }
    }
    DomSideEffect(options.selectedIndex) { scope ->
      scope.mdc<MDCMenuModule.MDCMenu> { options.selectedIndex?.let { setSelectedIndex(it) } }
    }
    DomSideEffect(options.absolutePosition) { scope ->
      scope.mdc<MDCMenuModule.MDCMenu> { options.absolutePosition?.let { setAbsolutePosition(it.x, it.y) } }
    }
    DomSideEffect(options.anchorCorner) { scope ->
      scope.mdc<MDCMenuModule.MDCMenu> { options.anchorCorner?.let { setAnchorCorner(it.value) } }
    }
    MDCList(
      attrs = {
        role("menu")
        attr("aria-hidden", "true")
        attr("aria-orientation", "vertical")
        tabIndex(-1)
      },
      content = content?.let { { MDCMenuScope(this).it() } }
    )
  }
}
