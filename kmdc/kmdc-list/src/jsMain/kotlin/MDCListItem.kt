package dev.petuska.kmdc.list

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.ripple.MDCRipple
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLLIElement
import org.w3c.dom.HTMLSpanElement
import org.w3c.dom.HTMLUListElement

public data class MDCListItemOpts(
  public var disabled: Boolean = false,
  public var selected: Boolean = false,
  public var activated: Boolean = false
)

public open class MDCListItemScope<T : HTMLElement>(scope: ElementScope<T>) : ElementScope<T> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListScope<HTMLUListElement>.MDCListItem(
  opts: Builder<MDCListItemOpts>? = null,
  attrs: Builder<AttrsBuilder<HTMLLIElement>>? = null,
  content: ComposableBuilder<MDCListItemScope<HTMLLIElement>>? = null,
) {
  val options = MDCListItemOpts().apply { opts?.invoke(this) }
  Li(attrs = {
    classes("mdc-deprecated-list-item")
    if (options.disabled) classes("mdc-deprecated-list-item--disabled")
    if (options.selected) classes("mdc-deprecated-list-item--selected")
    if (options.activated) classes("mdc-deprecated-list-item--activated")
    if (options.selected || options.activated) {
      attr("aria-current", "page")
      tabIndex(0)
    }
    attrs?.invoke(this)
  }) {
    Span(attrs = { classes("mdc-deprecated-list-item__ripple") }) {
      MDCRipple()
    }
    content?.let { MDCListItemScope(this).it() }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListScope<HTMLElement>.MDCListItem(
  opts: Builder<MDCListItemOpts>? = null,
  attrs: Builder<AttrsBuilder<HTMLAnchorElement>>? = null,
  content: ComposableBuilder<MDCListItemScope<HTMLAnchorElement>>? = null,
) {
  val options = MDCListItemOpts().apply { opts?.invoke(this) }
  A(attrs = {
    classes("mdc-deprecated-list-item")
    if (options.disabled) classes("mdc-deprecated-list-item--disabled")
    if (options.selected) classes("mdc-deprecated-list-item--selected")
    if (options.activated) classes("mdc-deprecated-list-item--activated")
    if (options.selected || options.activated) {
      tabIndex(0)
      attr("aria-current", "page")
    }
    attrs?.invoke(this)
  }) {
    Span(attrs = { classes("mdc-deprecated-list-item__ripple") }) {
      MDCRipple()
    }
    content?.let { MDCListItemScope(this).it() }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemScope<*>.MDCListItemGraphic(
  attrs: Builder<AttrsBuilder<HTMLSpanElement>>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null,
) {
  Span(attrs = {
    classes("mdc-deprecated-list-item__graphic")
    attrs?.invoke(this)
  }, content = content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemScope<*>.MDCListItemMeta(
  attrs: Builder<AttrsBuilder<HTMLSpanElement>>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null,
) {
  Span(attrs = {
    classes("mdc-deprecated-list-item__meta")
    attrs?.invoke(this)
  }, content = content)
}
