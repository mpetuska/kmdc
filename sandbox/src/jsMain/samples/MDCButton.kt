package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.button.Icon
import dev.petuska.kmdc.button.Label
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonIconType
import dev.petuska.kmdc.button.MDCButtonType
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanChoice
import sandbox.control.RadioChoice

private class MDCButtonShowcaseVM {
  var type by mutableStateOf(MDCButtonType.Text)
  var icon by mutableStateOf(MDCButtonIconType.None)
  var touch by mutableStateOf(false)
  var count by mutableStateOf(0)
}

@Composable
@Showcase(title = "MDCButton", id = "MDCButton")
fun MDCButtonShowcase() = InteractiveShowcase(
  viewModel = { MDCButtonShowcaseVM() },
  controls = {
    RadioChoice("Type", MDCButtonType.values().associateBy(MDCButtonType::name), type) { type = it }
    RadioChoice("Icon", MDCButtonIconType.values().associateBy(MDCButtonIconType::name), icon) { icon = it }
    BooleanChoice("Touch", touch) { touch = it }
  },
  details = {
    P { Text("ALT-CLICK to decrement, CLICK to increment") }
  }
) {
  MDCButton(type = type, icon = icon, touch = touch, attrs = {
    onClick { if (it.altKey) count-- else count++ }
  }) {
    val renderIcon = @Composable {
      Icon(attrs = { classes("material-icons") }) { Text("star") }
    }
    if (icon == MDCButtonIconType.Leading) renderIcon()
    Label("Clicked $count times")
    if (icon == MDCButtonIconType.Trailing) renderIcon()
  }
}
