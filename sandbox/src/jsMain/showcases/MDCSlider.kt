package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.kmdc.slider.*
import sandbox.control.*
import kotlin.math.*

private class MDCSliderVM {
  var disabled by mutableStateOf(false)
  var discrete by mutableStateOf(false)
  var tickMarks by mutableStateOf(false)
  var range by mutableStateOf(false)
  var step by mutableStateOf(1)
  var min by mutableStateOf(0)
  var max by mutableStateOf(100)
  var label by mutableStateOf("My Label")

  var value by mutableStateOf(50)
  var valueStart by mutableStateOf<Int?>(null)

  fun setValues(
    step: Int = this.step,
    min: Int = this.min,
    max: Int = this.max,
    value: Int = this.value,
    valueStart: Int? = this.valueStart,
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
    this.value = max(value - value % step, this.valueStart ?: 0).coerceIn(this.min, this.max)
    this.valueStart = valueStart?.let {
      min(valueStart - valueStart % step, value).coerceIn(this.min, this.max)
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
        value = max(valueStart ?: value, value),
        valueStart = if (it) value else null,
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
    labelStart = label,
    value = value,
    valueStart = valueStart,
    attrs = {
      registerEvents()
      onInput { e ->
        e.detail.let {
          if (it.thumb == 2) {
            value = it.value.toInt()
          } else {
            valueStart = it.value.toInt()
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
