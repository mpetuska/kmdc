package showcases

import androidx.compose.runtime.*
import dev.petuska.kmdc.button.*
import dev.petuska.kmdc.dialog.*
import dev.petuska.kmdc.list.*
import dev.petuska.kmdc.list.item.Graphic
import dev.petuska.kmdc.list.item.Label
import dev.petuska.kmdc.list.item.ListItem
import dev.petuska.kmdc.radio.*
import org.jetbrains.compose.web.dom.Text
import samples.*

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
