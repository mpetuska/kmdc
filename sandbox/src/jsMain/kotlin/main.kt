package local.sandbox

import local.sandbox.engine.Sandbox
import org.jetbrains.compose.web.renderComposable

fun main() {
  renderComposable(rootElementId = "root") {
    Sandbox()
  }
}
