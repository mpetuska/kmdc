package samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.menu.MDCMenu
import dev.petuska.kmdc.menu.MDCMenuItem
import dev.petuska.kmdc.menu.MDCMenuOpts
import dev.petuska.kmdc.menu.onSelected
import dev.petuska.kmdc.menu.surface.MDCMenuSurfaceAnchor
import dev.petuska.kmdc.menu.surface.MDCMenuSurfaceModule
import dev.petuska.kmdc.menu.surface.onClosed
import dev.petuska.kmdc.textfield.MDCTextField
import dev.petuska.kmdc.textfield.MDCTextFieldCommonOpts
import org.jetbrains.compose.web.dom.Text

object MDCMenu : Samples() {
  override val content: SamplesRender = {
    Absolute()
    Anchored()
  }

  private val SAMPLE_MENU = listOf("Menu Item 1", "Menu Item 2", "Menu Item 3")

  private val Absolute = Sample("Absolutely Positioned Menu") {
    var menuOpen by remember { mutableStateOf(false) }

    MDCButton(text = "${if (menuOpen) "Close" else "Open"} Fixed Menu", attrs = { onClick { menuOpen = !menuOpen } })
    MDCMenu(opts = {
      open = menuOpen
      absolutePosition = MDCMenuOpts.Point(100.0, 200.0)
    }, attrs = {
      onClosed { menuOpen = false }
    }) {
      SAMPLE_MENU.map {
        MDCMenuItem { Text(it) }
      }
    }
  }
  private val Anchored = Sample("Anchored Dropdown") {
    var selectedValue by remember { mutableStateOf("") }
    var menuOpen by remember { mutableStateOf(false) }

    MDCMenuSurfaceAnchor {
      MDCTextField(value = selectedValue, opts = {
        label = "Menu Selection"
        type = MDCTextFieldCommonOpts.Type.Outlined
      }, attrs = {
        onClick {
          console.log("Menu clicked")
          menuOpen = true
        }
      })
      MDCMenu(opts = {
        open = menuOpen
        anchorCorner = MDCMenuSurfaceModule.Corner.TOP_START
      }, attrs = {
        onSelected {
          selectedValue = SAMPLE_MENU[it.detail.index]
          menuOpen = false
        }
        onClosed { menuOpen = false }
      }) {
        SAMPLE_MENU.map {
          MDCMenuItem { Text(it) }
        }
      }
    }
  }
}
