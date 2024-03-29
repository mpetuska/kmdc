package dev.petuska.kmdc.select.menu

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.list.item.Graphic
import dev.petuska.kmdc.list.item.ListItem
import dev.petuska.kmdc.list.item.MDCListItemScope
import dev.petuska.kmdc.list.item.Text
import dev.petuska.kmdc.select.MDCSelect
import dev.petuska.kmdc.select.MDCSelectLeadingIconLocal
import org.w3c.dom.HTMLLIElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-select)
 */
@MDCContentDsl
@Composable
public fun MDCSelectMenuScope.SelectItem(
  value: String,
  disabled: Boolean = false,
  selected: Boolean = false,
  activated: Boolean = false,
  attrs: MDCAttrsRaw<HTMLLIElement>? = null,
  content: MDCContent<MDCListItemScope<HTMLLIElement>>,
) {
  ListItem(
    disabled = disabled,
    selected = selected,
    activated = activated,
    attrs = {
      data("value", value)
      applyAttrs(attrs)
    },
    content = content,
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-select)
 */
@MDCContentDsl
@Composable
public fun MDCSelectMenuScope.SelectItem(
  text: String,
  value: String = text,
  disabled: Boolean = false,
  selected: Boolean = false,
  activated: Boolean = false,
  attrs: MDCAttrsRaw<HTMLLIElement>? = null,
) {
  val leadingIcon = MDCSelectLeadingIconLocal.current
  SelectItem(
    value = value,
    disabled = disabled,
    selected = selected,
    activated = activated,
    attrs = attrs,
  ) {
    if (leadingIcon) Graphic()
    Text(text)
    MDCSideEffect(onDispose = MDCSelect::layoutOptions) {
      layoutOptions()
    }
  }
}
