package dev.petuska.kmdc.top.app.bar

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.icon.button.MDCIconButton
import dev.petuska.kmdc.icon.button.MDCIconButtonOpts
import dev.petuska.kmdc.icon.button.MDCIconLink
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLButtonElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCDsl
@Composable
public fun MDCTopAppBarSectionScope.MDCTopAppBarNavigationButton(
  opts: MDCAttrs<MDCIconButtonOpts>? = null,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: ContentBuilder<HTMLButtonElement>? = null,
) {
  MDCIconButton(
    opts = opts,
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
@MDCDsl
@Composable
public fun MDCTopAppBarSectionScope.MDCTopAppBarNavigationLink(
  opts: MDCAttrs<MDCIconButtonOpts>? = null,
  attrs: AttrBuilderContext<HTMLAnchorElement>? = null,
  content: ContentBuilder<HTMLAnchorElement>? = null,
) {
  MDCIconLink(
    opts = opts,
    attrs = {
      classes("mdc-top-app-bar__navigation-icon")
      attrs?.invoke(this)
    },
    content = content
  )
}
