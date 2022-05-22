package dev.petuska.kmdc.list.item

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyContent
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.role
import dev.petuska.kmdc.list.MDCListScope
import dev.petuska.kmdc.list.MDCListSelectionLocal
import dev.petuska.kmdc.ripple.MDCRipple
import org.jetbrains.compose.web.attributes.AttrsScope
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

public interface MDCListItemScope<T : HTMLElement> : ElementScope<T>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListScope<HTMLUListElement>.ListItem(
  disabled: Boolean = false,
  selected: Boolean = false,
  activated: Boolean = false,
  attrs: MDCAttrs<AttrsScope<HTMLLIElement>>? = null,
  content: MDCContent<MDCListItemScope<HTMLLIElement>>? = null,
) {
  val selection = MDCListSelectionLocal.current
  Li(attrs = {
    classes("mdc-deprecated-list-item")
    if (disabled) classes("mdc-deprecated-list-item--disabled")
    if (selected) classes("mdc-deprecated-list-item--selected")
    if (activated) classes("mdc-deprecated-list-item--activated")
    if (selected || activated) {
      attr("aria-current", "page")
      tabIndex(0)
    }
    selection.itemRole?.let(::role)
    attrs?.invoke(this)
  }) {
    Span(attrs = { classes("mdc-deprecated-list-item__ripple") }) {
      MDCRipple()
    }
    applyContent(content)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListScope<HTMLElement>.ListItem(
  disabled: Boolean = false,
  selected: Boolean = false,
  activated: Boolean = false,
  attrs: MDCAttrs<AttrsScope<HTMLAnchorElement>>? = null,
  content: MDCContent<MDCListItemScope<HTMLAnchorElement>>? = null,
) {
  val selection = MDCListSelectionLocal.current
  A(attrs = {
    classes("mdc-deprecated-list-item")
    if (disabled) classes("mdc-deprecated-list-item--disabled")
    if (selected) {
      classes("mdc-deprecated-list-item--selected")
      aria("checked", selected)
    }
    if (activated) classes("mdc-deprecated-list-item--activated")
    if (selected || activated) {
      tabIndex(0)
      aria("current", "page")
    }
    selection.itemRole?.let(::role)
    attrs?.invoke(this)
  }) {
    Span(attrs = { classes("mdc-deprecated-list-item__ripple") }) {
      MDCRipple()
    }
    applyContent(content)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemScope<*>.Meta(
  attrs: MDCAttrs<AttrsScope<HTMLSpanElement>>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null,
) {
  Span(attrs = {
    classes("mdc-deprecated-list-item__meta")
    attrs?.invoke(this)
  }, content = content)
}
