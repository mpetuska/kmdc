package samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.textfield.MDCTextArea
import dev.petuska.kmdc.textfield.MDCTextField
import dev.petuska.kmdc.textfield.MDCTextFieldCommonOpts
import dev.petuska.kmdc.textfield.MDCTextFieldLeadingIcon
import dev.petuska.kmdc.textfield.MDCTextFieldTrailingIcon
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

object MDCTextField : Samples() {
  override val content: SamplesRender = {
    MDCTextFieldCommonOpts.Type.values().forEach { t ->
      Sample("$t") { name ->
        var text by remember { mutableStateOf("") }
        MDCTextField(
          text,
          opts = {
            type = t
            label = "$name TextField"
          },
          attrs = {
            onInput { text = it.value }
          }
        )
      }
      Sample("$t Area") { name ->
        var text by remember { mutableStateOf("") }
        MDCTextArea(
          text,
          opts = {
            type = t
            label = "$name TextArea"
          },
          attrs = {
            onInput { text = it.value }
          }
        )
      }
    }
    Sample("With shiny baubles") { name ->
      var text by remember { mutableStateOf("") }
      Div {
        MDCTextField(
          text,
          opts = {
            type = MDCTextFieldCommonOpts.Type.Outlined
            label = name
            prefix = "prefix"
            suffix = "suffix"
            helperText = "helperText"
            maxLength = 30u
          },
          attrs = {
            onInput { text = it.value }
          },
          leadingIcon = {
            MDCTextFieldLeadingIcon(attrs = { classes("material-icons") }) { Text("phone") }
          },
          trailingIcon = {
            MDCTextFieldTrailingIcon(attrs = { classes("material-icons") }) { Text("event") }
          }
        )
      }
    }
  }
}
