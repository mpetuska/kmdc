package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.drawer.*
import dev.petuska.kmdc.list.MDCNavList
import dev.petuska.kmdc.list.item.Graphic
import dev.petuska.kmdc.list.item.ListItem
import dev.petuska.kmdc.list.item.Text
import dev.petuska.kmdc.typography.MDCBody1
import dev.petuska.kmdcx.icons.mdcIcon
import sandbox.control.BooleanControl
import sandbox.control.ChoiceControl
import org.jetbrains.compose.web.dom.Text as ComposeText

private class MDCDrawerVM {
  var type by mutableStateOf(MDCDrawerType.Dismissible)
  var open by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCDrawer")
fun MDCDrawer() = InteractiveShowcase(
  viewModel = { MDCDrawerVM() },
  controls = {
    ChoiceControl("Type", MDCDrawerType.values().associateBy(MDCDrawerType::name), ::type)
    BooleanControl("Open", ::open)
  },
) {
  MDCDrawer(
    open = open,
    type = type,
    attrs = {
      registerEvents()
      onOpened { open = true }
      onClosed { open = false }
      style {
        property("height", "fit-content")
      }
    }
  ) {
    Header {
      Title("Title")
      Subtitle("Subtitle")
    }
    Content {
      MDCNavList(
        wrapFocus = true,
      ) {
        ListItem(selected = true) {
          Graphic(attrs = { mdcIcon() }) { ComposeText(dev.petuska.kmdcx.icons.MDCIcon.Inbox.type) }
          Text("Inbox")
        }
        ListItem {
          Graphic(attrs = { mdcIcon() }) { ComposeText(dev.petuska.kmdcx.icons.MDCIcon.Send.type) }
          Text("Outgoing")
        }
        ListItem {
          Graphic(attrs = { mdcIcon() }) { ComposeText(dev.petuska.kmdcx.icons.MDCIcon.Drafts.type) }
          Text("Drafts")
        }
      }
    }
  }
  MDCDrawerAppContent {
    MDCBody1("App Content")
  }
}

private fun MDCDrawerAttrsScope.registerEvents() {
  onOpened { console.log("MDCDrawer#onOpened", it.detail) }
  onClosed { console.log("MDCDrawer#onClosed", it.detail) }
}
