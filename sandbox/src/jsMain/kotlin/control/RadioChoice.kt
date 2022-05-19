package sandbox.control

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdc.radio.MDCRadio
import kotlin.reflect.KMutableProperty0


@Composable
fun <T> RadioChoice(
  title: String,
  options: Map<String, T>,
  selected: T?,
  description: String? = null,
  onSelect: (selected: T) -> Unit
) {
  NamedBlock(title, description) {
    MDCFormField {
      options.forEach { (text, value) ->
        MDCRadio(checked = selected == value, opts = {
          label = text
        }, attrs = {
          onInput { onSelect(value) }
        })
      }
    }
  }
}

@Composable
fun <T> RadioChoice(
  title: String,
  options: Map<String, T>,
  selected: KMutableProperty0<T>,
  description: String? = null,
) {
  RadioChoice(title, options, selected.get(), description, selected::set)
}
