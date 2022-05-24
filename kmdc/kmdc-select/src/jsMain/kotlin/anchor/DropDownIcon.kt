package dev.petuska.kmdc.select.anchor

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.svg.Polygon
import org.jetbrains.compose.web.svg.Svg
import org.w3c.dom.HTMLSpanElement

@MDCDsl
@Composable
@OptIn(ExperimentalComposeWebSvgApi::class)
internal fun DownDownIcon(
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
) {
  Span(
    attrs = {
      classes("mdc-select__dropdown-icon")
      applyAttrs(attrs)
    }
  ) {
    Svg(
      viewBox = "7 10 10 5",
      attrs = {
        classes("mdc-select__dropdown-icon-graphic")
        attr("focusable", "false")
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
