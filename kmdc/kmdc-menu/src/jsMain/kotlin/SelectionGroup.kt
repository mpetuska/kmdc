package dev.petuska.kmdc.menu

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.reinterpret
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Ul
import org.w3c.dom.HTMLUListElement

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
