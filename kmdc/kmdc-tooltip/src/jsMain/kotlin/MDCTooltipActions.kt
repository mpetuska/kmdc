@file:Suppress("NOTHING_TO_INLINE")

package dev.petuska.kmdc.tooltip

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonOpts
import dev.petuska.kmdc.button.MDCButtonScope
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement

public class MDCTooltipRichActionsScope(scope: ElementScope<HTMLDivElement>) :
  ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCDsl
@Composable
public fun MDCTooltipRichActionsScope.MDCTooltipAction(
  opts: Builder<MDCButtonOpts>? = null,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: ComposableBuilder<MDCButtonScope>? = null,
) {
  MDCButton(opts = opts, attrs = attrs, content = content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCDsl
@Composable
public inline fun MDCTooltipRichActionsScope.MDCTooltipAction(
  text: String,
  noinline opts: Builder<MDCButtonOpts>? = null,
  noinline attrs: AttrBuilderContext<HTMLButtonElement>? = null,
) {
  MDCTooltipAction(opts, attrs) {
    Text(text)
  }
}
