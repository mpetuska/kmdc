package dev.petuska.kmdc.list

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCSideEffect
import dev.petuska.kmdc.core.initialiseMDC
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Ul
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLUListElement

@JsModule("@material/list/dist/mdc.list.css")
public external val MDCListStyle: dynamic

public data class MDCListOpts(
  public var size: Size = Size.SingleLine,
  public var type: Type = Type.Generic,
  public var dense: Boolean = false,
  public var singleSelection: Boolean = false
) {
  public enum class Size(public vararg val classes: String) {
    SingleLine, TwoLine("mdc-deprecated-list--two-line")
  }

  public enum class Type(public vararg val classes: String) {
    Generic,
    Textual("mdc-deprecated-list--textual-list"),
    Avatar("mdc-deprecated-list--avatar-list"),
    Icon("mdc-deprecated-list--icon-list"),
    Image("mdc-deprecated-list--image-list"),
    Thumbnail("mdc-deprecated-list--thumbnail-list"),
    Video("mdc-deprecated-list--video-list"),
  }
}

public open class MDCListScope<T : HTMLElement>(scope: ElementScope<T>) : ElementScope<T> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCList(
  opts: Builder<MDCListOpts>? = null,
  attrs: Builder<AttrsScope<HTMLUListElement>>? = null,
  content: ComposableBuilder<MDCListScope<HTMLUListElement>>? = null,
) {
  MDCListStyle
  val options = MDCListOpts().apply { opts?.invoke(this) }

  Ul(attrs = {
    classes("mdc-deprecated-list", *options.size.classes, *options.type.classes)
    if (options.singleSelection) attr("role", "listbox")
    initialiseMDC(MDCListModule.MDCList::attachTo) {
      singleSelection = options.singleSelection
    }
    attrs?.invoke(this)
  }) {
    MDCSideEffect(options.singleSelection, MDCListModule.MDCList::singleSelection)
    content?.let { MDCListScope(this).it() }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCNavList(
  opts: Builder<MDCListOpts>? = null,
  attrs: Builder<AttrsScope<HTMLElement>>? = null,
  content: ComposableBuilder<MDCListScope<HTMLElement>>? = null,
) {
  MDCListStyle
  val options = MDCListOpts().apply { opts?.invoke(this) }

  Nav(attrs = {
    classes("mdc-deprecated-list", *options.size.classes, *options.type.classes)
    if (options.singleSelection) attr("role", "listbox")
    initialiseMDC(MDCListModule.MDCList::attachTo) {
      singleSelection = options.singleSelection
    }
    attrs?.invoke(this)
  }) {
    MDCSideEffect(options.singleSelection, MDCListModule.MDCList::singleSelection)
    content?.let { MDCListScope(this).it() }
  }
}
