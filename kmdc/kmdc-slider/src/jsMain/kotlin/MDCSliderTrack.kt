package dev.petuska.kmdc.slider

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentDsl
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-slider)
 */
@MDCContentDsl
@Composable
internal fun MDCSliderTrack(
  tickMarks: Boolean,
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
) {
  Div(attrs = {
    classes("mdc-slider__track")
    attrs?.invoke(this)
  }) {
    Div(attrs = {
      classes("mdc-slider__track--inactive")
    })
    Div(attrs = {
      classes("mdc-slider__track--active")
    }) {
      Div(attrs = {
        classes("mdc-slider__track--active_fill")
      })
    }
    if (tickMarks) MDCSliderTickMarks()
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-slider)
 */
@MDCContentDsl
@Composable
private fun MDCSliderTickMarks(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
) {
  Div(
    attrs = {
      classes("mdc-slider__tick-marks")
      attrs?.invoke(this)
    },
  )
}
