package dev.petuska.kmdc.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.MDCContentRaw
import dev.petuska.kmdc.core.applyAttrs
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.dom.I
import org.jetbrains.compose.web.svg.Svg
import org.w3c.dom.HTMLElement
import org.w3c.dom.svg.SVGElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-button#icon)
 */
@MDCContentDsl
@Composable
public fun MDCButtonScope<*>.Icon(
  attrs: MDCAttrsRaw<HTMLElement>? = null,
  content: MDCContentRaw<HTMLElement>? = null,
) {
  I(
    attrs = {
      classes("mdc-button__icon")
      attr("aria-hidden", "true")
      applyAttrs(attrs)
    },
    content,
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-button#icon)
 */
@MDCContentDsl
@Composable
@ExperimentalComposeWebSvgApi
public fun MDCButtonScope<*>.Icon(
  viewBox: String?,
  attrs: MDCAttrsRaw<SVGElement>? = null,
  content: MDCContentRaw<SVGElement>? = null,
) {
  Svg(
    viewBox = viewBox,
    attrs = {
      classes("mdc-button__icon")
      attr("aria-hidden", "true")
      applyAttrs(attrs)
    },
    content = content,
  )
}
