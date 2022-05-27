package dev.petuska.kmdc.touch.target

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.MDCContentRaw
import dev.petuska.kmdc.core.applyAttrs
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@JsModule("@material/touch-target/mdc-touch-target.scss")
private external val Style: dynamic

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-touch-target)
 */
@MDCContentDsl
@Composable
public fun MDCTouchTarget(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContentRaw<HTMLDivElement>? = null
) {
  Style
  Div(
    attrs = {
      classes("mdc-touch-target-wrapper")
      applyAttrs(attrs)
    }, content = content
  )
}
