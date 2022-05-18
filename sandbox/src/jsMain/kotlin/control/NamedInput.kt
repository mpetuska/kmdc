package sandbox.control

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.typography.MDCOverline
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.dom.Div

@Composable
fun NamedInput(name: String, description: String? = null, content: @Composable () -> Unit) {
  Div {
    MDCOverline(name, attrs = {
      classes("mdc-typography--overline")
      description?.let(::title)
      style { display(DisplayStyle("block ruby")) }
    })
    content()
  }
}
