package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.kmdc.checkbox.*
import dev.petuska.kmdc.form.field.*
import sandbox.control.*

private class MDCCheckboxVM {
  var disabled by mutableStateOf(false)
  var indeterminate by mutableStateOf(false)
  var touch by mutableStateOf(false)
  var label by mutableStateOf("My Checkbox")
  var checked by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCCheckbox")
fun MDCCheckbox() = InteractiveShowcase(
  viewModel = { MDCCheckboxVM() },
  controls = {
    BooleanControl("Disabled", ::disabled)
    BooleanControl("Indeterminate", ::indeterminate)
    BooleanControl("Touch", ::touch)
    BooleanControl("Checked", ::checked)
    TextControl("Label", label) { label = it }
  },
) {
  MDCFormField {
    MDCCheckbox(
      checked = checked.takeIf { !indeterminate },
      disabled = disabled,
      touch = touch,
      label = label,
      attrs = {
        onInput { checked = !checked }
      }
    )
  }
}
