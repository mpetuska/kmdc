package dev.petuska.kmdc.select

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.role
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

@Composable
internal fun <T : MDCSelectItem> MDCSelectAnchor(
  labelId: String,
  options: MDCSelectOpts<T>,
  leadingIcon: ComposableBuilder<MDCSelectLeadingIconScope>?,
  selectedTextId: String,
  items: List<T>,
  renderItem: @Composable ElementScope<HTMLSpanElement>.(T) -> Unit
) {
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

    leadingIcon?.invoke(MDCSelectLeadingIconScope())

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
        options.value?.let { selectedItem ->
          items.firstOrNull { it.value == selectedItem.value }?.let {
            renderItem(it)
          }
        }
      }
    }

    MDCSelectDownArrowIcon()

    Span(attrs = { classes("mdc-line-ripple") })
  }
}
