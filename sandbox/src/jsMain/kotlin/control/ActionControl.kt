package sandbox.control

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonType
import org.jetbrains.compose.web.dom.Div

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
