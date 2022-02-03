package dev.petuska.kmdc.select

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.svg.Polygon
import org.jetbrains.compose.web.svg.Svg

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-select)
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
