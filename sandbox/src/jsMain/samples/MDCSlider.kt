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
    step: Int = this.step,
    min: Int = this.min,
    max: Int = this.max,
    value1: Int = this.value1,
    value2: Int? = this.value2,
  ) {
    this.step = step
    val mi = max(0, min - min % step)
    val ma = min(100 - 100 % step, max - max % step)
    when {
      mi == ma && mi != 0 -> {
        this.min = mi - step
        this.max = ma
      }
      mi == ma && mi == 0 -> {
        this.min = mi
        this.max = ma + step
      }
      mi > ma -> {
        this.min = ma
        this.max = mi
      }
      else -> {
        this.min = mi
        this.max = ma
      }
    }
    this.value1 = min(value1 - value1 % step, value2 ?: Int.MAX_VALUE).coerceIn(this.min, this.max)
    this.value2 = value2?.let {
      max(value2 - value2 % step, this.value1).coerceIn(this.min, this.max)
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
        value1 = min(value1, value2 ?: Int.MAX_VALUE),
        value2 = if (it) max(value2 ?: value1, value1) else null,
      )
    }
    RangeControl("Step", step, min = 1, max = 10) {
      setValues(step = it.toInt())
    }
    RangeControl("Min", min, min = 0, max = 99) {
      setValues(min = it.toInt())
    }
    RangeControl("Max", max, min = 1, max = 100) {
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
          if (thumb == 1 || !range) {
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
