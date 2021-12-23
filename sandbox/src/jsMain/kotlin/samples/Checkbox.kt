package local.sandbox.samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField
import local.sandbox.Sample
import local.sandbox.Samples

@Suppress("unused")
val CheckboxSamples = Samples("Checkbox") {
  var checked by remember { mutableStateOf(false) }
  Sample("Default") {
    MDCFormField {
      MDCCheckbox(
        checked = checked,
        opts = { label = it },
        attrs = { onClick { checked = !checked } }
      )
    }
  }
  Sample("Disabled") {
    MDCFormField {
      MDCCheckbox(
        checked = checked,
        opts = {
          label = it
          disabled = true
        }
      )
    }
  }
  Sample("Indeterminate") {
    MDCFormField {
      MDCCheckbox(
        checked = checked,
        opts = {
          label = it
          indeterminate = !checked
        }
      )
    }
  }
}
