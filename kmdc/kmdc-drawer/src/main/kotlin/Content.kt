package dev.petuska.kmdc.drawer

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.MDCContentRaw
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-drawer)
 */
@MDCContentDsl
@Composable
public fun MDCDrawerScope.Content(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContentRaw<HTMLDivElement>? = null
) {
  Div(
    attrs = {
      classes("mdc-drawer__content")
      attrs?.invoke(this)
    },
    content = content,
  )
}
