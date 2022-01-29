package local.sandbox.samples

import MDCSelect
import MDCSelectHelperText
import MDCSelectItem
import MDCSelectLeadingIcon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdcx.icons.MDCIconOpts
import local.sandbox.engine.Sample
import local.sandbox.engine.Samples
import onChange
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Suppress("unused")
private val SelectSamples = Samples("MDCSelect") {
  var value by remember { mutableStateOf("apple") }
  var required by remember { mutableStateOf(false) }
  var disabled by remember { mutableStateOf(false) }

  Sample("Filled") {
    Div {
      MDCSelect(
        fruits,
        value,
        opts = {
          type = MDCSelectOpts.Type.Filled
          this.required = required
          this.disabled = disabled
          hiddenInputName = "filledSelect"
          label = "Fruit"
        },
        attrs = {
          onChange { value = it.detail.value }
        }
      )
    }
    Div {
      MDCFormField {
        MDCCheckbox(required, opts = { label = "Required" }, attrs = { onChange { required = it.value } })
      }
    }
    Div {
      MDCFormField {
        MDCCheckbox(disabled, opts = { label = "Disabled" }, attrs = { onChange { disabled = it.value } })
      }
    }
  }

  Sample("Outlined") {
    MDCSelect(
      fruits,
      value,
      opts = {
        type = MDCSelectOpts.Type.Outlined
        label = "Fruit"
      },
      attrs = {
        onChange { value = it.detail.value }
      }
    )
  }

  Sample("Helper text") {
    var helperTextType by remember { mutableStateOf(MDCSelectHelperText.Type.Default) }
    Div {
      MDCSelect(
        MDCSelectHelperText.Type.values().map {
          MDCSelectItem(it.name, it.name)
        },
        helperTextType.name,
        opts = {
          type = MDCSelectOpts.Type.Filled
        },
        attrs = {
          onChange { helperTextType = MDCSelectHelperText.Type.valueOf(it.detail.value) }
        }
      )
    }
    Br()
    Div {
      MDCSelect(
        fruits,
        value,
        opts = {
          type = MDCSelectOpts.Type.Outlined
          label = "Fruit"
          this.required = true
          helperText = MDCSelectHelperText("Please pick up your favorite fruit", helperTextType)
        },
        attrs = {
          onChange { value = it.detail.value }
        }
      )
    }
  }

  Sample("With leading icon") {
    MDCSelect(
      fruits,
      value,
      opts = {
        type = MDCSelectOpts.Type.Filled
      },
      attrs = {
        onChange { value = it.detail.value }
      },
      leadingIcon = {
        MDCSelectLeadingIcon(
          clickable = true,
          attrs = { classes("material-icons") }
        ) {
          Text(MDCIconOpts.MDCIconType.FoodBank.iconType)
        }
      }
    )

    Span(attrs = { style { width(10.px) } })

    MDCSelect(
      fruits,
      value,
      opts = {
        type = MDCSelectOpts.Type.Outlined
      },
      attrs = {
        onChange { value = it.detail.value }
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

private val fruits = listOf(
  MDCSelectItem("", ""),
  MDCSelectItem("apple", "Apple"),
  MDCSelectItem("orange", "Orange"),
  MDCSelectItem("banana", "Banana"),
  MDCSelectItem("potato", "Potato", disabled = true)
)
