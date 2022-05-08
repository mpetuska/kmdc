import engine.Sandbox
import org.jetbrains.compose.web.renderComposable

fun main() {
  renderComposable(rootElementId = "root") {
    Sandbox()
  }
}
