package dev.petuska.kmdc.switch

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.initialiseMDC
import dev.petuska.kmdc.core.role
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.svg.Path
import org.jetbrains.compose.web.svg.Svg
import org.w3c.dom.HTMLButtonElement

@JsModule("@material/switch/dist/mdc.switch.css")
private external val MDCSwitchCSS: dynamic

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-switch)
 */
@OptIn(ExperimentalComposeWebSvgApi::class)
@MDCDsl
@Composable
public fun MDCSwitch(
  selected: Boolean = false,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
) {
  MDCSwitchCSS
  Button(attrs = {
    classes("mdc-switch")
    type(ButtonType.Button)
    role("switch")
    aria("checked", "$selected")
    if (selected) {
      classes("mdc-switch--selected")
    } else {
      classes("mdc-switch--unselected")
    }
    initialiseMDC(MDCSwitchModule.MDCSwitch::attachTo)
    attrs?.invoke(this)
  }) {
    Div(attrs = {
      classes("mdc-switch__track")
    })
    Div(attrs = {
      classes("mdc-switch__handle-track")
    }) {
      Div(attrs = {
        classes("mdc-switch__handle")
      }) {
        Div(attrs = {
          classes("mdc-switch__shadow")
        }) {
          Div(attrs = {
            classes("mdc-elevation-overlay")
          })
        }
        Div(attrs = {
          classes("mdc-switch__ripple")
        })
        MDCSwitchIcons()
      }
    }
  }
}

@Suppress("NOTHING_TO_INLINE")
@Composable
@OptIn(ExperimentalComposeWebSvgApi::class)
private inline fun MDCSwitchIcons() {
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
