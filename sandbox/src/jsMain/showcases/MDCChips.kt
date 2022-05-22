package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.kmdc.chips.*
import dev.petuska.kmdc.chips.action.*
import dev.petuska.kmdc.chips.grid.*
import dev.petuska.kmdc.chips.listbox.*
import org.jetbrains.compose.web.dom.*
import sandbox.control.*
import sandbox.util.*

private class MDCChipsVM {
  var disabled by mutableStateOf(false)
  var multiselectable by mutableStateOf(false)
  var overflow by mutableStateOf(false)
  var touch by mutableStateOf(false)
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
    }) {
      ActionChip(
        "1", disabled = disabled, withPrimaryIcon = true, touch = touch,
      ) {
        Graphic {
          Icon(attrs = { classes("material-icons") }) { Text("favorite") }
          Checkmark()
        }
        Label("ActionChip")
      }
      InputChip(
        "2", withPrimaryIcon = true, withTrailingAction = true, disabled = disabled, touch = touch,
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
      InputChip(
        "3", disabled = disabled, withTrailingAction = true, navigableTrailingAction = false, touch = touch,
      ) {
        PrimaryAction {
          Label("InputChip with non-navigable trailing action")
        }
        TrailingAction {
          Icon(attrs = { classes("material-icons") }) { Text("close") }
        }
      }
      InputChip("4", disabled = disabled, touch = touch) {
        PrimaryAction {
          Label("InputChip without trailing action")
        }
      }
    }
  }
  NamedBlock("Listbox") {
    val selected = remember { mutableStateListOf<String>("1") }
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
