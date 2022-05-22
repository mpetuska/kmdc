package showcases

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.button.Label
import dev.petuska.kmdc.button.MDCButton
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
import dev.petuska.kmdc.dialog.onOpened
import dev.petuska.kmdc.dialog.onOpening
import dev.petuska.kmdc.list.MDCList
import dev.petuska.kmdc.list.MDCListType
import dev.petuska.kmdc.list.item.Graphic
import dev.petuska.kmdc.list.item.Label
import dev.petuska.kmdc.list.item.ListItem
import dev.petuska.kmdc.radio.MDCRadio
import org.jetbrains.compose.web.dom.Text
import samples.Samples
import samples.SamplesRender

object MDCDialog : Samples() {
  override val content: SamplesRender = {
    AlertDialog()
    SimpleDialog()
    ConfirmationDialog()
    FullScreenDialog()
  }

  private val AlertDialog = Sample(name = "Alert Dialog") {
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
          Label("Cancel")
        }
        MDCDialogActionButton("discard") {
          Label("Discard")
        }
      }
    }
  }

  private val SimpleDialog = Sample(name = "Simple Dialog") {
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
          type = MDCListType.Avatar
        ) {
          listOf("None", "Callisto", "Ganymede", "Luna", "Oberon", "Phobos").forEachIndexed { index, item ->
            ListItem(
              attrs = {
                mdcDialogAction(item.lowercase())
                if (index == 0) {
                  tabIndex(0)
                  mdcDialogInitialFocus()
                }
              }
            ) {
              Text(item)
            }
          }
        }
      }
    }
  }

  private val ConfirmationDialog = Sample(name = "Confirmation Dialog") {
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
            ListItem(
              attrs = {
                if (index == 0) {
                  tabIndex(0)
                  mdcDialogInitialFocus()
                }
              }
            ) {
              Graphic {
                MDCRadio(checked = choice == item) {
                  id(item.lowercase())
                  attr("name", "test-dialog-baseline-confirmation-radio-group")
                  onChange {
                    choice = item
                  }
                }
              }
              Label(
                text = item,
                forId = item.lowercase(),
              )
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

  private val FullScreenDialog = Sample(name = "Full-screen Dialog") {
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
          Label("OK")
        }
      }
    }
  }

  private fun MDCDialogAttrsScope.subscribeToEvents() {
    onOpening { console.log("Opening") }
    onOpened { console.log("Opened") }
    onClosing { console.log("Closing by ${it.detail.action}") }
  }
}
