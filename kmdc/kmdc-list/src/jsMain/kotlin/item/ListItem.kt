package dev.petuska.kmdc.list.item

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.list.MDCListScope
import dev.petuska.kmdc.list.MDCListSelectionLocal
import dev.petuska.kmdc.ripple.MDCRippleLayout
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.*

public interface MDCListItemScope<T : HTMLElement> : ElementScope<T>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListScope<HTMLUListElement>.ListItem(
  disabled: Boolean = false,
  selected: Boolean = false,
  activated: Boolean = false,
  attrs: MDCAttrsRaw<HTMLLIElement>? = null,
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
    Span(attrs = { classes("mdc-deprecated-list-item__ripple") })
    MDCRippleLayout()
    applyContent(content)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListScope<HTMLUListElement>.ListItem(
  text: String,
  disabled: Boolean = false,
  selected: Boolean = false,
  activated: Boolean = false,
  attrs: MDCAttrsRaw<HTMLLIElement>? = null,
) {
  ListItem(
    disabled = disabled,
    selected = selected,
    activated = activated,
    attrs = attrs,
  ) {
    Text(text)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListScope<HTMLElement>.ListItem(
  disabled: Boolean = false,
  selected: Boolean = false,
  activated: Boolean = false,
  attrs: MDCAttrsRaw<HTMLAnchorElement>? = null,
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
      MDCRippleLayout()
    }
    applyContent(content)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListScope<HTMLElement>.ListItem(
  text: String,
  disabled: Boolean = false,
  selected: Boolean = false,
  activated: Boolean = false,
  attrs: MDCAttrsRaw<HTMLAnchorElement>? = null,
) {
  ListItem(
    disabled = disabled,
    selected = selected,
    activated = activated,
    attrs = attrs,
  ) {
    Text(text)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListItemScope<*>.Meta(
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null,
) {
  Span(attrs = {
    classes("mdc-deprecated-list-item__meta")
    attrs?.invoke(this)
  }, content = content)
}
