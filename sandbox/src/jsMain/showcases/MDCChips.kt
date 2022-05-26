package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.chips.MDCChipsAttrsScope
import dev.petuska.kmdc.chips.action.Checkmark
import dev.petuska.kmdc.chips.action.Graphic
import dev.petuska.kmdc.chips.action.Icon
import dev.petuska.kmdc.chips.action.Label
import dev.petuska.kmdc.chips.grid.*
import dev.petuska.kmdc.chips.listbox.FilterChip
import dev.petuska.kmdc.chips.listbox.MDCChipsListbox
import dev.petuska.kmdc.chips.onInteraction
import dev.petuska.kmdc.chips.onRemoval
import dev.petuska.kmdc.chips.onSelection
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanControl
import sandbox.util.NamedBlock

private class MDCChipsVM {
  var disabled by mutableStateOf(false)
  var multiselectable by mutableStateOf(false)
  var overflow by mutableStateOf(false)
  var touch by mutableStateOf(false)

  var removed1 by mutableStateOf(false)
  var removed2 by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCChips")
fun MDCChips() = InteractiveShowcase(
  viewModel = { MDCChipsVM() },
  controls = {
    BooleanControl("Disabled", ::disabled)
    BooleanControl("Multiselectable", ::multiselectable)
    BooleanControl("Overflow", ::overflow)
    BooleanControl("Touch", ::touch)
  },
) {
  NamedBlock("Grid") {
    MDCChipsGrid(overflow = overflow, attrs = {
      registerEvents()
      onRemoval {
        if (it.detail.chipID == "1") removed1 = true
        if (it.detail.chipID == "2") removed2 = true
      }
    }) {
      ActionChip(
        "0", disabled = disabled, withPrimaryIcon = true, touch = touch,
      ) {
        Graphic {
          Icon(attrs = { classes("material-icons") }) { Text("favorite") }
          Checkmark()
        }
        Label("ActionChip")
      }
      if (!removed1) {
        InputChip(
          "1", withPrimaryIcon = true, withTrailingAction = true, disabled = disabled, touch = touch,
        ) {
          PrimaryAction {
            Graphic {
              Icon(attrs = { classes("material-icons") }) { Text("favorite") }
              Checkmark()
            }
            Label("InputChip with leading icon and trailing action")
          }
          TrailingAction {
            Icon(attrs = { classes("material-icons") }) { Text("close") }
          }
        }
      }
      if (!removed2) {
        InputChip(
          "2", disabled = disabled, withTrailingAction = true, navigableTrailingAction = false, touch = touch,
        ) {
          PrimaryAction {
            Label("InputChip with non-navigable trailing action")
          }
          TrailingAction {
            Icon(attrs = { classes("material-icons") }) { Text("close") }
          }
        }
      }
      InputChip("3", disabled = disabled, touch = touch) {
        PrimaryAction {
          Label("InputChip without trailing action")
        }
      }
    }
  }
  NamedBlock("Listbox") {
    val selected = remember { mutableStateListOf("1") }
    MDCChipsListbox(overflow = overflow, multiselectable = multiselectable, attrs = {
      registerEvents()
      onSelection {
        if (it.detail.isSelected) {
          selected.add(it.detail.chipID)
        } else {
          selected.remove(it.detail.chipID)
        }
      }
    }) {
      repeat(5) { id ->
        FilterChip(
          "$id",
          selected = "$id" in selected,
          disabled = disabled,
          withPrimaryGraphic = true,
          withPrimaryIcon = true,
          touch = touch,
        ) {
          Graphic {
            Icon(attrs = { classes("material-icons") }) { Text("favorite") }
            Checkmark()
          }
          Label("FilterChip - $id")
        }
      }
    }
  }
}

private fun MDCChipsAttrsScope.registerEvents() {
  onInteraction { console.log("MDCChips#onInteraction", it.detail) }
  onSelection { console.log("MDCChips#onSelection", it.detail) }
  onRemoval { console.log("MDCChips#onRemoval", it.detail) }
}
