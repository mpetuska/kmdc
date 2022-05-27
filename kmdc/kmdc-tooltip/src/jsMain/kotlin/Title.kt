package dev.petuska.kmdc.tooltip

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.MDCContentRaw
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLHeadingElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCContentDsl
@Composable
public fun MDCRichTooltipScope.Title(
  attrs: MDCAttrsRaw<HTMLHeadingElement>? = null,
  content: MDCContentRaw<HTMLHeadingElement>? = null,
) {
  H2(
    attrs = {
      classes("mdc-tooltip__title")
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
public fun MDCRichTooltipScope.Title(
  text: String,
  attrs: MDCAttrsRaw<HTMLHeadingElement>? = null,
) {
  Title(attrs) {
    Text(text)
  }
}
