package dev.petuska.kmdc.segmented.button

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCDsl
@Composable
public fun MDCSegmentedButtonSegmentScope.Label(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null,
) {
  Div(
    attrs = {
      classes("mdc-segmented-button__label")
      attrs?.invoke(this)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCDsl
@Composable
public fun MDCSegmentedButtonSegmentScope.Label(
  text: String,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
) {
  Label(attrs) {
    Text(text)
  }
}
