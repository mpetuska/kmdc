package sandbox.control

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField


@Composable
fun BooleanChoice(
  title: String,
  selected: Boolean,
  description: String? = null,
  onSelect: (selected: Boolean) -> Unit
) {
  NamedInput(title, description) {
    MDCFormField {
      MDCCheckbox(
        checked = selected,
        attrs = {
          onInput { onSelect(!selected) }
        }
      )
    }
  }
}
