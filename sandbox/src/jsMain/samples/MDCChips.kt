package samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.checkbox.MDCCheckbox
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
import dev.petuska.kmdc.core.KMDCInternalAPI
import dev.petuska.kmdc.core.rememberMutableStateOf
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdc.typography.MDCBody1
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

object MDCChips : Samples() {
  @OptIn(KMDCInternalAPI::class)
  override val content: SamplesRender = {
    Grid()
    Sample("ListBox - single") {
      var disabled by rememberMutableStateOf(false)
      Div {
        MDCFormField {
          MDCCheckbox(checked = disabled, label = "Disabled", attrs = { onClick { disabled = !disabled } })
        }
      }
      Div {
        MDCChipsListbox(multiselectable = false, attrs = {
          registerEvents()
        }) {
          repeat(2) { id ->
            FilterChip(
              "$id",
              selected = false,
              disabled = disabled,
              withPrimaryGraphic = true,
            ) {
              Graphic {
                Checkmark()
              }
              Label("FilterChip - $id")
            }
          }
        }
      }
    }
    Sample("ListBox - multi") {
      var disabled by rememberMutableStateOf(false)
      val selected = remember { mutableStateListOf<String>("1") }
      Div {
        MDCFormField {
          MDCCheckbox(checked = disabled, label = "Disabled", attrs = { onClick { disabled = !disabled } })
        }
        MDCBody1("Selected: ${selected.joinToString(",")}")
      }
      Div {
        MDCChipsListbox(multiselectable = true, attrs = {
          registerEvents()
          onSelection {
            if (it.detail.isSelected) {
              selected.add(it.detail.chipID)
            } else {
              selected.remove(it.detail.chipID)
            }
          }
        }) {
          repeat(2) { id ->
            FilterChip(
              "$id",
              selected = "$id" in selected,
              disabled = disabled,
              withPrimaryGraphic = true,
              withPrimaryIcon = true,
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
  }

  private fun MDCChipsAttrsScope.registerEvents() {
    onInteraction { console.log("MDCChips#onInteraction", it.detail) }
    onSelection { console.log("MDCChips#onSelection", it.detail) }
    onRemoval { console.log("MDCChips#onRemoval", it.detail) }
  }

  @OptIn(KMDCInternalAPI::class)
  private val Grid: Sample = Sample("Grid") {
    var disabled by rememberMutableStateOf(false)
    Div {
      MDCFormField {
        MDCCheckbox(checked = disabled, label = "Disabled", attrs = { onClick { disabled = !disabled } })
      }
    }
    Div {
      MDCChipsGrid(attrs = {
        registerEvents()
      }) {
        ActionChip(
          "1", disabled = disabled, withPrimaryIcon = true
        ) {
          Graphic {
            Icon(attrs = { classes("material-icons") }) { Text("favorite") }
            Checkmark()
          }
          Label("ActionChip")
        }
        InputChip(
          "2", withPrimaryIcon = true, withTrailingAction = true, disabled = disabled
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
          "3", disabled = disabled, withTrailingAction = true, navigableTrailingAction = false
        ) {
          PrimaryAction {
            Label("InputChip with non-navigable trailing action")
          }
          TrailingAction {
            Icon(attrs = { classes("material-icons") }) { Text("close") }
          }
        }
        InputChip("4", disabled = disabled) {
          PrimaryAction {
            Label("InputChip without trailing action")
          }
        }
      }
    }
  }
}
