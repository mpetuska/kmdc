package dev.petuska.kmdc.elevation

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.ContentBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@JsModule("@material/elevation/mdc-elevation.scss")
private external val Styles: dynamic

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-elevation)
 */
@MDCDsl
@Composable
public fun MDCElevation(
  z: Int,
  attrs: AttrsBuilder<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null
) {
  Styles
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
@MDCDsl
@Composable
public fun MDCElevationOverlay(
  attrs: AttrsBuilder<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null
) {
  Styles
  Div(
    attrs = {
      classes("mdc-elevation-overlay")
      applyAttrs(attrs)
    },
    content = content,
  )
}
