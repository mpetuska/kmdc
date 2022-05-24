package dev.petuska.kmdc.tooltip

import androidx.compose.runtime.*
import dev.petuska.kmdc.button.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

public class MDCTooltipRichActionsScope(scope: ElementScope<HTMLDivElement>) :
  ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCDsl
@Composable
public fun MDCRichTooltipScope.MDCTooltipActions(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCTooltipRichActionsScope>? = null,
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCDsl
@Composable
public fun MDCTooltipRichActionsScope.MDCTooltipAction(
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: MDCContent<MDCButtonScope>? = null,
) {
  MDCButton(type = type, icon = icon, attrs = attrs, content = content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCDsl
@Composable
public fun MDCTooltipRichActionsScope.MDCTooltipAction(
  text: String,
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
) {
  MDCTooltipAction(type, icon, attrs) {
    Text(text)
  }
}
