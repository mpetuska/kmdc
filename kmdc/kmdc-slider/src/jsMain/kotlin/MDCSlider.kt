package dev.petuska.kmdc.slider

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCInitEffect
import dev.petuska.kmdc.core.MDCStateEffect
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@JsModule("@material/slider/dist/mdc.slider.css")
private external val MDCSliderCSS: dynamic

public class MDCSliderAttrsScope(scope: AttrsScope<HTMLDivElement>) : AttrsScope<HTMLDivElement> by scope

public class MDCSliderScope(scope: ElementScope<HTMLDivElement>, public val options: MDCSliderOpts) :
  ElementScope<HTMLDivElement> by scope

public data class MDCSliderOpts(
  var disabled: Boolean = false,
  var discrete: Boolean = false,
  var tickMarks: Boolean = false,
  var value: Number = 0,
  var label: String? = null,
  var value2: Number? = null,
  var label2: String? = null,
  var min: Number = 0,
  var max: Number = 100,
  var step: Number = 1,
) {
  val range: Boolean get() = value2 != null
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-slider)
 */
@MDCDsl
@Composable
public fun MDCSlider(
  value: Number = 0,
  value2: Number? = null,
  disabled: Boolean = false,
  discrete: Boolean = false,
  tickMarks: Boolean = false,
  label: String? = null,
  label2: String? = null,
  min: Number = 0,
  max: Number = 100,
  step: Number = 1,
  attrs: Builder<MDCSliderAttrsScope>? = null,
) {
  MDCSliderCSS
  val range: Boolean = value2 != null
  Div(
    attrs = {
      classes("mdc-slider")
      if (range) classes("mdc-slider--range")
      if (discrete) classes("mdc-slider--discrete")
      if (tickMarks) classes("mdc-slider--tick-marks")
      if (disabled) classes("mdc-slider--disabled")
      attrs?.invoke(MDCSliderAttrsScope(this))
    }
  ) {
    if (range) {
      MDCSliderInput(
        value = value,
        min = min,
        max = value2!!,
        label = label,
        rangeStart = true,
        disabled = disabled,
        step = step,
      )
      MDCSliderInput(
        value = value2,
        min = value,
        max = max,
        label = label2,
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
      MDCSliderThumb(value = value, discrete = discrete)
      MDCSliderThumb(value = value2, discrete = discrete)
    } else {
      MDCSliderThumb(value = value, discrete = discrete)
    }
    MDCInitEffect(MDCSliderModule::MDCSlider, discrete, tickMarks, range, step, min, max)
    MDCStateEffect(disabled, MDCSliderModule.MDCSlider::setDisabled)
  }
}
