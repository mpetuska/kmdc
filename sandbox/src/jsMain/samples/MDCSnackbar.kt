package samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.snackbar.MDCSnackbar
import dev.petuska.kmdc.snackbar.MDCSnackbarAction
import dev.petuska.kmdc.snackbar.MDCSnackbarActions
import dev.petuska.kmdc.snackbar.MDCSnackbarAttrsScope
import dev.petuska.kmdc.snackbar.MDCSnackbarDismiss
import dev.petuska.kmdc.snackbar.MDCSnackbarLabel
import dev.petuska.kmdc.snackbar.MDCSnackbarOpts
import dev.petuska.kmdc.snackbar.onClosed
import dev.petuska.kmdc.snackbar.onClosing
import dev.petuska.kmdc.snackbar.onOpened
import dev.petuska.kmdc.snackbar.onOpening
import org.jetbrains.compose.web.dom.Text

object MDCSnackbar : Samples() {
  override val content: SamplesRender = {
    MDCSnackbarOpts.Type.values().forEach { type ->
      Sample("$type") { name ->
        var open by remember { mutableStateOf(false) }
        MDCButton("Toggle Snackbar", attrs = { onClick { open = !open } })
        MDCSnackbar(
          opts = {
            this.open = open
            this.type = type
          },
          attrs = {
            registerEvents(name)
            onClosed { open = false }
          }
        ) {
          MDCSnackbarLabel("Can't send photo. Retry in 5 seconds.")
          MDCSnackbarActions {
            MDCSnackbarAction("Retry", attrs = {
              onClick { console.log("$name#Retried") }
            })
            MDCSnackbarDismiss(attrs = {
              classes("material-icons")
              title("Dismiss")
            }) { Text("close") }
          }
        }
      }
    }
  }

  private fun MDCSnackbarAttrsScope.registerEvents(name: String) {
    onOpening { console.log("$name#onSnackbarOpening", it.detail) }
    onOpened { console.log("$name#onSnackbarOpened", it.detail) }
    onClosing { console.log("$name#onSnackbarClosing", it.detail) }
    onClosed { console.log("$name#onSnackbarClosed", it.detail) }
  }
}
