package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.snackbar.MDCSnackbar
import dev.petuska.kmdc.snackbar.MDCSnackbarAction
import dev.petuska.kmdc.snackbar.MDCSnackbarActions
import dev.petuska.kmdc.snackbar.MDCSnackbarAttrsScope
import dev.petuska.kmdc.snackbar.MDCSnackbarDismiss
import dev.petuska.kmdc.snackbar.MDCSnackbarLabel
import dev.petuska.kmdc.snackbar.MDCSnackbarType
import dev.petuska.kmdc.snackbar.onClosed
import dev.petuska.kmdc.snackbar.onClosing
import dev.petuska.kmdc.snackbar.onOpened
import dev.petuska.kmdc.snackbar.onOpening
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
    dismissible = dismissible,
    closeOnEscape = closeOnEscape,
    timeoutMs = timeoutMs.takeIf { it >= 4000 },
    open = open,
    type = type,
    attrs = {
      registerEvents()
      onClosed { open = false }
    }
  ) {
    MDCSnackbarLabel("Can't send photo.${if (timeoutMs >= 4000) " Closing in ${timeoutMs / 1000} seconds." else ""}")
    MDCSnackbarActions {
      MDCSnackbarAction("Retry", attrs = {
        onClick { console.log("MDCSnackbar#Retried") }
      })
      MDCSnackbarDismiss(attrs = {
        classes("material-icons")
        title("Dismiss")
      }) { Text("close") }
    }
  }
}

private fun MDCSnackbarAttrsScope.registerEvents() {
  onOpening { console.log("MDCSnackbar#onOpening", it.detail) }
  onOpened { console.log("MDCSnackbar#onOpened", it.detail) }
  onClosing { console.log("MDCSnackbar#onClosing", it.detail) }
  onClosed { console.log("MDCSnackbar#onClosed", it.detail) }
}