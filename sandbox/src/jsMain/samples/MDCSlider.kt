package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.slider.MDCSlider
import dev.petuska.kmdc.slider.MDCSliderAttrsScope
import dev.petuska.kmdc.slider.onChange
import dev.petuska.kmdc.slider.onInput
import sandbox.control.BooleanControl
import sandbox.control.RangeControl
import sandbox.control.TextControl
import kotlin.math.max
import kotlin.math.min

private class MDCSliderVM {
  var disabled by mutableStateOf(false)
  var discrete by mutableStateOf(false)
  var tickMarks by mutableStateOf(false)
  var range by mutableStateOf(false)
  var step by mutableStateOf(1)
  var min by mutableStateOf(0)
  var max by mutableStateOf(100)
  var label by mutableStateOf("My Label")

  var value1 by mutableStateOf(50)
  var value2 by mutableStateOf<Int?>(null)

  fun setValues(
    value1: Int = this.value1,
    value2: Int? = this.value2,
    min: Int = this.min,
    max: Int = this.max,
    step: Int = this.step,
  ) {
    this.step = step
    this.max -= max % step
    this.min += min(this.max, step - min % step)
    this.value1 -= min(value1 % step, value2 ?: Int.MAX_VALUE)
    this.value2 = value2?.let {
      it - max(it % step, value1)
    }
  }
}

@Composable
@Showcase(id = "MDCSlider")
fun MDCSlider() = InteractiveShowcase(
  viewModel = { MDCSliderVM() },
  controls = {
    BooleanControl("Disabled", ::disabled)
    BooleanControl("Discrete", ::discrete)
    BooleanControl("Tick Marks", ::tickMarks)
    BooleanControl("Range", range) {
      range = it
      setValues(
        value2 = if (it) max(value2 ?: value1, value1) else null,
        value1 = min(value1, value2 ?: Int.MAX_VALUE),
      )
    }
    RangeControl("Step", step, min = 1, max = 10) {
      setValues(step = it.toInt())
    }
    RangeControl("Min", min, min = 0, max = 100) {
      setValues(min = it.toInt())
    }
    RangeControl("Max", max, min = 0, max = 100) {
      setValues(max = it.toInt())
    }
    TextControl("Label", ::label)
  },
) {
  MDCSlider(
    disabled = disabled,
    discrete = discrete,
    tickMarks = tickMarks,
    step = step,
    min = min,
    max = max,
    label = label,
    label2 = label,
    value = value1,
    value2 = value2,
    attrs = {
      registerEvents()
      onInput {
        it.detail.run {
          if (thumb == 1) {
            value1 = value.toInt()
          } else {
            value2 = value.toInt()
          }
        }
      }
    }
  )
}

private fun MDCSliderAttrsScope.registerEvents() {
  onInput { console.log("MDCSlider#onInput", it.detail) }
  onChange { console.log("MDCSlider#onChange", it.detail) }
}
