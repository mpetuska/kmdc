package dev.petuska.kmdc.top.app.bar

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.MDCContentRaw
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCContentDsl
@Composable
public fun MDCTopAppBarSectionScope.Title(
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContentRaw<HTMLSpanElement>? = null
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCContentDsl
@Composable
public fun MDCTopAppBarSectionScope.Title(
  text: String,
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
) {
  Title(attrs = attrs) {
    Text(text)
  }
}
