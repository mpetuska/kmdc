package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.kmdc.fab.*
import dev.petuska.kmdc.touch.target.*
import org.jetbrains.compose.web.dom.*
import sandbox.control.*

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
    ChoiceControl("Type", MDCFabType.values().associateBy(MDCFabType::name), type) { type = it }
    BooleanControl("Exited", ::exited)
    BooleanControl("Touch", ::touch)
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
