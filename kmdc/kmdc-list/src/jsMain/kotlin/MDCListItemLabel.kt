package dev.petuska.kmdc.list

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.attributes.forId
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLLabelElement
import org.w3c.dom.HTMLSpanElement

public class MDCListItemLabelScope(scope: ElementScope<HTMLLabelElement>) : ElementScope<HTMLLabelElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemScope<*>.MDCListItemLabel(
  attrs: Builder<AttrsScope<HTMLLabelElement>>? = null,
  content: ComposableBuilder<MDCListItemLabelScope>? = null,
) {
  Label(attrs = {
    classes("mdc-deprecated-list-item__text")
    attrs?.invoke(this)
  }, content = content?.let { { MDCListItemLabelScope(this).it() } })
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemScope<*>.MDCListItemLabel(
  text: String,
  forId: String,
  attrs: Builder<AttrsScope<HTMLLabelElement>>? = null,
) {
  MDCListItemLabel(attrs = {
    forId(forId)
    attrs?.invoke(this)
  }) { Text(text) }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemLabelScope.MDCListItemPrimaryText(
  attrs: Builder<AttrsScope<HTMLSpanElement>>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null,
) {
  Span(attrs = {
    classes("mdc-deprecated-list-item__primary-text")
    attrs?.invoke(this)
  }, content = content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemLabelScope.MDCListItemPrimaryText(
  text: String,
  attrs: Builder<AttrsScope<HTMLSpanElement>>? = null,
) {
  MDCListItemPrimaryText(attrs = attrs) { Text(text) }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemLabelScope.MDCListItemSecondaryText(
  attrs: Builder<AttrsScope<HTMLSpanElement>>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null,
) {
  Span(attrs = {
    classes("mdc-deprecated-list-item__secondary-text")
    attrs?.invoke(this)
  }, content = content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemLabelScope.MDCListItemSecondaryText(
  text: String,
  attrs: Builder<AttrsScope<HTMLSpanElement>>? = null,
) {
  MDCListItemSecondaryText(attrs = attrs) { Text(text) }
}
