package sandbox.control

import androidx.compose.runtime.*
import dev.petuska.kmdc.textfield.*
import sandbox.util.*
import kotlin.reflect.*

@Composable
fun TextControl(
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
fun TextControl(
  name: String,
  text: KMutableProperty0<String>,
  description: String? = null,
) {
  TextControl(name, text.get(), description, text::set)
}
