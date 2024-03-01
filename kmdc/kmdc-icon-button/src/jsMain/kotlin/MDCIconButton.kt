package dev.petuska.kmdc.icon.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.ripple.MDCRippleLayout
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLElement

@JsModule("@material/icon-button/mdc-icon-button.scss")
private external val Style: dynamic

public interface MDCIconButtonAttrsScope<T : HTMLElement> : AttrsScope<T>
public interface MDCIconButtonScope<T : HTMLElement> : ElementScope<T>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-icon-button)
 */
@MDCContentDsl
@Composable
public fun MDCIconButton(
  on: Boolean? = null,
  touch: Boolean = false,
  attrs: MDCAttrs<MDCIconButtonAttrsScope<HTMLButtonElement>>? = null,
  content: MDCContent<MDCIconButtonScope<HTMLButtonElement>>? = null
) {
  Button(attrs = { attrs(on, attrs) }) {
    Content(on = on, touch = touch, content = content)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-icon-button)
 */
@MDCContentDsl
@Composable
public fun MDCIconLink(
  on: Boolean? = null,
  touch: Boolean = false,
  attrs: MDCAttrs<MDCIconButtonAttrsScope<HTMLAnchorElement>>? = null,
  content: MDCContent<MDCIconButtonScope<HTMLAnchorElement>>? = null
) {
  A(attrs = { attrs(on == true, attrs) }) {
    Content(on = on, touch = touch, content = content)
  }
}

private fun <T : HTMLElement> AttrsScope<T>.attrs(
  on: Boolean?,
  attrs: MDCAttrs<MDCIconButtonAttrsScope<T>>? = null,
) {
  classes("mdc-icon-button")
  if (on == true) classes("mdc-icon-button--on")
  applyAttrs(attrs)
}

@Composable
private fun <T : HTMLElement> ElementScope<HTMLElement>.Content(
  on: Boolean?,
  touch: Boolean,
  content: MDCContent<MDCIconButtonScope<T>>? = null,
) {
  Style
  val render = @Composable {
    Div(attrs = { classes("mdc-icon-button__ripple") })
    Span(attrs = { classes("mdc-icon-button__focus-ring") })
    applyContent(content)
    if (touch) Div(attrs = { classes("mdc-icon-button__touch") })
  }
  if (on == null) {
    MDCRippleLayout(unbounded = true)
    render()
  } else {
    MDCProvider(::MDCIconButtonToggle) {
      MDCStateEffect(on, MDCIconButtonToggle::on)
      render()
    }
  }
}
