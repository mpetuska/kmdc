package samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField

object MDCCheckbox : Samples() {
  override val content: SamplesRender = {
    var checked by rememberMutableStateOf(false)
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
    Sample(
      name = "Indeterminate",
      description = "Toggle `Default` checkbox to see changes"
    ) {
      MDCFormField {
        MDCCheckbox(
          checked = checked.takeIf { it },
          label = it,
        )
      }
    }
  }
}
