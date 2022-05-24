package dev.petuska.kmdc.menu

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.list.item.*
import org.jetbrains.compose.web.attributes.*
import org.w3c.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu)
 */
@MDCDsl
@Composable
public fun MDCMenuScope.MenuItem(
  disabled: Boolean = false,
  selected: Boolean = false,
  activated: Boolean = false,
  attrs: MDCAttrs<AttrsScope<HTMLLIElement>>? = null,
  content: MDCContent<MDCListItemScope<HTMLLIElement>>? = null,
) {
  ListItem(
    attrs = {
      role("menuitem")
      applyAttrs(attrs)
    },
    disabled = disabled,
    selected = selected,
    activated = activated,
    content = content
  )
}
