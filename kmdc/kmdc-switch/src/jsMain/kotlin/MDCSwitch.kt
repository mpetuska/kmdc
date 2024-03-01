package dev.petuska.kmdc.switch

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.svg.Path
import org.jetbrains.compose.web.svg.Svg
import org.w3c.dom.HTMLButtonElement

@JsModule("@material/switch/styles.scss")
private external val Style: dynamic

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-switch)
 */
@MDCContentDsl
@Composable
public fun MDCSwitch(
  selected: Boolean,
  label: String? = null,
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  content: MDCContentRaw<HTMLButtonElement>? = null,
) {
  Style
  val switchId = rememberUniqueDomElementId("switch")
  Button(attrs = {
    id(switchId)
    classes("mdc-switch")
    type(ButtonType.Button)
    role("switch")
    aria("checked", "$selected")
    if (selected) {
      classes("mdc-switch--selected")
    } else {
      classes("mdc-switch--unselected")
    }
    attrs?.invoke(this)
  }) {
    MDCProvider(::MDCSwitch) {
      Div(attrs = { classes("mdc-switch__track") })
      Div(attrs = { classes("mdc-switch__handle-track") }) {
        Div(attrs = { classes("mdc-switch__handle") }) {
          Div(attrs = { classes("mdc-switch__shadow") }) {
            Div(attrs = { classes("mdc-elevation-overlay") })
          }
          Div(attrs = { classes("mdc-switch__ripple") })
          MDCSwitchIcons()
        }
      }
      Span(attrs = { classes("mdc-switch__focus-ring-wrapper") }) {
        Div(attrs = { classes("mdc-switch__focus-ring") })
      }
      applyContent(content)
    }
  }
  label?.let {
    Label(forId = switchId) { Text(it) }
  }
}

@Composable
@OptIn(ExperimentalComposeWebSvgApi::class)
private fun MDCSwitchIcons() {
  Div(attrs = {
    classes("mdc-switch__icons")
  }) {
    Svg(
      viewBox = "0 0 24 24",
      attrs = {
        classes("mdc-switch__icon", "mdc-switch__icon--on")
      }
    ) {
      Path(d = "M19.69,5.23L8.96,15.96l-4.23-4.23L2.96,13.5l6,6L21.46,7L19.69,5.23z")
    }
    Svg(
      viewBox = "0 0 24 24",
      attrs = {
        classes("mdc-switch__icon", "mdc-switch__icon--off")
      }
    ) {
      Path(d = "M20 13H4v-2h16v2z")
    }
  }
}
