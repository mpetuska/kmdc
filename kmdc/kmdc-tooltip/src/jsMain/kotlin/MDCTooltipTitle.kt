package dev.petuska.kmdc.tooltip

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLHeadingElement

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
