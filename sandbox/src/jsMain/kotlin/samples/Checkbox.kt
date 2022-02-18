package local.sandbox.samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField
import local.sandbox.engine.Sample
import local.sandbox.engine.Samples

@Suppress("unused")
private val CheckboxSamples = Samples("MDCCheckbox") {
  var checked by remember { mutableStateOf(false) }
  Sample("Default") {
    MDCFormField {
      MDCCheckbox(
        checked = checked,
        label = it,
        attrs = { onClick { checked = !checked } }
      )
    }
  }
  Sample("Disabled") {
    MDCFormField {
      MDCCheckbox(
        checked = checked,
        label = it,
        disabled = true,
      )
    }
  }
  Sample("Indeterminate", "Toggle `Default` checkbox to see changes") {
    MDCFormField {
      MDCCheckbox(
        checked = checked.takeIf { it },
        label = it,
      )
    }
  }
}
