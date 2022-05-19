package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.chips.MDCChipsAttrsScope
import dev.petuska.kmdc.chips.action.Checkmark
import dev.petuska.kmdc.chips.action.Graphic
import dev.petuska.kmdc.chips.action.Icon
import dev.petuska.kmdc.chips.action.Label
import dev.petuska.kmdc.chips.grid.ActionChip
import dev.petuska.kmdc.chips.grid.InputChip
import dev.petuska.kmdc.chips.grid.MDCChipsGrid
import dev.petuska.kmdc.chips.grid.PrimaryAction
import dev.petuska.kmdc.chips.grid.TrailingAction
import dev.petuska.kmdc.chips.listbox.FilterChip
import dev.petuska.kmdc.chips.listbox.MDCChipsListbox
import dev.petuska.kmdc.chips.onInteraction
import dev.petuska.kmdc.chips.onRemoval
import dev.petuska.kmdc.chips.onSelection
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanChoice
import sandbox.control.Named

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
    BooleanChoice("Disabled", ::disabled)
    BooleanChoice("Multiselectable", ::multiselectable)
    BooleanChoice("Overflow", ::overflow)
    BooleanChoice("Touch", ::touch)
  },
) {
  Named("Grid") {
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
  Named("Listbox") {
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
