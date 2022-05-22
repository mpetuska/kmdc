package dev.petuska.kmdc.menu

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.role
import dev.petuska.kmdc.list.item.ListItem
import dev.petuska.kmdc.list.item.MDCListItemScope
import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.HTMLLIElement

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
