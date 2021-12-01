package local.sandbox

import dev.petuska.kmdc.layout.grid.MDCLayoutGrid
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCells
import dev.petuska.kmdc.typography.MDCH1
import org.jetbrains.compose.web.renderComposable


fun main() {
  renderComposable(rootElementId = "root") {
    MDCH1("KMDC Sandbox")
    MDCLayoutGrid {
      MDCLayoutGridCells {
        Samples.forEach { it() }
      }
      MultipleFieldsSample()
    }
  }
}

