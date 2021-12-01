package local.sandbox

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCell
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCells
import dev.petuska.kmdc.layout.grid.MDCLayoutGridScope
import dev.petuska.kmdc.textfield.MDCTextArea
import dev.petuska.kmdc.textfield.MDCTextField
import dev.petuska.kmdc.textfield.MDCTextFieldCommonOpts
import org.jetbrains.compose.web.css.paddingBottom
import org.jetbrains.compose.web.css.paddingTop
import org.jetbrains.compose.web.css.px

/**
 * Sample containing a user-selectable number of fields, placed inside an MDC grid.
 */
@Composable
fun MDCLayoutGridScope.MultipleFieldsSample() {
  var fieldCountText by remember { mutableStateOf("") }
  MDCLayoutGridCells(
    attrs = {
      style { paddingBottom(24.px) }
    }
  ) {
    MDCLayoutGridCell {
      MDCTextField(
        fieldCountText,
        opts = { label = "Field count" },
        attrs = {
          onInput { fieldCountText = it.value }
        }
      )
    }
  }

  MDCLayoutGridCells {
    val fieldCount = fieldCountText.toIntOrNull() ?: 0
    var fieldContent by remember { mutableStateOf("") }
    for (fieldNumber in 1..fieldCount) {
      MDCLayoutGridCell(opts = { span = 2u } ) {
        MDCTextField(
          fieldContent,
          opts = {
            type =
              if (fieldNumber.rem(2) == 1) MDCTextFieldCommonOpts.Type.Filled else MDCTextFieldCommonOpts.Type.Outlined
            label = "TextField #$fieldNumber"
          },
          attrs = {
            onInput { fieldContent = it.value }
          }
        )
      }
    }
  }

  MDCLayoutGridCells {
    val fieldCount = fieldCountText.toIntOrNull() ?: 0
    var fieldContent by remember { mutableStateOf("") }
    for (fieldNumber in 1..fieldCount) {
      MDCLayoutGridCell(
        opts = { span = 2u },
        attrs = {
          style {
            paddingTop(12.px)
            paddingBottom(12.px)
          }
        }
      ) {
        MDCTextArea(
          fieldContent,
          opts = {
            type =
              if (fieldNumber.rem(2) == 1) MDCTextFieldCommonOpts.Type.Filled else MDCTextFieldCommonOpts.Type.Outlined
            label = "TextArea #$fieldNumber"
          },
          attrs = {
            onInput { fieldContent = it.value }
          }
        )
      }
    }
  }

  var indeterminateEnabled by remember { mutableStateOf(false) }
  MDCLayoutGridCells {
    MDCLayoutGridCell {
      MDCFormField(attrs = { classes("mdc-layout-grid__cell--span-2") }) {
        MDCCheckbox(
          checked = indeterminateEnabled,
          opts = { label = "Make indeterminate" },
          attrs = {
            onInput { indeterminateEnabled = it.value }
          }
        )
      }
    }
  }

  MDCLayoutGridCells {
    val fieldCount = fieldCountText.toIntOrNull() ?: 0
    var fieldContent by remember { mutableStateOf(false) }
    for (fieldNumber in 1..fieldCount) {
      MDCLayoutGridCell(opts = { span = 2u }) {
        MDCFormField {
          MDCCheckbox(
            checked = fieldContent,
            opts = {
              label = "Checkbox #$fieldNumber"
              indeterminate = indeterminateEnabled
            },
            attrs = {
              onInput { fieldContent = it.value }
            }
          )
        }
      }
    }
  }
}
