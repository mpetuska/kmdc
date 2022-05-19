package sandbox.control

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.textfield.MDCTextField

@Composable
fun TextInput(
  name: String,
  text: String,
  description: String? = null,
  onInput: (String) -> Unit,
) {
  Named(name, description) {
    MDCTextField(
      value = text,
      attrs = {
        onInput { onInput(it.value) }
      }
    )
  }
}
