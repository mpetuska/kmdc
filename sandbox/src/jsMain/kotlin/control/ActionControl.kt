package sandbox.control

import androidx.compose.runtime.*
import dev.petuska.kmdc.button.*
import org.jetbrains.compose.web.dom.*

@Composable
fun ActionControl(
  name: String,
  description: String? = null,
  onAction: () -> Unit,
) {
  Div {
    MDCButton(text = name, type = MDCButtonType.Raised, attrs = {
      onClick { onAction() }
      description?.let(::title)
    })
  }
}
