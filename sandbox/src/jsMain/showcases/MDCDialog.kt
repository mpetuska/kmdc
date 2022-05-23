package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.katalog.runtime.util.*
import dev.petuska.kmdc.dialog.*
import dev.petuska.kmdc.list.*
import dev.petuska.kmdc.list.item.*
import dev.petuska.kmdcx.icons.*
import org.jetbrains.compose.web.dom.*
import sandbox.control.*
import sandbox.util.*

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
        if (fullscreen) CloseButton(MDCIconOpts.MDCIconType.Close.iconType, attrs = { classes("material-icons") })
      }
      Content {
        Text(loremIpsum)
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
        onClosed { interactiveOpen = false }
      }
    ) {
      Title("Choose a Ringtone")
      Content {
        MDCList(
          type = MDCListType.Avatar
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
              Text(item)
            }
          }
        }
      }
    }
  }
}

private fun MDCDialogAttrsScope.registerEvents() {
  onOpening { console.log("MDCDialog#onOpening", it.detail) }
  onOpened { console.log("MDCDialog#onOpened", it.detail) }
  onClosing { console.log("MDCDialog#onClosing", it.detail) }
  onClosed { console.log("MDCDialog#onClosing", it.detail) }
}
