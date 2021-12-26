package dev.petuska.kmdc.tooltip

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLParagraphElement

public class MDCTooltipRichContentScope(scope: ElementScope<HTMLParagraphElement>) :
  ElementScope<HTMLParagraphElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-tooltip)
 */
@MDCDsl
@Composable
public fun MDCRichTooltipScope.MDCTooltipContent(
  attrs: AttrBuilderContext<HTMLParagraphElement>? = null,
  content: ComposableBuilder<MDCTooltipRichContentScope>? = null,
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-tooltip)
 */
@MDCDsl
@Composable
public fun MDCRichTooltipScope.MDCTooltipContent(
  text: String,
  attrs: AttrBuilderContext<HTMLParagraphElement>? = null,
) {
  MDCTooltipContent(attrs) {
    Text(text)
  }
}
