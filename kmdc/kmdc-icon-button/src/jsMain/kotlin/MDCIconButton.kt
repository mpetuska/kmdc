package dev.petuska.kmdc.icon.button

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.ripple.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

@JsModule("@material/icon-button/mdc-icon-button.scss")
private external val Style: dynamic

public interface MDCIconButtonScope<T : HTMLElement> : ElementScope<T>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-icon-button)
 */
@MDCDsl
@Composable
public fun MDCIconButton(
  on: Boolean = false,
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  content: MDCContent<MDCIconButtonScope<HTMLButtonElement>>? = null
) {
  Button(attrs = { attrs(on, attrs) }) {
    Content(on, content)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-icon-button)
 */
@MDCDsl
@Composable
public fun MDCIconLink(
  on: Boolean? = null,
  attrs: MDCAttrsRaw<HTMLAnchorElement>? = null,
  content: MDCContent<MDCIconButtonScope<HTMLAnchorElement>>? = null
) {
  A(attrs = { attrs(on == true, attrs) }) {
    Content(on, content)
  }
}

private fun <T : HTMLElement> AttrsScope<T>.attrs(
  on: Boolean,
  attrs: MDCAttrsRaw<T>? = null,
) {
  classes("mdc-icon-button")
  if (on) classes("mdc-icon-button--on")
  applyAttrs(attrs)
}

@Composable
private fun <T : HTMLElement> ElementScope<HTMLElement>.Content(
  on: Boolean?,
  content: MDCContent<MDCIconButtonScope<T>>? = null,
) {
  Style
  val render = @Composable {
    Span(attrs = { classes("mdc-icon-button__ripple") })
    applyContent(content)
  }
  if (on == null) {
    MDCRipple(unbounded = true)
    render()
  } else {
    MDCProvider(::MDCIconButtonToggle) {
      MDCStateEffect(on, MDCIconButtonToggle::on)
      render()
    }
  }
}
