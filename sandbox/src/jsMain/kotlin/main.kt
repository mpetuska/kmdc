package local.sandbox

import dev.petuska.kmdc.typography.MDCH1
import org.jetbrains.compose.web.renderComposable

fun main() {
  renderComposable(rootElementId = "root") {
    MDCH1("KMDC Sandbox")
    Samples.forEach { it() }
  }
}
