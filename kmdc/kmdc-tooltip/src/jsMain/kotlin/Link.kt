package dev.petuska.kmdc.tooltip

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.MDCContentRaw
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLAnchorElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCContentDsl
@Composable
public fun MDCTooltipRichContentScope.Link(
  attrs: MDCAttrsRaw<HTMLAnchorElement>? = null,
  content: MDCContentRaw<HTMLAnchorElement>? = null,
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
public fun MDCTooltipRichContentScope.Link(
  text: String,
  href: String,
  attrs: MDCAttrsRaw<HTMLAnchorElement>? = null,
) {
  Link(attrs = {
    href(href)
    attrs?.invoke(this)
  }) {
    Text(text)
  }
}
