package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdc.radio.MDCRadio
import sandbox.control.BooleanControl

private class MDCRadioVM {
  val options = listOf("A", "B", "C", "D")
  var disabled by mutableStateOf(false)
  var touch by mutableStateOf(false)

  var selected by mutableStateOf<String?>(null)
}

@Composable
@Showcase(id = "MDCRadio")
fun MDCRadio() = InteractiveShowcase(
  viewModel = { MDCRadioVM() },
  controls = {
    BooleanControl("Disabled", ::disabled)
    BooleanControl("Touch", ::touch)
  },
) {
  MDCFormField {
    options.forEach { text ->
      MDCRadio(
        checked = (text == selected),
        label = text,
        disabled = disabled,
        touch = touch,
        attrs = {
          onInput { selected = text }
        }
      )
    }
  }
}
