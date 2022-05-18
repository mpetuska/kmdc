package sandbox.control

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField


@Composable
fun <T> MultiChoice(
  title: String,
  options: Map<String, Boolean>,
  description: String? = null,
  onSelect: (label: String, selected: Boolean) -> Unit
) {
  NamedInput(title, description) {
    MDCFormField {
      options.forEach { (text, selected) ->
        MDCCheckbox(
          checked = selected,
          label = text,
          attrs = {
            onInput { onSelect(text, !selected) }
          })
      }
    }
  }
}
