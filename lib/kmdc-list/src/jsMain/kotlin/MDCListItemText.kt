package dev.petuska.kmdc.list

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

public class MDCListItemTextScope(scope: ElementScope<HTMLSpanElement>) : ElementScope<HTMLSpanElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemScope<*>.MDCListItemText(
  attrs: Builder<AttrsBuilder<HTMLSpanElement>>? = null,
  content: ComposableBuilder<MDCListItemTextScope>? = null,
) {
  Span(attrs = {
    classes("mdc-deprecated-list-item__text")
    attrs?.invoke(this)
  }, content = content?.let { { MDCListItemTextScope(this).it() } })
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemScope<*>.MDCListItemText(
  text: String,
  attrs: Builder<AttrsBuilder<HTMLSpanElement>>? = null,
) {
  MDCListItemText(attrs = attrs) { Text(text) }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemTextScope.MDCListItemPrimaryText(
  attrs: Builder<AttrsBuilder<HTMLSpanElement>>? = null,
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
public fun MDCListItemTextScope.MDCListItemPrimaryText(
  text: String,
  attrs: Builder<AttrsBuilder<HTMLSpanElement>>? = null,
) {
  MDCListItemPrimaryText(attrs = attrs) { Text(text) }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemTextScope.MDCListItemSecondaryText(
  attrs: Builder<AttrsBuilder<HTMLSpanElement>>? = null,
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
public fun MDCListItemTextScope.MDCListItemSecondaryText(
  text: String,
  attrs: Builder<AttrsBuilder<HTMLSpanElement>>? = null,
) {
  MDCListItemSecondaryText(attrs = attrs) { Text(text) }
}
