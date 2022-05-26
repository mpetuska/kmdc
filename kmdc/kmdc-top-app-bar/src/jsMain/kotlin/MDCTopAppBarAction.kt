package dev.petuska.kmdc.top.app.bar

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.icon.button.*
import org.w3c.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCContentDsl
@Composable
public fun MDCTopAppBarSectionScope.MDCTopAppBarActionButton(
  on: Boolean = false,
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  content: MDCContentRaw<HTMLButtonElement>? = null,
) {
  MDCIconButton(
    on = on,
    attrs = {
      classes("mdc-top-app-bar__action-icon")
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
public fun MDCTopAppBarSectionScope.MDCTopAppBarActionLink(
  on: Boolean = false,
  attrs: MDCAttrsRaw<HTMLAnchorElement>? = null,
  content: MDCContentRaw<HTMLAnchorElement>? = null
) {
  MDCIconLink(
    on = on,
    attrs = {
      classes("mdc-top-app-bar__action-icon")
      attrs?.invoke(this)
    },
    content = content
  )
}
