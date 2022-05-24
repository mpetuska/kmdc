package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.kmdc.button.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import sandbox.control.*

private class MDCButtonVM {
  var type by mutableStateOf(MDCButtonType.Text)
  var icon by mutableStateOf(MDCButtonIconType.None)
  var touch by mutableStateOf(false)
  var disabled by mutableStateOf(false)
  var label by mutableStateOf("My Label")
}

@Composable
@Showcase(id = "MDCButton")
fun MDCButton() = InteractiveShowcase(
  viewModel = { MDCButtonVM() },
  controls = {
    ChoiceControl("Type", MDCButtonType.values().associateBy(MDCButtonType::name), ::type)
    ChoiceControl("Icon", MDCButtonIconType.values().associateBy(MDCButtonIconType::name), ::icon)
    BooleanControl("Disabled", ::disabled)
    BooleanControl("Touch", ::touch)
    TextControl("Label", label) { label = it }
  },
) {
  MDCButton(type = type, icon = icon, touch = touch, attrs = {
    if (disabled) disabled()
  }) {
    val renderIcon = @Composable {
      Icon(attrs = { classes("material-icons") }) { Text("star") }
    }
    if (icon == MDCButtonIconType.Leading) renderIcon()
    Label(label)
    if (icon == MDCButtonIconType.Trailing) renderIcon()
  }
}
