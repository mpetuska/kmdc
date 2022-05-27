package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.snackbar.*
import dev.petuska.kmdcx.icons.MDCIcon
import dev.petuska.kmdcx.icons.mdcIcon
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanControl
import sandbox.control.ChoiceControl
import sandbox.control.RangeControl

private class MDCSnackbarVM {
  var type by mutableStateOf(MDCSnackbarType.Default)
  var dismissible by mutableStateOf(false)
  var closeOnEscape by mutableStateOf(true)
  var timeoutMs by mutableStateOf(5000)
  var open by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCSnackbar")
fun MDCSnackbar() = InteractiveShowcase(
  viewModel = { MDCSnackbarVM() },
  controls = {
    ChoiceControl("Type", MDCSnackbarType.values().associateBy(MDCSnackbarType::name), ::type)
    BooleanControl("Dismissible", ::dismissible)
    BooleanControl("Close on Escape", ::closeOnEscape)
    RangeControl("Timeout MS", ::timeoutMs, min = 3999, max = 10000, converter = Number::toInt)
    BooleanControl("Open", ::open)
  },
) {
  MDCSnackbar(
    closeOnEscape = closeOnEscape,
    timeoutMs = timeoutMs.takeIf { it >= 4000 },
    open = open,
    type = type,
    attrs = {
      registerEvents()
      onClosed { open = false }
    }
  ) {
    Label("Can't send photo.${if (timeoutMs >= 4000) " Closing in ${timeoutMs / 1000} seconds." else ""}")
    Actions {
      Action("Retry", attrs = {
        onClick { console.log("MDCSnackbar#Retried") }
      })
      if (dismissible) {
        Dismiss(attrs = {
          mdcIcon()
          title("Dismiss")
        }) { Text(MDCIcon.Close.type) }
      }
    }
  }
}

private fun MDCSnackbarAttrsScope.registerEvents() {
  onOpening { console.log("MDCSnackbar#onOpening", it.detail) }
  onOpened { console.log("MDCSnackbar#onOpened", it.detail) }
  onClosing { console.log("MDCSnackbar#onClosing", it.detail) }
  onClosed { console.log("MDCSnackbar#onClosed", it.detail) }
}
