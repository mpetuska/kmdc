package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField
import sandbox.control.BooleanControl
import sandbox.control.TextControl

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
