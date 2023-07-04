package dev.petuska.kmdc.list.item

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.attributes.forId
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLLabelElement
import org.w3c.dom.HTMLSpanElement

public interface MDCListItemLabelScope : ElementScope<HTMLLabelElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListItemScope<*>.Label(
  forId: String? = null,
  attrs: MDCAttrs<AttrsScope<HTMLLabelElement>>? = null,
  content: MDCContent<MDCListItemLabelScope>? = null,
) {
  org.jetbrains.compose.web.dom.Label(
    attrs = {
      classes("mdc-deprecated-list-item__text")
      forId?.let(::forId)
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListItemScope<*>.Label(
  text: String,
  forId: String? = null,
  attrs: MDCAttrs<AttrsScope<HTMLLabelElement>>? = null,
) {
  Label(
    forId = forId,
    attrs = {
      applyAttrs(attrs)
    },
    content = { Text(text) }
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListItemLabelScope.Primary(
  attrs: MDCAttrs<AttrsScope<HTMLSpanElement>>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null,
) {
  Span(attrs = {
    classes("mdc-deprecated-list-item__primary-text")
    attrs?.invoke(this)
  }, content = content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListItemLabelScope.Primary(
  text: String,
  attrs: MDCAttrs<AttrsScope<HTMLSpanElement>>? = null,
) {
  Primary(attrs = attrs) { Text(text) }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListItemLabelScope.Secondary(
  attrs: MDCAttrs<AttrsScope<HTMLSpanElement>>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null,
) {
  Span(attrs = {
    classes("mdc-deprecated-list-item__secondary-text")
    attrs?.invoke(this)
  }, content = content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListItemLabelScope.Secondary(
  text: String,
  attrs: MDCAttrs<AttrsScope<HTMLSpanElement>>? = null,
) {
  Secondary(attrs = attrs) { Text(text) }
}
