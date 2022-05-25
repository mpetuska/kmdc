package dev.petuska.kmdc.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentRaw
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-button)
 */
@MDCDsl
@Composable
public fun MDCButtonScope<*>.Label(
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContentRaw<HTMLSpanElement>? = null,
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
public fun MDCButtonScope<*>.Label(
  text: String,
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
) {
  Label(attrs) {
    Text(text)
  }
}
