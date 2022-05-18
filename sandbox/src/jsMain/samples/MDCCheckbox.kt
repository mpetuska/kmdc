package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField
import sandbox.control.BooleanChoice
import sandbox.control.TextInput

private class MDCCheckboxShowcaseVM {
  var disabled by mutableStateOf(false)
  var indeterminate by mutableStateOf(false)
  var touch by mutableStateOf(false)
  var label by mutableStateOf("My Checkbox")
  var checked by mutableStateOf(false)
}

@Composable
@Showcase(title = "MDCCheckbox", id = "MDCCheckbox")
fun MDCCheckboxShowcase() = InteractiveShowcase(
  viewModel = { MDCCheckboxShowcaseVM() },
  controls = {
    BooleanChoice("Disabled", disabled) { disabled = it }
    BooleanChoice("Indeterminate", indeterminate) { indeterminate = it }
    BooleanChoice("Touch", touch) { touch = it }
    TextInput("Label", label) { label = it }
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
