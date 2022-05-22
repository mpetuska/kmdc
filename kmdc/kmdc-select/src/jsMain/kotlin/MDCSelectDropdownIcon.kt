package dev.petuska.kmdc.select

import androidx.compose.runtime.*
import org.jetbrains.compose.web.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.svg.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-select)
 */
@OptIn(ExperimentalComposeWebSvgApi::class)
@Composable
internal fun MDCSelectDownArrowIcon() {
  Span(
    attrs = { classes("mdc-select__dropdown-icon") }
  ) {
    Svg(
      viewBox = "7 10 10 5",
      attrs = {
        attr("focusable", "false")
        classes("mdc-select__dropdown-icon-graphic")
      }
    ) {
      Polygon(
        7, 10, 12, 15, 17, 10,
        attrs = {
          classes("mdc-select__dropdown-icon-inactive")
          attr("stroke", "none")
          attr("fill-rule", "evenodd")
        }
      )
      Polygon(
        7, 15, 12, 10, 17, 15,
        attrs = {
          classes("mdc-select__dropdown-icon-active")
          attr("stroke", "none")
          attr("fill-rule", "evenodd")
        }
      )
    }
  }
}
