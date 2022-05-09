import engine.Sandbox
import org.jetbrains.compose.web.renderComposable

fun main() {
  renderComposable(rootElementId = "root") {
    samples.require("./sandbox.scss")
    Sandbox()
  }
}
