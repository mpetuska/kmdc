package dev.petuska.kmdc.tooltip

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCContentDsl
@Composable
public fun MDCTooltipRichContentScope.MDCTooltipLink(
  attrs: AttrBuilderContext<HTMLAnchorElement>? = null,
  content: ContentBuilder<HTMLAnchorElement>? = null,
) {
  A(
    attrs = {
      classes("mdc-tooltip__content-link")
      attrs?.invoke(this)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCContentDsl
@Composable
public fun MDCTooltipRichContentScope.MDCTooltipLink(
  text: String,
  href: String,
  attrs: AttrBuilderContext<HTMLAnchorElement>? = null,
) {
  MDCTooltipLink(attrs = {
    href(href)
    attrs?.invoke(this)
  }) {
    Text(text)
  }
}
