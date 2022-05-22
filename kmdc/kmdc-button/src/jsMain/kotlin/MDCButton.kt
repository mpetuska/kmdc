package dev.petuska.kmdc.button

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.elevation.*
import dev.petuska.kmdc.ripple.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

@JsModule("@material/button/styles.scss")
private external val MDCButtonStyles: dynamic

public enum class MDCButtonType(public vararg val classes: String) {
  Text, Outlined("mdc-button--outlined"), Raised("mdc-button--raised"), Unelevated("mdc-button--unelevated")
}

public enum class MDCButtonIconType(public vararg val classes: String) {
  None, Leading("mdc-button--icon-leading"), Trailing("mdc-button--icon-trailing")
}

public interface MDCButtonScope : ElementScope<HTMLButtonElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-button)
 */
@MDCDsl
@Composable
public fun MDCButton(
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  touch: Boolean = false,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: MDCContent<MDCButtonScope>? = null
) {
  MDCButtonStyles
  Button(
    attrs = {
      classes("mdc-button")
      classes(type.classes)
      classes(icon.classes)
      if (touch) classes("mdc-button--touch")
      attrs?.invoke(this)
    }
  ) {
    MDCElevationOverlay()
    Span(attrs = { classes("mdc-button__ripple") })
    Span(attrs = { classes("mdc-button__focus-ring") })
    MDCRipple()
    applyContent(content)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-button)
 */
@MDCDsl
@Composable
public fun MDCButton(
  text: String,
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  touch: Boolean = false,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
) {
  MDCButton(type, icon, touch, attrs) {
    Label(text)
  }
}
