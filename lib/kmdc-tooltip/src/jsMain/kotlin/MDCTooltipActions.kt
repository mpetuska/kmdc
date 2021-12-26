package dev.petuska.kmdc.tooltip

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement

public class MDCTooltipRichActionsScope(scope: ElementScope<HTMLDivElement>) :
  ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-tooltip)
 */
@MDCDsl
@Composable
public fun MDCRichTooltipScope.MDCTooltipActions(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCTooltipRichActionsScope>? = null,
) {
  Div(
    attrs = {
      classes("mdc-tooltip--rich-actions")
      attrs?.invoke(this)
    },
    content = content?.let { { MDCTooltipRichActionsScope(this).it() } }
  )
}

/**
 * [Bugged](https://github.com/material-components/material-components-web/issues/7496)
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-tooltip)
 */
@MDCDsl
@Composable
public fun MDCTooltipRichActionsScope.MDCTooltipAction(
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: ContentBuilder<HTMLButtonElement>? = null,
) {
  Button(
    attrs = {
      classes("mdc-tooltip__action")
      attr("aria-label", "action")
      attrs?.invoke(this)
    },
    content = content,
  )
}

/**
 * [Bugged](https://github.com/material-components/material-components-web/issues/7496)
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-tooltip)
 */
@MDCDsl
@Composable
public fun MDCTooltipRichActionsScope.MDCTooltipAction(
  text: String,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
) {
  MDCTooltipAction(attrs) {
    Text(text)
  }
}
