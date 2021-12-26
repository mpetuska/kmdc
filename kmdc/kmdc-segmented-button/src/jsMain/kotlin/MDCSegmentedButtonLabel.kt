package dev.petuska.kmdc.segmented.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-segmented-button)
 */
@MDCDsl
@Composable
public fun MDCSegmentedButtonSegmentScope.MDCSegmentedButtonLabel(
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-segmented-button)
 */
@MDCDsl
@Composable
public fun MDCSegmentedButtonSegmentScope.MDCSegmentedButtonLabel(
  text: String,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
) {
  MDCSegmentedButtonLabel(attrs) {
    Text(text)
  }
}
