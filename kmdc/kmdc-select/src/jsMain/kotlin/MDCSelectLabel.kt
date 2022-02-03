package dev.petuska.kmdc.select

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-select)
 */
@Composable
internal fun <T> MDCSelectLabel(
  options: MDCSelectOpts<T>,
  labelId: String
) {
  when (options.type) {
    MDCSelectOpts.Type.Filled -> {
      Span(attrs = { classes("mdc-select__ripple") })
      options.label?.let {
        MDCSelectFloatingLabel(labelId, it)
      }
    }
    MDCSelectOpts.Type.Outlined -> {
      Span(
        attrs = { classes("mdc-notched-outline") }
      ) {
        Span(attrs = { classes("mdc-notched-outline__leading") })
        options.label?.let {
          Span(attrs = { classes("mdc-notched-outline__notch") }) {
            MDCSelectFloatingLabel(labelId, it)
          }
        }
        Span(attrs = { classes("mdc-notched-outline__trailing") })
      }
    }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-select)
 */
@Composable
private fun MDCSelectFloatingLabel(id: String, label: String) {
  Span(
    attrs = {
      classes("mdc-floating-label", "mdc-floating-label--float-above")
      id(id)
    }
  ) {
    Text(label)
  }
}
