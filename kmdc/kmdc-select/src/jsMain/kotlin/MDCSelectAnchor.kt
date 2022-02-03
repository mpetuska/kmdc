package dev.petuska.kmdc.select

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.role
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.I
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

@Composable
internal fun <T> MDCSelectAnchor(
  labelId: String,
  options: MDCSelectOpts<T>,
  selectedTextId: String,
  items: List<T>,
  renderItem: @Composable ElementScope<HTMLSpanElement>.(T) -> Unit
) {
  fun T.itemValue() = with(options) { itemValue() }

  Div(
    attrs = {
      classes("mdc-select__anchor")
      role("button")
      aria("haspopup", "listbox")
      aria("expanded", "false")
      aria("labelledby", labelId)
    }
  ) {

    MDCSelectLabel(options, labelId)

    options.leadingIcon?.let { icon ->
      MDCSelectLeadingIcon(options, icon)
    }

    Span(
      attrs = {
        classes("mdc-select__selected-text-container")
      }
    ) {
      Span(
        attrs = {
          classes("mdc-select__selected-text")
          id(selectedTextId)
        }
      ) {
        options.value?.itemValue()?.let { selectedValue ->
          items.firstOrNull { it.itemValue() == selectedValue }?.let {
            renderItem(it)
          }
        }
      }
    }

    MDCSelectDownArrowIcon()

    Span(attrs = { classes("mdc-line-ripple") })
  }
}

@Composable
private fun <T> MDCSelectLeadingIcon(options: MDCSelectOpts<T>, icon: String) {
  I(
    attrs = {
      classes("mdc-select__icon")
      if (options.leadingIconClickable) {
        tabIndex(0)
        role("button")
      }
      classes(*options.leadingIconClasses.toTypedArray())
    }
  ) {
    Text(icon)
  }
}
