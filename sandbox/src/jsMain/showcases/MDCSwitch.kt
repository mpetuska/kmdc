package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.switch.MDCSwitch
import org.jetbrains.compose.web.attributes.disabled
import sandbox.control.BooleanControl


private class MDCSwitchVM {
  var disabled by mutableStateOf(false)
  var selected by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCSwitch")
fun MDCSwitch() = InteractiveShowcase(
  viewModel = { MDCSwitchVM() },
  controls = {
    BooleanControl("Disabled", ::disabled)
    BooleanControl("Selected", ::selected)
  },
) {
  MDCSwitch(
    selected = selected,
    attrs = {
      if (disabled) disabled()
      onClick {
        selected = !selected
      }
    }
  )
}
