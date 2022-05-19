package sandbox.control

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.typography.MDCButtonText
import dev.petuska.kmdc.typography.MDCOverline
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.dom.Div

@Composable
fun NamedBlock(name: String, description: String? = null, content: @Composable () -> Unit) {
  Div {
    MDCOverline(name, attrs = {
      description?.let(::title)
      style { display(DisplayStyle("block ruby")) }
    })
    content()
  }
}

@Composable
fun NamedGroup(name: String, description: String? = null, content: @Composable () -> Unit) {
  Div {
    MDCButtonText(name, attrs = {
      description?.let(::title)
      style { display(DisplayStyle("block ruby")) }
    })
    Div(attrs = { style { paddingLeft(1.em) } }) {
      content()
    }
  }
}
