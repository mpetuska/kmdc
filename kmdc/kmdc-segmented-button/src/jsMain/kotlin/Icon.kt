package dev.petuska.kmdc.segmented.button

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCContentDsl
@Composable
public fun MDCSegmentedButtonSegmentScope.Icon(
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: ContentBuilder<HTMLElement>? = null,
) {
  I(
    attrs = {
      classes("mdc-segmented-button__icon")
      attrs?.invoke(this)
    },
    content = content
  )
}
