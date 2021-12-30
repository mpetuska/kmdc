package dev.petuska.kmdc.slider

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-slider)
 */
@MDCDsl
@Composable
internal fun MDCSliderOpts.MDCSliderTrack(
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
      classes("mdc-slider--active")
    }) {
      Div(attrs = {
        classes("mdc-slider__track--active_fill")
      })
    }
    if (tickMarks) MDCSliderTickMarks()
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-slider)
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
