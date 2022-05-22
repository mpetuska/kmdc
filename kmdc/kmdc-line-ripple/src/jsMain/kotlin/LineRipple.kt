package dev.petuska.kmdc.line.ripple

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.core.ContentBuilder
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

@JsModule("@material/line-ripple/mdc-line-ripple.scss")
private external val MDCLineRippleStyles: dynamic

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-line-ripple)
 */
@MDCDsl
@Composable
public fun MDCLineRipple(
  active: Boolean,
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null
) {
  MDCLineRippleStyles
  Span(
    attrs = {
      classes("mdc-line-ripple")
      applyAttrs(attrs)
    },
    content = {
      MDCInitEffect(::MDCLineRipple)
      MDCSideEffect<MDCLineRipple>(active) {
        if (active) activate() else deactivate()
      }
      applyContent(content)
    },
  )
}
