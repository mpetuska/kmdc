package dev.petuska.kmdc.touch.target

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.ContentBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@JsModule("@material/touch-target/mdc-touch-target.scss")
private external val MDCTouchTargetStyles: dynamic

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-touch-target)
 */
@MDCDsl
@Composable
public fun MDCTouchTarget(
  attrs: AttrsBuilder<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null
) {
  MDCTouchTargetStyles
  Div(
    attrs = {
      classes("mdc-touch-target-wrapper")
      applyAttrs(attrs)
    }, content = content
  )
}
