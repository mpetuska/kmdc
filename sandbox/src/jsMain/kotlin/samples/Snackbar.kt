package local.sandbox.samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.snackbar.MDCSnackbar
import dev.petuska.kmdc.snackbar.MDCSnackbarAction
import dev.petuska.kmdc.snackbar.MDCSnackbarActions
import dev.petuska.kmdc.snackbar.MDCSnackbarDismiss
import dev.petuska.kmdc.snackbar.MDCSnackbarLabel
import dev.petuska.kmdc.snackbar.MDCSnackbarOpts
import dev.petuska.kmdc.snackbar.onSnackbarClosed
import dev.petuska.kmdc.snackbar.onSnackbarClosing
import dev.petuska.kmdc.snackbar.onSnackbarOpened
import dev.petuska.kmdc.snackbar.onSnackbarOpening
import local.sandbox.engine.Sample
import local.sandbox.engine.Samples
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLElement

@Suppress("unused")
@EagerInitialization
private val SnackbarSamples = Samples("MDCSnackbar") {
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
          onSnackbarClosed { open = false }
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

private fun AttrsScope<HTMLElement>.registerEvents(name: String) {
  onSnackbarOpening { console.log("$name#onSnackbarOpening", it.detail) }
  onSnackbarOpened { console.log("$name#onSnackbarOpened", it.detail) }
  onSnackbarClosing { console.log("$name#onSnackbarClosing", it.detail) }
  onSnackbarClosed { console.log("$name#onSnackbarClosed", it.detail) }
}
