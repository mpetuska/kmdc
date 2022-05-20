package sandbox.control

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.typography.MDCButtonText
import dev.petuska.kmdc.typography.MDCOverline
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@Composable
fun NamedBlock(
  name: String,
  description: String? = null,
  attrs: AttrsBuilder<HTMLDivElement>? = null,
  content: @Composable () -> Unit
) {
  Div(attrs = attrs) {
    MDCOverline(name, attrs = {
      description?.let(::title)
      style { display(DisplayStyle("block ruby")) }
    })
    content()
  }
}

@Composable
fun NamedGroup(
  name: String, description: String? = null,
  attrs: AttrsBuilder<HTMLDivElement>? = null,
  content: @Composable () -> Unit
) {
  Div(attrs = attrs) {
    MDCButtonText(name, attrs = {
      description?.let(::title)
      style { display(DisplayStyle("block ruby")) }
    })
    Div(attrs = { style { paddingLeft(1.em) } }) {
      content()
    }
  }
}
