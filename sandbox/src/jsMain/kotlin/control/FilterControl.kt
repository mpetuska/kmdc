package sandbox.control

import androidx.compose.runtime.*
import dev.petuska.kmdc.checkbox.*
import sandbox.util.*

@Composable
fun FilterControl(
  title: String,
  options: Map<String, Boolean>,
  description: String? = null,
  onSelect: (label: String, selected: Boolean) -> Unit
) {
  NamedBlock(title, description) {
    ChunkedFormFields(options.entries) { (text, selected) ->
      MDCCheckbox(
        checked = selected,
        label = text,
        attrs = {
          onInput { onSelect(text, !selected) }
        }
      )
    }
  }
}
