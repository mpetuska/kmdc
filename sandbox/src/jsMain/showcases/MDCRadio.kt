package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.kmdc.form.field.*
import dev.petuska.kmdc.radio.*
import sandbox.control.*

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
