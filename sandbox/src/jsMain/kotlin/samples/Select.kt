package local.sandbox.samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdc.select.MDCSelect
import dev.petuska.kmdc.select.MDCSelectOpts
import dev.petuska.kmdc.select.onChange
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
  var selectedValue by remember { mutableStateOf(fruits[1]) }
  var isRequired by remember { mutableStateOf(false) }
  var isDisabled by remember { mutableStateOf(false) }

  Sample("Filled") {
    Div {
      MDCSelect(
        fruits + "Potato",
        opts = {
          type = MDCSelectOpts.Type.Filled
          value = selectedValue
          required = isRequired
          disabled = isDisabled
          itemDisabled = { this == "Potato" }
          hiddenInputName = "filledSelect"
          label = "Fruit"
        },
        attrs = {
          onChange { selectedValue = it }
        }
      )
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
      fruits + "Potato",
      opts = {
        type = MDCSelectOpts.Type.Outlined
        value = selectedValue
        label = "Fruit"
        itemDisabled = { this == "Potato" }
      },
      attrs = {
        onChange { selectedValue = it }
      }
    )
  }

  Sample("Helper text") {
    var helperTextType by remember { mutableStateOf(MDCSelectOpts.HelperTextType.Default) }
    Div {
      MDCSelect(
        MDCSelectOpts.HelperTextType.values().toList(),
        opts = {
          type = MDCSelectOpts.Type.Filled
          value = helperTextType
        },
        attrs = {
          onChange { helperTextType = it }
        }
      ) {
        Text(it.name)
      }
    }
    Br()
    Div {
      MDCSelect(
        fruits,
        opts = {
          type = MDCSelectOpts.Type.Outlined
          value = selectedValue
          label = "Fruit"
          required = true
          helperText = "Please pick up your favorite fruit"
          this.helperTextType = helperTextType
        },
        attrs = {
          onChange { selectedValue = it }
        }
      )
    }
  }

  Sample("With leading icon") {
    MDCSelect(
      fruits,
      opts = {
        type = MDCSelectOpts.Type.Filled
        value = selectedValue
        leadingIcon = MDCIconOpts.MDCIconType.FoodBank.iconType
        leadingIconClickable = true
      },
      attrs = {
        onChange { selectedValue = it }
      }
    )

    Span(attrs = { style { width(10.px) } })

    MDCSelect(
      fruits,
      opts = {
        type = MDCSelectOpts.Type.Outlined
        value = selectedValue
        leadingIcon = MDCIconOpts.MDCIconType.FoodBank.iconType
        leadingIconClickable = false
      },
      attrs = {
        onChange { selectedValue = it }
      }
    )
  }
}

private val fruits = listOf("", "Apple", "Orange", "Banana")
