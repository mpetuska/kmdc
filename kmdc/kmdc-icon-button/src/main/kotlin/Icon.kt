package dev.petuska.kmdc.icon.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.dom.I
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.svg.Svg
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLImageElement
import org.w3c.dom.svg.SVGElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-icon-button)
 */
@MDCContentDsl
@Composable
public fun MDCIconButtonScope<*>.Icon(
  on: Boolean,
  attrs: MDCAttrsRaw<HTMLElement>? = null,
  content: MDCContentRaw<HTMLElement>? = null,
) {
  I(attrs = attrs.build(on), content = content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-icon-button)
 */
@OptIn(ExperimentalComposeWebSvgApi::class)
@MDCContentDsl
@Composable
public fun MDCIconButtonScope<*>.SvgIcon(
  viewBox: String,
  on: Boolean,
  attrs: MDCAttrsRaw<SVGElement>? = null,
  content: MDCContentRaw<SVGElement>? = null,
) {
  Svg(viewBox = viewBox, attrs = attrs.build(on), content = content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-icon-button)
 */
@MDCContentDsl
@Composable
public fun MDCIconButtonScope<*>.ImgIcon(
  src: String,
  alt: String = "",
  on: Boolean,
  attrs: MDCAttrsRaw<HTMLImageElement>? = null,
) {
  Img(src = src, alt = alt, attrs = attrs.build(on))
}

private fun <T : Element> MDCAttrsRaw<T>?.build(
  on: Boolean,
): AttrsBuilder<T> = {
  classes("mdc-icon-button__icon")
  if (on) classes("mdc-icon-button__icon--on")
  applyAttrs(this@build)
}
