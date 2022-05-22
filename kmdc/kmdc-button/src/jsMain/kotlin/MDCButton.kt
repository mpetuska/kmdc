package dev.petuska.kmdc.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyContent
import dev.petuska.kmdc.core.classes
import dev.petuska.kmdc.elevation.MDCElevationOverlay
import dev.petuska.kmdc.ripple.MDCRipple
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLButtonElement

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
