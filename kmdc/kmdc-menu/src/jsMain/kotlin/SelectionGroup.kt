package dev.petuska.kmdc.menu

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu)
 */
@MDCDsl
@Composable
public fun MDCMenuScope.SelectionGroup(
  attrs: MDCAttrsRaw<HTMLUListElement>? = null,
  content: MDCContent<MDCMenuScope>? = null,
) {
  Li {
    Ul(
      attrs = {
        classes("mdc-menu__selection-group")
        applyAttrs(attrs)
      }, content = content.reinterpret()
    )
  }
}
