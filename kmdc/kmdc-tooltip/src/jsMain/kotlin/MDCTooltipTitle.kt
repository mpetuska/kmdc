package dev.petuska.kmdc.tooltip

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCDsl
@Composable
public fun MDCRichTooltipScope.MDCTooltipTitle(
  attrs: AttrBuilderContext<HTMLHeadingElement>? = null,
  content: ContentBuilder<HTMLHeadingElement>? = null,
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
@MDCDsl
@Composable
public fun MDCRichTooltipScope.MDCTooltipTitle(
  text: String,
  attrs: AttrBuilderContext<HTMLHeadingElement>? = null,
) {
  MDCTooltipTitle(attrs) {
    Text(text)
  }
}
