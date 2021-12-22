package local.sandbox.samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.menu.MDCMenu
import dev.petuska.kmdc.menu.MDCMenuListItem
import dev.petuska.kmdc.menu.MDCMenuModule
import dev.petuska.kmdc.menu.MDCMenuSurface
import dev.petuska.kmdc.menu.MDCMenuSurfaceOpts
import dev.petuska.kmdc.textfield.MDCTextField
import dev.petuska.kmdc.textfield.MDCTextFieldCommonOpts
import local.sandbox.engine.Sample
import local.sandbox.engine.Samples

private val SAMPLE_MENU = listOf("Menu Item 1", "Menu Item 2", "Menu Item 3")

@Suppress("unused")
private val MenuSamples = Samples("MDCMenu") {
  Sample("Anchored") {
    var menuElement by remember { mutableStateOf<MDCMenuModule.MDCMenu?>(null) }
    var selectedValue by remember { mutableStateOf("") }

    MDCMenuSurface({
      style = MDCMenuSurfaceOpts.Style.Anchored
    }) {
      MDCTextField(selectedValue, {
        label = "Dropdown"
        type = MDCTextFieldCommonOpts.Type.Outlined
      }) {
        onClick { menuElement?.let { it.open = true } }
      }
      MDCMenu(opts = {
        onSelected = { selectedValue = SAMPLE_MENU[it] }
      }, initialize = { _, mdcMenu: MDCMenuModule.MDCMenu ->
        menuElement = mdcMenu
      }) {
        SAMPLE_MENU.map {
          MDCMenuListItem({text = it})
        }
      }
    }
  }
}
