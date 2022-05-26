package dev.petuska.kmdc.drawer

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-drawer)
 */
@MDCContentDsl
@Composable
public fun MDCDrawerScope.MDCDrawerContent(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null
) {
  Div(
    attrs = {
      classes("mdc-drawer__content")
      attrs?.invoke(this)
    },
    content = content,
  )
}
