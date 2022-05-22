package dev.petuska.kmdc.button

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-button)
 */
@MDCDsl
@Composable
public fun MDCButtonScope.Label(
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-button)
 */
@MDCDsl
@Composable
public fun MDCButtonScope.Label(
  text: String,
  attrs: AttrBuilderContext<HTMLSpanElement>? = null,
) {
  Label(attrs) {
    Text(text)
  }
}
