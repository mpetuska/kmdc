package dev.petuska.kmdc.select.menu

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.list.MDCListScope
import dev.petuska.kmdc.menu.MDCMenuAttrsScope
import dev.petuska.kmdc.menu.MDCMenuLayout
import dev.petuska.kmdc.select.MDCSelectScope
import org.w3c.dom.HTMLUListElement

// TODO figure out why extending MenuScope is crashing
public interface MDCSelectMenuScope : MDCListScope<HTMLUListElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-select)
 */
@MDCContentDsl
@Composable
public fun MDCSelectScope.Menu(
  fullWidth: Boolean = true,
  fixed: Boolean = false,
  singleSelect: Boolean = true,
  attrs: MDCAttrs<MDCMenuAttrsScope>? = null,
  content: MDCContent<MDCSelectMenuScope>? = null,
) {
  MDCMenuLayout(
    singleSelect = singleSelect,
    fullWidth = fullWidth,
    fixed = fixed,
    attrs = {
      classes("mdc-select__menu")
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}
