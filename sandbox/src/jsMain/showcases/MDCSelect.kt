package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.select.*
import dev.petuska.kmdc.select.anchor.Anchor
import dev.petuska.kmdc.select.menu.Menu
import dev.petuska.kmdc.select.menu.SelectItem
import sandbox.control.BooleanControl
import sandbox.control.ChoiceControl
import sandbox.control.TextControl
import sandbox.util.NamedGroup

private class MDCSelectVM {
  var type by mutableStateOf(MDCSelectType.Filled)
  var required by mutableStateOf(false)
  var disabled by mutableStateOf(false)
  var label by mutableStateOf("Select Fruit")

  var helperText by mutableStateOf("")
  var helperTextType by mutableStateOf(MDCSelectHelperTextType.Default)

  var selected by mutableStateOf("")

  val fruits = listOf("", "Apple", "Orange", "Banana")
}

@Composable
@Showcase(id = "MDCSelect")
fun MDCSelect() = InteractiveShowcase(
  viewModel = { MDCSelectVM() },
  controls = {
    ChoiceControl("Type", MDCSelectType.values().associateBy(MDCSelectType::name), ::type)
    BooleanControl("Required", ::required)
    BooleanControl("Disabled", ::disabled)
    TextControl("Label", ::label)
    NamedGroup("Helper Text") {
      TextControl("Text", ::helperText)
      ChoiceControl(
        title = "Type",
        options = MDCSelectHelperTextType.values().associateBy(MDCSelectHelperTextType::name),
        selected = ::helperTextType
      )
    }
  },
) {
  MDCSelect(
    type = type,
    required = required,
    disabled = disabled,
    helperText = helperText.takeIf(String::isNotBlank),
    helperTextType = helperTextType,
    attrs = {
      registerEvents()
      onChange {
        selected = fruits[it.detail.index]
      }
    }
  ) {
    Anchor(label)
    Menu {
      fruits.forEach {
        SelectItem(
          text = it,
          selected = selected == it,
          attrs = {
            attr("data-value", it)
          }
        )
      }
    }
  }
}

private fun MDCSelectAttrsScope.registerEvents() {
  onChange { console.log("MDCSelect#onChange", it.detail) }
}
