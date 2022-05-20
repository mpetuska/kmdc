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
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanControl
import sandbox.control.ChoiceControl
import sandbox.control.TextControl

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
