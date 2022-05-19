package sandbox.control

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField
import kotlin.reflect.KMutableProperty0


@Composable
fun BooleanChoice(
  title: String,
  selected: Boolean,
  description: String? = null,
  onSelect: (selected: Boolean) -> Unit
) {
  Named(title, description) {
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

@Composable
fun BooleanChoice(
  title: String,
  property: KMutableProperty0<Boolean>,
  description: String? = null
) {
  BooleanChoice(title, property.get(), description, onSelect = { property.set(it) })
}
