package dev.petuska.kmdc.slider

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.aria
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-slider)
 */
@MDCContentDsl
@Composable
internal fun MDCSliderThumb(
  value: Number?,
  discrete: Boolean,
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
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
