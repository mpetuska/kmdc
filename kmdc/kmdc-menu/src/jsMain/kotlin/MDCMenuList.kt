package dev.petuska.kmdc.menu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffectScope
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.mdc
import dev.petuska.kmdc.list.MDCList
import dev.petuska.kmdc.list.MDCListModule
import dev.petuska.kmdc.list.MDCListScope
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLUListElement

@JsModule("@material/menu/dist/mdc.menu.css")
public external val MDCMenuStyle: dynamic

public data class MDCMenuOpts(
  var onSelected: (Int) -> Unit = {}
)

public class MDCMenuListScope<T : HTMLElement>(public val listScope: MDCListScope<T>) : ElementScope<T> by listScope

@JsModule("@material/menu")
public external object MDCMenuModule {
  public class MDCMenu(element: Element) {
    public companion object {
      public fun attachTo(element: Element): MDCMenu
    }

    public fun destroy()

    public var open: Boolean

    public fun setFixedPosition(isFixed: Boolean)
    public fun setSelectedIndex(index: Int)
    public fun setIsHoisted(isHoisted: Boolean)
    public fun getPrimaryTextAtIndex(index: Int): String
    public fun setEnabled(index: Int, isEnabled: Boolean)
    public fun typeaheadMatchItem(nextChar: String): Int
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-menu)
 */
@MDCDsl
@Composable
public fun MDCMenu(
  opts: Builder<MDCMenuOpts>? = null,
  attrs: Builder<AttrsBuilder<HTMLDivElement>>? = null,
  initialize: (
    DisposableEffectScope.(
      parent: HTMLDivElement,
      mdcCheckbox: MDCMenuModule.MDCMenu
    ) -> Unit
  )? = null,
  content: ComposableBuilder<MDCMenuListScope<HTMLUListElement>>? = null,
) {
  MDCMenuStyle
  MDCMenuSurfaceStyle
  val options = MDCMenuOpts().apply { opts?.invoke(this) }
  Div(attrs = {
    classes("mdc-menu", "mdc-menu-surface")
    ref {
      val mdc = MDCMenuModule.MDCMenu.attachTo(it)
      it.mdc = mdc
      initialize?.invoke(this, it, mdc)
      onDispose {
        it.mdc<MDCMenuModule.MDCMenu> { destroy() }
      }
    }
    addEventListener("MDCMenu:selected") {
      it.nativeEvent.unsafeCast<MDCListModule.MDCListActionEvent>().let { e ->
        options.onSelected(e.detail.index)
      }
    }
    attrs?.invoke(this)
  }) {
    MDCList(attrs = {
      attr("role", "menu")
      attr("aria-hidden", "true")
      attr("aria-orientation", "vertical")
      tabIndex(-1)
    }) {
      content?.let { MDCMenuListScope(this).it() }
    }
  }
}
