package sandbox.control

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.textfield.MDCTextField
import kotlin.reflect.KMutableProperty0

@Composable
fun TextInput(
  name: String,
  text: String,
  description: String? = null,
  onInput: (String) -> Unit,
) {
  NamedBlock(name, description) {
    MDCTextField(
      value = text,
      attrs = {
        onInput { onInput(it.value) }
      }
    )
  }
}

@Composable
fun TextInput(
  name: String,
  text: KMutableProperty0<String>,
  description: String? = null,
) {
  TextInput(name, text.get(), description, text::set)
}
