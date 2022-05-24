package sandbox.control

import androidx.compose.runtime.*
import dev.petuska.kmdc.radio.*
import sandbox.util.*
import kotlin.reflect.*

@Composable
fun <T> ChoiceControl(
  title: String,
  options: Map<String, T>,
  selected: T?,
  description: String? = null,
  onSelect: (selected: T) -> Unit
) {
  NamedBlock(title, description) {
    ChunkedFormFields(options.entries) { (text, value) ->
      MDCRadio(
        checked = selected == value,
        label = text,
        attrs = {
          onInput { onSelect(value) }
        }
      )
    }
  }
}

@Composable
fun <T> ChoiceControl(
  title: String,
  options: Map<String, T>,
  selected: KMutableProperty0<T>,
  description: String? = null,
) {
  ChoiceControl(title, options, selected.get(), description, selected::set)
}
