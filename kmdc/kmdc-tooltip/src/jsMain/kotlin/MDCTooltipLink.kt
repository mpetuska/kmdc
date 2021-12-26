package dev.petuska.kmdc.tooltip

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLAnchorElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-tooltip)
 */
@MDCDsl
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-tooltip)
 */
@MDCDsl
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
