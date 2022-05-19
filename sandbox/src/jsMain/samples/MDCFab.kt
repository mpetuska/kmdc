package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.fab.Icon
import dev.petuska.kmdc.fab.Label
import dev.petuska.kmdc.fab.MDCFab
import dev.petuska.kmdc.fab.MDCFabType
import dev.petuska.kmdc.touch.target.MDCTouchTarget
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanChoice
import sandbox.control.RadioChoice

private class MDCFabVM {
  var exited by mutableStateOf(false)
  var type by mutableStateOf(MDCFabType.Regular)
  var touch by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCFab")
fun MDCFab() = InteractiveShowcase(
  viewModel = { MDCFabVM() },
  controls = {
    RadioChoice("Type", MDCFabType.values().associateBy(MDCFabType::name), type) { type = it }
    BooleanChoice("Exited", ::exited)
    BooleanChoice("Touch", ::touch)
  },
) {
  val content = @Composable {
    MDCFab(touch = touch, exited = exited, type = type, attrs = {
      attr("aria-label", "Favorite")
    }) {
      if (type == MDCFabType.Extended) Label("Favorite")
      Icon(attrs = { classes("material-icons") }) { Text("favorite") }
    }
  }
  if (touch) {
    MDCTouchTarget {
      content()
    }
  } else {
    content()
  }
}
