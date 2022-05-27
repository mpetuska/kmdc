package dev.petuska.kmdc.icon.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.ripple.MDCRippleLayout
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLElement

@JsModule("@material/icon-button/mdc-icon-button.scss")
private external val Style: dynamic

public interface MDCIconButtonScope<T : HTMLElement> : ElementScope<T>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-icon-button)
 */
@MDCContentDsl
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
@MDCContentDsl
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
    MDCRippleLayout(unbounded = true)
    render()
  } else {
    MDCProvider(::MDCIconButtonToggle) {
      MDCStateEffectNew(on, MDCIconButtonToggle::on)
      render()
    }
  }
}
