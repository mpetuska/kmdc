package dev.petuska.kmdc.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.I
import org.jetbrains.compose.web.svg.Svg
import org.w3c.dom.HTMLElement
import org.w3c.dom.svg.SVGElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-button#icon)
 */
@MDCDsl
@Composable
public fun MDCButtonScope.Icon(
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: ContentBuilder<HTMLElement>? = null,
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
@MDCDsl
@Composable
@ExperimentalComposeWebSvgApi
public fun MDCButtonScope.Icon(
  viewBox: String?,
  attrs: AttrsBuilder<SVGElement>? = null,
  content: ContentBuilder<SVGElement>? = null,
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
