package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.textfield.MDCTextArea
import dev.petuska.kmdc.textfield.MDCTextField
import dev.petuska.kmdc.textfield.MDCTextFieldType
import dev.petuska.kmdc.textfield.icon.MDCTextFieldLeadingIcon
import dev.petuska.kmdc.textfield.icon.MDCTextFieldTrailingIcon
import dev.petuska.kmdcx.icons.MDCIcon
import dev.petuska.kmdcx.icons.mdcIcon
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanControl
import sandbox.control.ChoiceControl
import sandbox.control.RangeControl
import sandbox.control.TextControl
import sandbox.util.NamedBlock
import sandbox.util.NamedGroup

private class MDCTextFieldVM {
  var type by mutableStateOf(MDCTextFieldType.Filled)
  var disabled by mutableStateOf(false)
  var label by mutableStateOf("")
  var helperText by mutableStateOf("")
  var maxLength by mutableStateOf(50)
  var leadingIcon by mutableStateOf(false)
  var trailingIcon by mutableStateOf(false)

  var prefix by mutableStateOf("")
  var suffix by mutableStateOf("")

  var rows by mutableStateOf(8)
  var columns by mutableStateOf(40)
}

@Composable
@Showcase(id = "MDCTextField")
fun MDCTextField() = InteractiveShowcase(
  viewModel = { MDCTextFieldVM() },
  controls = {
    ChoiceControl("Type", MDCTextFieldType.values().associateBy(MDCTextFieldType::name), ::type)
    BooleanControl("Disabled", ::disabled)
    TextControl("Label", ::label)
    TextControl("Helper Text", ::helperText)
    RangeControl("Max Length", ::maxLength, converter = Number::toInt)

    NamedGroup("Field") {
      TextControl("Prefix", ::prefix)
      TextControl("Suffix", ::suffix)
      BooleanControl("Leading Icon", ::leadingIcon)
      BooleanControl("Trailing Icon", ::trailingIcon)
    }

    NamedGroup("Area") {
      RangeControl("Rows", ::rows, min = 1, max = 16, converter = Number::toInt)
      RangeControl("Columns", ::columns, min = 1, max = 80, converter = Number::toInt)
    }
  },
) {
  var text by remember { mutableStateOf("") }
  NamedBlock("Field", attrs = { style { property("width", "fit-content") } }) {
    MDCTextField(
      value = text,
      type = type,
      disabled = disabled,
      label = label.takeIf(String::isNotBlank),
      helperText = helperText.takeIf(String::isNotBlank),
      maxLength = maxLength.toUInt(),
      prefix = prefix.takeIf(String::isNotBlank),
      suffix = suffix.takeIf(String::isNotBlank),
      attrs = {
        onInput { text = it.value }
      },
      leadingIcon = if (leadingIcon) {
        {
          MDCTextFieldLeadingIcon(attrs = { mdcIcon() }) { Text(MDCIcon.Phone.type) }
        }
      } else {
        null
      },
      trailingIcon = if (trailingIcon) {
        {
          MDCTextFieldTrailingIcon(attrs = { mdcIcon() }) { Text(MDCIcon.Event.type) }
        }
      } else {
        null
      }
    )
  }
  NamedBlock("Area", attrs = { style { property("width", "fit-content") } }) {
    MDCTextArea(
      value = text,
      type = type,
      disabled = disabled,
      label = label.takeIf(String::isNotBlank),
      helperText = helperText.takeIf(String::isNotBlank),
      maxLength = maxLength.toUInt(),
      rows = rows.toUInt(),
      columns = columns.toUInt(),
      attrs = {
        onInput { text = it.value }
      }
    )
  }
}
