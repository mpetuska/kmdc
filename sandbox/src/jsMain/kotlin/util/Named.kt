package sandbox.util

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.typography.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

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
