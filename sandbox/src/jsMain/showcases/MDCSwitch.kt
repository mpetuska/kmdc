package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.kmdc.switch.*
import org.jetbrains.compose.web.attributes.*
import sandbox.control.*


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
