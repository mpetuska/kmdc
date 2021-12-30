package dev.petuska.kmdc.slider

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.aria
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-slider)
 */
@MDCDsl
@Composable
internal fun MDCSliderOpts.MDCSliderThumb(
  value: Number? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
) {
  Div(attrs = {
    classes("mdc-slider__thumb")
    attrs?.invoke(this)
  }) {
    if (discrete && value != null) {
      Div(attrs = {
        classes("mdc-slider__value-indicator-container")
        aria("hidden", "true")
      }) {
        Div(attrs = { classes("mdc-slider__value-indicator") }) {
          Div(attrs = { classes("mdc-slider__value-indicator-text") }) {
            Text("$value")
          }
        }
      }
    }
    Div(attrs = { classes("mdc-slider__thumb-knob") })
  }
}
