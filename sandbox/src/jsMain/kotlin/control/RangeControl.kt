package sandbox.control

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.slider.MDCSlider
import dev.petuska.kmdc.slider.onInput
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.margin
import kotlin.reflect.KMutableProperty0

@Composable
fun RangeControl(
  name: String,
  value: Number,
  min: Number = 0,
  max: Number = 100,
  step: Number = 1,
  description: String? = null,
  onInput: (Number) -> Unit,
) {
  NamedBlock(name, description) {
    MDCSlider(
      value = value,
      label = "Size",
      discrete = true,
      min = min,
      max = max,
      step = step,
      attrs = {
        onInput {
          onInput(it.detail.value)
        }
        style { margin(0.em) }
      })
  }
}

@Composable
fun <T : Number> RangeControl(
  name: String,
  value: KMutableProperty0<T>,
  min: Number = 0,
  max: Number = 100,
  step: Number = 1,
  description: String? = null,
  converter: Number.() -> T
) {
  RangeControl(name, value.get(), min, max, step, description) {
    value.set(it.converter())
  }
}
