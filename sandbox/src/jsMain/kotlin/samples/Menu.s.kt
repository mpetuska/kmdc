package local.sandbox.samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.menu.MDCMenu
import dev.petuska.kmdc.menu.MDCMenuItem
import dev.petuska.kmdc.menu.MDCMenuOpts
import dev.petuska.kmdc.menu.surface.Corner
import dev.petuska.kmdc.menu.surface.MDCMenuSurfaceAnchor
import dev.petuska.kmdc.textfield.MDCTextField
import dev.petuska.kmdc.textfield.MDCTextFieldCommonOpts
import local.sandbox.engine.Sample
import local.sandbox.engine.Samples
import onSelected
import org.jetbrains.compose.web.dom.Text

private val SAMPLE_MENU = listOf("Menu Item 1", "Menu Item 2", "Menu Item 3")

val MenuSamples = Samples("MDCMenu") {
  Sample("Absolutely Positioned Menu") {
    var menuOpen by remember { mutableStateOf(false) }

    MDCButton(
      text = "${if (menuOpen) "Close" else "Open"} Fixed Menu",
      attrs = { onClick { menuOpen = !menuOpen } }
    )
    MDCMenu(opts = {
      open = menuOpen
      absolutePosition = MDCMenuOpts.Point(100.0, 200.0)
    }, attrs = {
      onSelected { menuOpen = false }
    }) {
      SAMPLE_MENU.map {
        MDCMenuItem { Text(it) }
      }
    }
  }
  Sample("Anchored Dropdown") {
    var selectedValue by remember { mutableStateOf("") }
    var menuOpen by mutableStateOf(false)

    MDCMenuSurfaceAnchor {
      MDCTextField(selectedValue, {
        label = "Menu Selection"
        type = MDCTextFieldCommonOpts.Type.Outlined
      }) {
        onClick {
          console.log("Menu clicked")
          menuOpen = true
        }
      }
      MDCMenu(opts = {
          open = menuOpen
        }, attrs = {
          onSelected {
            selectedValue = SAMPLE_MENU[it.detail.index]
            menuOpen = false
          }
        }
      ) {
        SAMPLE_MENU.map {
          MDCMenuItem { Text(it) }
        }
      }
    }
  }
}
