package local.sandbox.samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonLabel
import dev.petuska.kmdc.dialog.MDCDialog
import dev.petuska.kmdc.dialog.MDCDialogActionButton
import dev.petuska.kmdc.dialog.MDCDialogActions
import dev.petuska.kmdc.dialog.MDCDialogAttrsScope
import dev.petuska.kmdc.dialog.MDCDialogCloseIconButton
import dev.petuska.kmdc.dialog.MDCDialogContent
import dev.petuska.kmdc.dialog.MDCDialogHeader
import dev.petuska.kmdc.dialog.MDCDialogTitle
import dev.petuska.kmdc.dialog.mdcDialogAction
import dev.petuska.kmdc.dialog.mdcDialogButtonDefault
import dev.petuska.kmdc.dialog.mdcDialogInitialFocus
import dev.petuska.kmdc.dialog.onClosed
import dev.petuska.kmdc.dialog.onClosing
import dev.petuska.kmdc.dialog.onOpening
import dev.petuska.kmdc.list.MDCList
import dev.petuska.kmdc.list.MDCListItem
import dev.petuska.kmdc.list.MDCListItemGraphic
import dev.petuska.kmdc.list.MDCListItemLabel
import dev.petuska.kmdc.list.MDCListItemText
import dev.petuska.kmdc.list.MDCListOpts
import dev.petuska.kmdc.radio.MDCRadio
import local.sandbox.engine.Sample
import local.sandbox.engine.Samples
import org.jetbrains.compose.web.attributes.forId
import org.jetbrains.compose.web.dom.Text

@Suppress("unused")
private val DialogSamples = Samples("MDCDialog") {
  AlertDialog()
  SimpleDialog()
  ConfirmationDialog()
  FullScreenDialog()
}

private val AlertDialog by Sample(name = "Alert Dialog") {
  var open by remember { mutableStateOf(false) }

  MDCButton("Toggle Dialog", attrs = { onClick { open = !open } })
  MDCDialog(
    opts = {
      this.open = open
    },
    attrs = {
      subscribeToEvents()
      onClosed {
        console.log("Closed by ${it.detail.action}")
        open = false
      }
    }
  ) {
    MDCDialogContent {
      Text("Discard draft?")
    }
    MDCDialogActions {
      MDCDialogActionButton("cancel") {
        MDCButtonLabel("Cancel")
      }
      MDCDialogActionButton("discard") {
        MDCButtonLabel("Discard")
      }
    }
  }
}

private val SimpleDialog by Sample(name = "Simple Dialog") {
  var open by remember { mutableStateOf(false) }

  MDCButton("Toggle Dialog", attrs = { onClick { open = !open } })
  MDCDialog(
    opts = {
      this.open = open
    },
    attrs = {
      subscribeToEvents()
      onClosed {
        console.log("Closed by ${it.detail.action}")
        open = false
      }
    }
  ) {
    MDCDialogTitle("Choose a Ringtone")
    MDCDialogContent {
      MDCList(
        opts = {
          type = MDCListOpts.Type.Avatar
        }
      ) {
        listOf("None", "Callisto", "Ganymede", "Luna", "Oberon", "Phobos").forEachIndexed { index, item ->
          MDCListItem(
            attrs = {
              mdcDialogAction(item.lowercase())
              if (index == 0) {
                tabIndex(0)
                mdcDialogInitialFocus()
              }
            }
          ) {
            MDCListItemText(item)
          }
        }
      }
    }
  }
}

private val ConfirmationDialog by Sample(name = "Confirmation Dialog") {
  var open by remember { mutableStateOf(false) }
  var choice by remember { mutableStateOf<String?>(null) }

  MDCButton("Toggle Dialog", attrs = { onClick { open = !open } })
  MDCDialog(
    opts = {
      this.open = open
    },
    attrs = {
      subscribeToEvents()
      onClosed {
        console.log("Closed by ${it.detail.action}, choice = $choice")
        open = false
      }
    }
  ) {
    MDCDialogContent {
      MDCList {
        listOf("None", "Callisto", "Ganymede", "Luna", "Oberon", "Phobos").forEachIndexed { index, item ->
          MDCListItem(
            attrs = {
              if (index == 0) {
                tabIndex(0)
                mdcDialogInitialFocus()
              }
            }
          ) {
            MDCListItemGraphic {
              MDCRadio(checked = choice == item) {
                id(item.lowercase())
                attr("name", "test-dialog-baseline-confirmation-radio-group")
                onChange {
                  choice = item
                }
              }
            }
            MDCListItemLabel(
              attrs = {
                forId(item.lowercase())
              }
            ) {
              Text(item)
            }
          }
        }
      }
    }
    MDCDialogActions {
      MDCDialogActionButton("close") {
        Text("Cancel")
      }
      MDCDialogActionButton("accept") {
        Text("OK")
      }
    }
  }
}

private val FullScreenDialog by Sample(name = "Full-screen Dialog") {
  var open by remember { mutableStateOf(false) }

  MDCButton("Toggle Dialog", attrs = { onClick { open = !open } })
  MDCDialog(
    opts = {
      this.open = open
      this.fullscreen = true
    },
    attrs = {
      subscribeToEvents()
      onClosed {
        console.log("Closed by ${it.detail.action}")
        open = false
      }
    }
  ) {
    MDCDialogHeader {
      MDCDialogTitle {
        Text("Full-Screen Dialog Title")
      }
      MDCDialogCloseIconButton()
    }
    MDCDialogContent {
      Text(
        " Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
            "        Sed scelerisque metus dapibus, maximus massa pulvinar, commodo nunc.\n" +
            "        Quisque vitae luctus lectus, ut tempus ipsum. Sed suscipit gravida scelerisque.\n" +
            "        Aenean vulputate elementum est, quis consectetur orci consectetur ac.\n" +
            "        Quisque accumsan vel nisi id dapibus. Suspendisse nec urna eu massa ornare rutrum.\n" +
            "        Vivamus at nisi sit amet nulla pretium volutpat sit amet in justo. Donec mi metus,\n" +
            "        interdum ac tincidunt at, vehicula vitae nisl. Morbi fermentum dapibus massa,\n" +
            "        nec lobortis massa vestibulum eu."
      )
    }
    MDCDialogActions {
      MDCDialogActionButton(
        "ok",
        attrs = {
          mdcDialogButtonDefault()
          mdcDialogInitialFocus()
          onClick { open = false }
        }
      ) {
        MDCButtonLabel("OK")
      }
    }
  }
}

private fun MDCDialogAttrsScope.subscribeToEvents() {
  onOpening { console.log("Opening") }
  onOpening { console.log("Opened") }
  onClosing { console.log("Closing by ${it.detail.action}") }
}