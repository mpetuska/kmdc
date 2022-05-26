package dev.petuska.kmdc.tooltip

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

public class MDCTooltipRichContentScope(scope: ElementScope<HTMLParagraphElement>) :
  ElementScope<HTMLParagraphElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCContentDsl
@Composable
public fun MDCRichTooltipScope.MDCTooltipContent(
  attrs: AttrBuilderContext<HTMLParagraphElement>? = null,
  content: MDCContent<MDCTooltipRichContentScope>? = null,
) {
  P(
    attrs = {
      classes("mdc-tooltip__content")
      attrs?.invoke(this)
    },
    content = content?.let { { MDCTooltipRichContentScope(this).it() } }
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCContentDsl
@Composable
public fun MDCRichTooltipScope.MDCTooltipContent(
  text: String,
  attrs: AttrBuilderContext<HTMLParagraphElement>? = null,
) {
  MDCTooltipContent(attrs) {
    Text(text)
  }
}
