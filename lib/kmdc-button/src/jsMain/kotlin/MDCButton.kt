package dev.petuska.kmdc.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.Builder
import dev.petuska.kmdc.ComposableBuilder
import dev.petuska.kmdc.MDCDsl
import dev.petuska.kmdc.ripple.MDCRipple
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLButtonElement

@JsModule("@material/button/dist/mdc.button.css")
private external val MDCButtonStyle: dynamic

public data class MDCButtonOpts(
  var type: Type = Type.Text,
  var icon: MDCButtonIconType = MDCButtonIconType.None
) {
  public enum class Type(public vararg val classes: String) {
    Text, Outlined("mdc-button--outlined"), Raised("mdc-button--raised"), Unelevated("mdc-button--unelevated")
  }

  public enum class MDCButtonIconType(public vararg val classes: String) {
    None, Leading("mdc-button--icon-leading"), Trailing("mdc-button--icon-trailing")
  }
}

public class MDCButtonScope(scope: ElementScope<HTMLButtonElement>) : ElementScope<HTMLButtonElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-button)
 */
@MDCDsl
@Composable
public fun MDCButton(
  opts: Builder<MDCButtonOpts>? = null,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: ComposableBuilder<MDCButtonScope>? = null
) {
  MDCButtonStyle
  val options = MDCButtonOpts().apply { opts?.invoke(this) }
  Button(
    attrs = {
      classes("mdc-button", *options.type.classes, *options.icon.classes)
      attrs?.invoke(this)
    }
  ) {
    Span(attrs = { classes("mdc-button__ripple") })
    MDCRipple()
    content?.let { MDCButtonScope(this).it() }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-button)
 */
@MDCDsl
@Composable
public fun MDCButton(
  text: String,
  opts: Builder<MDCButtonOpts>? = null,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
) {
  MDCButton(opts, attrs) {
    Text(text)
  }
}
