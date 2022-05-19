package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.textfield.MDCTextArea
import dev.petuska.kmdc.textfield.MDCTextField
import dev.petuska.kmdc.textfield.MDCTextFieldCommonOpts
import dev.petuska.kmdc.textfield.MDCTextFieldLeadingIcon
import dev.petuska.kmdc.textfield.MDCTextFieldTrailingIcon
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanChoice
import sandbox.control.NamedBlock
import sandbox.control.NamedGroup
import sandbox.control.RadioChoice
import sandbox.control.TextInput

private class MDCTextFieldVM {
  var type by mutableStateOf(MDCTextFieldCommonOpts.Type.Filled)
  var disabled by mutableStateOf(false)
  var label by mutableStateOf("")
  var helperText by mutableStateOf("")
  var maxLength by mutableStateOf("")
  var leadingIcon by mutableStateOf(false)
  var trailingIcon by mutableStateOf(false)

  var prefix by mutableStateOf("")
  var suffix by mutableStateOf("")

  var rows by mutableStateOf("8")
  var columns by mutableStateOf("40")
}

@Composable
@Showcase(id = "MDCTextField")
fun MDCTextField() = InteractiveShowcase(
  viewModel = { MDCTextFieldVM() },
  controls = {
    RadioChoice("Type", MDCTextFieldCommonOpts.Type.values().associateBy(MDCTextFieldCommonOpts.Type::name), ::type)
    BooleanChoice("Disabled", ::disabled)
    TextInput("Label", ::label)
    TextInput("Helper Text", ::helperText)
    TextInput("Max Length", ::maxLength)

    NamedGroup("Field") {
      TextInput("Prefix", ::prefix)
      TextInput("Suffix", ::suffix)
      BooleanChoice("Leading Icon", ::leadingIcon)
      BooleanChoice("Trailing Icon", ::trailingIcon)
    }

    NamedGroup("Area") {
      TextInput("Rows", ::rows)
      TextInput("Columns", ::columns)
    }
  },
) {
  var text by remember { mutableStateOf("") }
  val commonOpts: Builder<MDCTextFieldCommonOpts> = {
    type = this@InteractiveShowcase.type
    disabled = this@InteractiveShowcase.disabled
    label = this@InteractiveShowcase.label.takeIf(String::isNotBlank)
    helperText = this@InteractiveShowcase.helperText.takeIf(String::isNotBlank)
    maxLength = this@InteractiveShowcase.maxLength.takeIf(String::isNotBlank)?.toUInt()
  }
  NamedBlock("Field") {
    MDCTextField(
      text,
      opts = {
        commonOpts()
        prefix = this@InteractiveShowcase.prefix.takeIf(String::isNotBlank)
        suffix = this@InteractiveShowcase.suffix.takeIf(String::isNotBlank)
      },
      attrs = {
        onInput { text = it.value }
      },
      leadingIcon = if (leadingIcon) {
        {
          MDCTextFieldLeadingIcon(attrs = { classes("material-icons") }) { Text("phone") }
        }
      } else null,
      trailingIcon = if (trailingIcon) {
        {
          MDCTextFieldTrailingIcon(attrs = { classes("material-icons") }) { Text("event") }
        }
      } else null
    )
  }
  NamedBlock("Area") {
    MDCTextArea(
      text,
      opts = {
        commonOpts()
        rows = this@InteractiveShowcase.rows.toUInt()
        columns = this@InteractiveShowcase.columns.toUInt()
      },
      attrs = {
        onInput { text = it.value }
      }
    )
  }
}
