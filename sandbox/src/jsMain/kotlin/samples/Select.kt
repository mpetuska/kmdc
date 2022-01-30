package local.sandbox.samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdc.select.MDCSelect
import dev.petuska.kmdc.select.MDCSelectHelperText
import dev.petuska.kmdc.select.MDCSelectOpts
import dev.petuska.kmdc.select.MDCSelectItem
import dev.petuska.kmdc.select.MDCSelectLeadingIcon
import dev.petuska.kmdcx.icons.MDCIconOpts
import local.sandbox.engine.Sample
import local.sandbox.engine.Samples
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Suppress("unused")
private val SelectSamples = Samples("MDCSelect") {
  var selectedValue by remember { mutableStateOf(fruitItems[1]) }
  var isRequired by remember { mutableStateOf(false) }
  var isDisabled by remember { mutableStateOf(false) }

  Sample("Filled") {
    Div {
      MDCSelect(
        fruitItems,
        opts = {
          type = MDCSelectOpts.Type.Filled
          value = selectedValue
          onChange = { selectedValue = it }
          required = isRequired
          disabled = isDisabled
          hiddenInputName = "filledSelect"
          label = "Fruit"
        }
      ) {
        Text(it.value)
      }
    }
    Div {
      MDCFormField {
        MDCCheckbox(isRequired, opts = { label = "Required" }, attrs = { onChange { isRequired = it.value } })
      }
    }
    Div {
      MDCFormField {
        MDCCheckbox(isDisabled, opts = { label = "Disabled" }, attrs = { onChange { isDisabled = it.value } })
      }
    }
  }

  Sample("Outlined") {
    MDCSelect(
      fruitItems,
      opts = {
        type = MDCSelectOpts.Type.Outlined
        value = selectedValue
        onChange = { selectedValue = it }
        label = "Fruit"
      }
    ) {
      Text(it.value)
    }
  }

  Sample("Helper text") {
    var helperTextType by remember { mutableStateOf(MDCSelectHelperText.Type.Default) }
    Div {
      MDCSelect(
        MDCSelectHelperText.Type.values().toList(),
        opts = {
          type = MDCSelectOpts.Type.Filled
          value = helperTextType
          onChange = { helperTextType = it }
        }
      ) {
        Text(it.name)
      }
    }
    Br()
    Div {
      MDCSelect(
        fruitItems,
        opts = {
          type = MDCSelectOpts.Type.Outlined
          value = selectedValue
          onChange = { selectedValue = it }
          label = "Fruit"
          required = true
          helperText = MDCSelectHelperText("Please pick up your favorite fruit", helperTextType)
        }
      ) {
        Text(it.value)
      }
    }
  }

  Sample("With leading icon") {
    MDCSelect(
      fruitItems,
      opts = {
        type = MDCSelectOpts.Type.Filled
        value = selectedValue
        onChange = { selectedValue = it }
      },
      leadingIcon = {
        MDCSelectLeadingIcon(
          clickable = true,
          attrs = { classes("material-icons") }
        ) {
          Text(MDCIconOpts.MDCIconType.FoodBank.iconType)
        }
      }
    ) {
      Text(it.value)
    }

    Span(attrs = { style { width(10.px) } })

    MDCSelect(
      fruits,
      opts = {
        type = MDCSelectOpts.Type.Outlined
        value = selectedValue.value
        onChange = { selectedValue = FruitItem(it, false) }
      },
      leadingIcon = {
        MDCSelectLeadingIcon(
          clickable = false,
          attrs = { classes("material-icons") }
        ) {
          Text(MDCIconOpts.MDCIconType.FoodBank.iconType)
        }
      }
    )
  }
}

private val fruits = listOf("", "Apple", "Orange", "Banana")

private val fruitItems = (fruits + "Potato").map { FruitItem(it, it == "Potato") }

private data class FruitItem(override val value: String, override val disabled: Boolean) : MDCSelectItem