package dev.petuska.kmdc.elevation

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.MDCContentRaw
import dev.petuska.kmdc.core.applyAttrs
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@JsModule("@material/elevation/mdc-elevation.scss")
private external val Style: dynamic

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-elevation)
 */
@MDCContentDsl
@Composable
public fun MDCElevation(
  z: Int,
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContentRaw<HTMLDivElement>? = null
) {
  Style
  Div(
    attrs = {
      classes("mdc-elevation--z$z")
      applyAttrs(attrs)
    },
    content = content,
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-elevation)
 */
@MDCContentDsl
@Composable
public fun MDCElevationOverlay(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContentRaw<HTMLDivElement>? = null
) {
  Style
  Div(
    attrs = {
      classes("mdc-elevation-overlay")
      applyAttrs(attrs)
    },
    content = content,
  )
}
