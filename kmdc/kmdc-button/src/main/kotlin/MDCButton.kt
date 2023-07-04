package dev.petuska.kmdc.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.elevation.MDCElevationOverlay
import dev.petuska.kmdc.ripple.MDCRippleLayout
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.Element
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLButtonElement

@JsModule("@material/button/mdc-button.scss")
private external val Style: dynamic

public enum class MDCButtonType(public vararg val classes: String) {
  Text, Outlined("mdc-button--outlined"), Raised("mdc-button--raised"), Unelevated("mdc-button--unelevated")
}

public enum class MDCButtonIconType(public vararg val classes: String) {
  None, Leading("mdc-button--icon-leading"), Trailing("mdc-button--icon-trailing")
}

public interface MDCButtonScope<T : Element> : ElementScope<T>

private val MDCButtonTypeLocal = strictCompositionLocalOf<MDCButtonType>()

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-button)
 */
@MDCContentDsl
@Composable
public fun MDCButton(
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  touch: Boolean = false,
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  content: MDCContent<MDCButtonScope<HTMLButtonElement>>? = null
) {
  Button(
    attrs = {
      classes("mdc-button")
      classes(type.classes)
      classes(icon.classes)
      if (touch) classes("mdc-button--touch")
      attrs?.invoke(this)
    }
  ) {
    CompositionLocalProvider(MDCButtonTypeLocal provides type) {
      MDCButtonContent(content)
    }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-button)
 */
@MDCContentDsl
@Composable
public fun MDCButton(
  text: String,
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  touch: Boolean = false,
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
) {
  MDCButton(type, icon, touch, attrs) {
    Label(text)
  }
}

@Composable
@KMDCInternalAPI
internal fun <E : Element, S : ElementScope<E>> ElementScope<E>.MDCButtonContent(
  content: MDCContent<S>? = null
) {
  Style
  val type = MDCButtonTypeLocal.current
  MDCElevationOverlay()
  Span(attrs = { classes("mdc-button__ripple") })
  Span(attrs = { classes("mdc-button__focus-ring") })
  MDCRippleLayout(keys = arrayOf(type))
  applyContent(content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-button)
 */
@MDCContentDsl
@Composable
public fun MDCButtonLink(
  href: String? = null,
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  touch: Boolean = false,
  attrs: MDCAttrsRaw<HTMLAnchorElement>? = null,
  content: MDCContent<MDCButtonScope<HTMLAnchorElement>>? = null
) {
  A(
    href = href,
    attrs = {
      classes("mdc-button")
      classes(type.classes)
      classes(icon.classes)
      if (touch) classes("mdc-button--touch")
      attrs?.invoke(this)
    }
  ) {
    CompositionLocalProvider(MDCButtonTypeLocal provides type) {
      MDCButtonContent(content)
    }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-button)
 */
@MDCContentDsl
@Composable
public fun MDCButtonLink(
  text: String,
  href: String? = null,
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  touch: Boolean = false,
  attrs: MDCAttrsRaw<HTMLAnchorElement>? = null,
) {
  MDCButtonLink(
    href = href,
    type = type,
    icon = icon,
    touch = touch,
    attrs = attrs
  ) { Label(text) }
}
