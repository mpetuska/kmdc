package dev.petuska.kmdc.top.app.bar

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.icon.button.MDCIconButton
import dev.petuska.kmdc.icon.button.MDCIconButtonAttrsScope
import dev.petuska.kmdc.icon.button.MDCIconButtonScope
import dev.petuska.kmdc.icon.button.MDCIconLink
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLButtonElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCContentDsl
@Composable
public fun MDCTopAppBarSectionScope.NavButton(
  touch: Boolean = false,
  attrs: MDCAttrs<MDCIconButtonAttrsScope<HTMLButtonElement>>? = null,
  content: MDCContent<MDCIconButtonScope<HTMLButtonElement>>? = null
) {
  MDCIconButton(
    touch = touch,
    attrs = {
      classes("mdc-top-app-bar__navigation-icon")
      attrs?.invoke(this)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCContentDsl
@Composable
public fun MDCTopAppBarSectionScope.NavLink(
  touch: Boolean = false,
  attrs: MDCAttrs<MDCIconButtonAttrsScope<HTMLAnchorElement>>? = null,
  content: MDCContent<MDCIconButtonScope<HTMLAnchorElement>>? = null
) {
  MDCIconLink(
    touch = touch,
    attrs = {
      classes("mdc-top-app-bar__navigation-icon")
      attrs?.invoke(this)
    },
    content = content
  )
}
