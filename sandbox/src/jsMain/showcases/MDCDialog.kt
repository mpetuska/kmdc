package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.katalog.runtime.util.LoremIpsum
import dev.petuska.kmdc.dialog.*
import dev.petuska.kmdc.list.MDCList
import dev.petuska.kmdc.list.MDCListSelection
import dev.petuska.kmdc.list.MDCListType
import dev.petuska.kmdc.list.item.Label
import dev.petuska.kmdc.list.item.ListItem
import dev.petuska.kmdc.list.item.RadioGraphic
import dev.petuska.kmdcx.icons.MDCIcon
import dev.petuska.kmdcx.icons.mdcIcon
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanControl
import sandbox.control.TextControl
import sandbox.util.NamedBlock
import sandbox.util.NamedGroup

private class MDCDialogVM {
  var fullscreen by mutableStateOf(false)
  var stacked by mutableStateOf(false)
  var scrimClickAction by mutableStateOf("close")
  var escapeKeyAction by mutableStateOf("close")

  var simpleOpen by mutableStateOf(false)

  var interactiveOpen by mutableStateOf(false)
  val ringtones = listOf("None", "Callisto", "Ganymede", "Luna", "Oberon", "Phobos")
  var selected by mutableStateOf<String?>(null)
}

@Composable
@Showcase(id = "MDCDialog")
fun MDCDialog() = InteractiveShowcase(
  viewModel = { MDCDialogVM() },
  controls = {
    BooleanControl("Fullscreen", ::fullscreen)
    BooleanControl("Stacked", ::stacked)
    TextControl("Scrim Click Action", ::scrimClickAction)
    TextControl("Escape Click Action", ::escapeKeyAction)
    NamedGroup("Simple") {
      BooleanControl("Open", ::simpleOpen)
    }
    NamedGroup("Interactive") {
      BooleanControl("Open", ::interactiveOpen)
    }
  },
) {
  NamedBlock("Simple") {
    MDCDialog(
      open = simpleOpen,
      fullscreen = fullscreen,
      stacked = stacked,
      scrimClickAction = scrimClickAction.takeIf(String::isNotBlank) ?: "close",
      escapeKeyAction = escapeKeyAction.takeIf(String::isNotBlank) ?: "close",
      attrs = {
        registerEvents()
        onOpening { interactiveOpen = false }
        onClosed { simpleOpen = false }
      }
    ) {
      Header {
        Title("Dialog Title")
        if (fullscreen) CloseButton(MDCIcon.Close.type, attrs = { mdcIcon() })
      }
      Content {
        Text(LoremIpsum)
      }
      Actions {
        Action(action = "accept", text = "Accept")
        Action(action = "ok", text = "OK")
        Action(action = "custom", text = "Custom", default = true)
        Action(action = "close", text = "Close")
      }
    }
  }
  NamedBlock("Interactive") {
    MDCDialog(
      open = interactiveOpen,
      fullscreen = fullscreen,
      stacked = stacked,
      scrimClickAction = scrimClickAction.takeIf(String::isNotBlank) ?: "close",
      escapeKeyAction = escapeKeyAction.takeIf(String::isNotBlank) ?: "close",
      attrs = {
        registerEvents()
        onOpening { simpleOpen = false }
        onClosed {
          interactiveOpen = false
          selected = it.detail.action?.takeIf { a -> a in ringtones } ?: selected
        }
      }
    ) {
      Title("Choose a Ringtone")
      Content {
        MDCList(
          type = MDCListType.Avatar,
          selection = MDCListSelection.SingleRadio,
        ) {
          ringtones.forEachIndexed { index, item ->
            ListItem(
              attrs = {
                mdcDialogAction(item)
                if (selected == item || selected == null && index == 0) {
                  mdcDialogInitialFocus()
                }
              }
            ) {
              val id = "mdc-dialog-item-$index"
              RadioGraphic(checked = selected == item, id = id)
              Label(text = item, forId = id)
            }
          }
        }
      }
      Actions {
        Action(action = "close", text = "Cancel")
        Action(action = "accept", text = "OK")
      }
    }
  }
}

private fun MDCDialogAttrsScope.registerEvents() {
  onOpening { console.log("MDCDialog#onOpening", it.detail) }
  onOpened { console.log("MDCDialog#onOpened", it.detail) }
  onClosing { console.log("MDCDialog#onClosing", it.detail) }
  onClosed { console.log("MDCDialog#onClosed", it.detail) }
}
