package dev.petuska.kmdc.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-button)
 */
@MDCDsl
@Composable
public fun MDCButtonScope.MDCButtonLabel(
  attrs: AttrBuilderContext<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null,
) {
  Span(
    attrs = {
      classes("mdc-button__label")
      attrs?.invoke(this)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-button)
 */
@MDCDsl
@Composable
public fun MDCButtonScope.MDCButtonLabel(
  text: String,
  attrs: AttrBuilderContext<HTMLSpanElement>? = null,
) {
  MDCButtonLabel(attrs) {
    Text(text)
  }
}
