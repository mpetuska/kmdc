package dev.petuska.kmdc.slider

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@JsModule("@material/slider/styles.scss")
private external val Style: dynamic

public interface MDCSliderAttrsScope : AttrsScope<HTMLDivElement>

public interface MDCSliderScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-slider)
 */
@MDCContentDsl
@Composable
public fun MDCSlider(
  value: Number,
  valueStart: Number? = null,
  disabled: Boolean = false,
  discrete: Boolean = false,
  tickMarks: Boolean = false,
  label: String? = null,
  labelStart: String? = null,
  min: Number = 0,
  max: Number = 100,
  step: Number = 1,
  attrs: MDCAttrs<MDCSliderAttrsScope>? = null,
) {
  Style
  val range: Boolean = valueStart != null
  Div(
    attrs = {
      classes("mdc-slider")
      if (range) classes("mdc-slider--range")
      if (discrete) classes("mdc-slider--discrete")
      if (tickMarks) classes("mdc-slider--tick-marks")
      if (disabled) classes("mdc-slider--disabled")
      applyAttrs(attrs)
    }
  ) {
    MDCProvider(::MDCSlider, discrete, tickMarks, range, step, min, max) {
      MDCStateEffect(disabled, MDCSlider::setDisabled)
      MDCStateEffect(value, MDCSlider::setValue)

      if (range) {
        MDCSliderInput(
          value = valueStart!!,
          min = min,
          max = valueStart,
          label = labelStart,
          rangeStart = true,
          disabled = disabled,
          step = step,
        )
        MDCSliderInput(
          value = value,
          min = value,
          max = max,
          label = label,
          rangeStart = false,
          disabled = disabled,
          step = step,
        )
      } else {
        MDCSliderInput(
          value = value,
          min = min,
          max = max,
          label = label,
          rangeStart = null,
          disabled = disabled,
          step = step,
        )
      }
      MDCSliderTrack(tickMarks = tickMarks)
      if (range) {
        MDCSliderThumb(value = valueStart, discrete = discrete)
        MDCSliderThumb(value = value, discrete = discrete)
      } else {
        MDCSliderThumb(value = value, discrete = discrete)
      }
    }
  }
}
