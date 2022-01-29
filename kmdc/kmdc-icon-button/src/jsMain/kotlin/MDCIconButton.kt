package dev.petuska.kmdc.icon.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.initialiseMDC
import dev.petuska.kmdc.core.mdc
import dev.petuska.kmdc.ripple.MDCRipple
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLButtonElement

@JsModule("@material/icon-button/dist/mdc.icon-button.css")
private external val MDCIconButtonStyle: dynamic

public data class MDCIconButtonOpts(var on: Boolean = false)

public class MDCIconButtonScope(scope: ElementScope<HTMLButtonElement>) : ElementScope<HTMLButtonElement> by scope

public class MDCIconLinkScope(scope: ElementScope<HTMLAnchorElement>) : ElementScope<HTMLAnchorElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-icon-button)
 */
@MDCDsl
@Composable
public fun MDCIconButton(
  opts: Builder<MDCIconButtonOpts>? = null,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: ComposableBuilder<MDCIconButtonScope>? = null
) {
  MDCIconButtonStyle
  val options = MDCIconButtonOpts().apply { opts?.invoke(this) }
  Button(
    attrs = {
      classes(*listOfNotNull("mdc-icon-button", if (options.on) "mdc-icon-button--on" else null).toTypedArray())
      initialiseMDC(MDCIconButtonModule.MDCIconButtonToggle::attachTo)
      attrs?.invoke(this)
    },
  ) {
    MDCRipple(opts = { isUnbounded = true })
    Span(attrs = { classes("mdc-icon-button__ripple") })
    content?.let { MDCIconButtonScope(this).it() }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-icon-button)
 */
@MDCDsl
@Composable
public fun MDCIconLink(
  opts: Builder<MDCIconButtonOpts>? = null,
  attrs: AttrBuilderContext<HTMLAnchorElement>? = null,
  content: ComposableBuilder<MDCIconLinkScope>? = null
) {
  MDCIconButtonStyle
  val options = MDCIconButtonOpts().apply { opts?.invoke(this) }
  A(
    attrs = {
      classes(*listOfNotNull("mdc-icon-button", if (options.on) "mdc-icon-button--on" else null).toTypedArray())
      ref {
        it.mdc = MDCIconButtonModule.MDCIconButtonToggle.attachTo(it)
        onDispose {
          it.mdc<MDCIconButtonModule.MDCIconButtonToggle> { destroy() }
        }
      }
      attrs?.invoke(this)
    },
  ) {
    MDCRipple(opts = { isUnbounded = true })
    Span(attrs = { classes("mdc-icon-button__ripple") })
    content?.let { MDCIconLinkScope(this).it() }
  }
}
