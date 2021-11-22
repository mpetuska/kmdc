package dev.petuska.kmdc.top.app.bar

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-top-app-bar)
 */
@MDCDsl
@Composable
public fun MDCTopAppBarSectionScope.MDCTopAppBarTitle(
  attrs: AttrBuilderContext<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null
) {
  Span(
    attrs = {
      classes("mdc-top-app-bar__title")
      attrs?.invoke(this)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-top-app-bar)
 */
@MDCDsl
@Composable
public fun MDCTopAppBarSectionScope.MDCTopAppBarTitle(
  text: String,
  attrs: AttrBuilderContext<HTMLSpanElement>? = null,
) {
  MDCTopAppBarTitle(attrs = attrs) {
    Text(text)
  }
}
