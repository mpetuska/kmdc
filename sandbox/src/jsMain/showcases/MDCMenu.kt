package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.menu.MDCMenu
import dev.petuska.kmdc.menu.MDCMenuItem
import dev.petuska.kmdc.menu.MDCMenuOpts
import dev.petuska.kmdc.menu.surface.onClosed
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanControl
import sandbox.control.NamedBlock

private class MDCMenuVM {
  var disabled by mutableStateOf(false)
  var multiselectable by mutableStateOf(false)
  var overflow by mutableStateOf(false)
  var open by mutableStateOf(false)

  var selectedValue by mutableStateOf("")
  val menuItems = listOf("Menu Item 1", "Menu Item 2", "Menu Item 3")
}

@Composable
@Showcase(id = "MDCMenu")
fun MDCMenu() = InteractiveShowcase(
  viewModel = { MDCMenuVM() },
  controls = {
    BooleanControl("Disabled", ::disabled)
    BooleanControl("Multiselectable", ::multiselectable)
    BooleanControl("Overflow", ::overflow)
    BooleanControl("Open", ::open)
  },
) {
  NamedBlock("Absolute") {
    MDCButton(text = "${if (open) "Close" else "Open"} Fixed Menu", attrs = { onClick { open = !open } })
    MDCMenu(opts = {
      open = this@InteractiveShowcase.open
      absolutePosition = MDCMenuOpts.Point(100.0, 200.0)
    }, attrs = {
      onClosed { open = false }
    }) {
      menuItems.map {
        MDCMenuItem { Text(it) }
      }
    }
  }
//  NamedBlock("Anchored") {
//    MDCMenuSurfaceAnchor {
//      MDCTextField(value = selectedValue,
//        label = "Menu Selection",
//        type = MDCTextFieldType.Outlined,
//        attrs = {
//          onClick {
//            open = true
//          }
//        })
//      MDCMenu(opts = {
//        open = this@InteractiveShowcase.open
//        anchorCorner = MDCMenuSurfaceModule.Corner.TOP_START
//      }, attrs = {
//        onSelected {
//          selectedValue = menuItems[it.detail.index]
//          open = false
//        }
//        onClosed { open = false }
//      }) {
//        menuItems.map {
//          MDCMenuItem { Text(it) }
//        }
//      }
//    }
//  }
}
