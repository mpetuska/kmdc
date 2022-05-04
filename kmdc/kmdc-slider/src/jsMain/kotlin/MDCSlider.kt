package dev.petuska.kmdc.slider

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCSideEffect
import dev.petuska.kmdc.core.initialiseMDC
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
  opts: Builder<MDCSliderOpts>? = null,
  attrs: Builder<MDCSliderAttrsScope>? = null,
) {
  MDCSliderCSS
  val options = MDCSliderOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-slider")
      if (options.range) classes("mdc-slider--range")
      if (options.discrete) classes("mdc-slider--discrete")
      if (options.tickMarks) classes("mdc-slider--tick-marks")
      if (options.disabled) classes("mdc-slider--disabled")
      initialiseMDC(MDCSliderModule.MDCSlider::attachTo) {
        setDisabled(options.disabled)
      }
      attrs?.invoke(MDCSliderAttrsScope(this))
    }
  ) {
    MDCSideEffect(options.disabled, MDCSliderModule.MDCSlider::setDisabled)
    with(options) {
      if (range) {
        MDCSliderInput(value = value, min = min, max = value2!!, label = label, rangeStart = true)
        MDCSliderInput(value = value2!!, min = value, max = max, label = label2, rangeStart = false)
      } else {
        MDCSliderInput(value = value, min = min, max = max, label = label, rangeStart = null)
      }
      MDCSliderTrack()
      if (range) {
        MDCSliderThumb(value)
        MDCSliderThumb(value2)
      } else {
        MDCSliderThumb(value)
      }
    }
  }
}
