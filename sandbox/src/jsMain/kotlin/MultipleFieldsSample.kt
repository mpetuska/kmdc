package local.sandbox

import androidx.compose.runtime.*
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCells
import dev.petuska.kmdc.layout.grid.MDCLayoutGridScope
import dev.petuska.kmdc.textfield.MDCTextArea
import dev.petuska.kmdc.textfield.MDCTextField
import dev.petuska.kmdc.textfield.MDCTextFieldCommonOpts
import org.jetbrains.compose.web.css.paddingBottom
import org.jetbrains.compose.web.css.paddingTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

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
    MDCTextField(
      fieldCountText,
      opts = { label = "Field count" },
      attrs = {
        onInput { fieldCountText = it.value }
      }
    )
  }

  MDCLayoutGridCells {
    val fieldCount = fieldCountText.toIntOrNull() ?: 0
    var fieldContent by remember { mutableStateOf("") }
    for (fieldNumber in 1..fieldCount) {
      Div(attrs = { classes("mdc-layout-grid__cell--span-2") }) {
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
      Div(
        attrs = {
          classes("mdc-layout-grid__cell--span-2")
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
    MDCFormField(attrs = { classes("mdc-layout-grid__cell--span-2") }) {
      MDCCheckbox(
        opts = { label = "Make indeterminate" },
        attrs = {
          checked(indeterminateEnabled)
          onInput { indeterminateEnabled = it.value }
        }
      )
    }
  }

  MDCLayoutGridCells {
    val fieldCount = fieldCountText.toIntOrNull() ?: 0
    var fieldContent by remember { mutableStateOf(false) }
    for (fieldNumber in 1..fieldCount) {
      MDCFormField(attrs = { classes("mdc-layout-grid__cell--span-2") }) {
        MDCCheckbox(
          opts = {
            label = "Checkbox #$fieldNumber"
            indeterminate = indeterminateEnabled
          },
          attrs = {
            checked(fieldContent)
            onInput { fieldContent = it.value }
          }
        )
      }
    }
  }
}
