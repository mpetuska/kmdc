package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.fab.MDCFab
import dev.petuska.kmdc.fab.MDCFabType
import dev.petuska.kmdc.touch.target.MDCTouchTarget
import sandbox.control.BooleanControl

private class MDCTouchTargetVM {
  var enabled by mutableStateOf(true)
}

@Composable
@Showcase(id = "MDCTouchTarget")
fun MDCTouchTarget() = InteractiveShowcase(
  viewModel = { MDCTouchTargetVM() },
  controls = {
    BooleanControl("Enabled", ::enabled)
  },
) {
  val render = @Composable {
    MDCFab(type = MDCFabType.Mini, touch = enabled)
  }
  if (enabled) {
    MDCTouchTarget {
      render()
    }
  } else {
    render()
  }
}
