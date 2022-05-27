package dev.petuska.kmdc.list.item

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

public interface MDCListItemTextScope : ElementScope<HTMLSpanElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListItemScope<*>.Text(
  attrs: MDCAttrs<AttrsScope<HTMLSpanElement>>? = null,
  content: MDCContent<MDCListItemTextScope>? = null,
) {
  Span(
    attrs = {
      classes("mdc-deprecated-list-item__text")
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
public fun MDCListItemScope<*>.Text(
  text: String,
  attrs: MDCAttrs<AttrsScope<HTMLSpanElement>>? = null,
) {
  this@Text.Text(attrs = attrs) { org.jetbrains.compose.web.dom.Text(text) }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListItemTextScope.Primary(
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
public fun MDCListItemTextScope.Primary(
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
public fun MDCListItemTextScope.Secondary(
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
public fun MDCListItemTextScope.Secondary(
  text: String,
  attrs: MDCAttrs<AttrsScope<HTMLSpanElement>>? = null,
) {
  Secondary(attrs = attrs) { Text(text) }
}
