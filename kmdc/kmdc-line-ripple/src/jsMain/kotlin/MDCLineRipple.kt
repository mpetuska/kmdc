package dev.petuska.kmdc.line.ripple

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

@JsModule("@material/line-ripple/mdc-line-ripple.scss")
private external val Style: dynamic

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-line-ripple)
 */
@MDCContentDsl
@Composable
public fun MDCLineRipple(
  active: Boolean,
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null
) {
  MDCLineRippleLayout(
    attrs = attrs,
  ) {
    MDCProvider(::MDCLineRipple) {
      MDCSideEffectNew(active) {
        if (active) activate() else deactivate()
      }
      applyContent(content)
    }
  }
}

@Composable
@KMDCInternalAPI
public fun MDCLineRippleLayout(
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null
) {
  Style
  Span(
    attrs = {
      classes("mdc-line-ripple")
      applyAttrs(attrs)
    },
    content = content,
  )
}
