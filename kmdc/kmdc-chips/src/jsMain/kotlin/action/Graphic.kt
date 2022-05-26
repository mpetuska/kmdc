package dev.petuska.kmdc.chips.action

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.svg.*
import org.w3c.dom.*

public interface MDCFilterChipGraphicScope : MDCChipActionIconScope<HTMLSpanElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCContentDsl
@Composable
public fun MDCChipActionScope<*>.Graphic(
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
  content: MDCContent<MDCFilterChipGraphicScope>? = null
) {
  Span(
    attrs = {
      classes("mdc-evolution-chip__graphic")
      applyAttrs(attrs)
    },
    content = content.reinterpret(),
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@OptIn(ExperimentalComposeWebSvgApi::class)
@MDCContentDsl
@Composable
public fun MDCFilterChipGraphicScope.Checkmark(
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
) {
  Span(
    attrs = {
      classes("mdc-evolution-chip__checkmark")
      applyAttrs(attrs)
    },
    content = {
      Svg(
        viewBox = "-2 -3 30 30",
        attrs = {
          classes("mdc-evolution-chip__checkmark-svg")
        },
        content = {
          Path(
            d = "M1.73,12.91 8.1,19.28 22.79,4.59",
            attrs = {
              attr("fill", "none")
              attr("stroke", "black")
              classes("mdc-evolution-chip__checkmark-path")
            }
          )
        }
      )
    }
  )
}
