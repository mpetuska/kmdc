package dev.petuska.kmdc.card

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCDsl
@Composable
public fun MDCCardScope.MDCCardPrimaryAction(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null
) {
  Div(
    attrs = {
      classes("mdc-card__primary-action")
      tabIndex(0)
      attrs?.invoke(this)
    },
  ) {
    content?.invoke(this)
    Span(attrs = { classes("mdc-card__ripple") })
  }
}
