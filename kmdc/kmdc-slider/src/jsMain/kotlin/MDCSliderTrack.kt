package dev.petuska.kmdc.slider

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-slider)
 */
@MDCDsl
@Composable
internal fun MDCSliderTrack(
  tickMarks: Boolean,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
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
@MDCDsl
@Composable
private fun MDCSliderTickMarks(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
) {
  Div(
    attrs = {
      classes("mdc-slider__tick-marks")
      attrs?.invoke(this)
    },
  )
}
