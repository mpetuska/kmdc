package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdc.switch.MDCSwitch
import org.jetbrains.compose.web.attributes.disabled
import sandbox.control.BooleanControl
import sandbox.control.TextControl

private class MDCSwitchVM {
  var disabled by mutableStateOf(false)
  var selected by mutableStateOf(false)
  var label by mutableStateOf("on/off")
}

@Composable
@Showcase(id = "MDCSwitch")
fun MDCSwitch() = InteractiveShowcase(
  viewModel = { MDCSwitchVM() },
  controls = {
    BooleanControl("Disabled", ::disabled)
    BooleanControl("Selected", ::selected)
    TextControl("Label", ::label)
  },
) {
  MDCFormField {
    MDCSwitch(
      selected = selected,
      label = label.takeIf(String::isNotBlank),
      attrs = {
        if (disabled) disabled()
        onClick { selected = !selected }
      }
    )
  }
}
