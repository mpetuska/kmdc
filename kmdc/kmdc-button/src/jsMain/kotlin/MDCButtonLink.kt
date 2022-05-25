package dev.petuska.kmdc.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.classes
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.w3c.dom.HTMLAnchorElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-button)
 */
@MDCDsl
@Composable
public fun MDCButtonLink(
  href: String? = null,
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  touch: Boolean = false,
  attrs: AttrBuilderContext<HTMLAnchorElement>? = null,
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
    MDCButtonContent(content)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-button)
 */
@MDCDsl
@Composable
public fun MDCButtonLink(
  text: String,
  href: String? = null,
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  touch: Boolean = false,
  attrs: AttrBuilderContext<HTMLAnchorElement>? = null,
) {
  MDCButtonLink(
    href = href,
    type = type,
    icon = icon,
    touch = touch,
    attrs = attrs
  ) { Label(text) }
}
