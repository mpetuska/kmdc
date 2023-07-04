package dev.petuska.kmdc.select.anchor

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.floating.label.MDCFloatingLabelLayout
import dev.petuska.kmdc.line.ripple.MDCLineRippleLayout
import dev.petuska.kmdc.notched.outline.Leading
import dev.petuska.kmdc.notched.outline.MDCNotchedOutlineLayout
import dev.petuska.kmdc.notched.outline.Notch
import dev.petuska.kmdc.notched.outline.Trailing
import dev.petuska.kmdc.select.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement

public interface MDCSelectAnchorScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-select)
 */
@MDCContentDsl
@Composable
public fun MDCSelectScope.Anchor(
  label: String,
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  leadingIcon: MDCContent<MDCSelectAnchorScope>? = null,
) {
  val id = rememberUniqueDomElementId("anchor")
  val labelId = "$id-label"
  val selectedId = "$id-selected-text"
  val type = MDCSelectTypeLocal.current
  val helperTextId = MDCSelectHelperTextIdLocal.current
  Div(
    attrs = {
      classes("mdc-select__anchor")
      role("button")
      aria("haspopup", "listbox")
      aria("labelledby", "$labelId $selectedId")
      if (helperTextId != null) {
        aria("controls", helperTextId)
        aria("describedby", helperTextId)
      }
      applyAttrs(attrs)
    }
  ) {
    val floatingLabel = @Composable {
      MDCFloatingLabelLayout(id = labelId) { Text(label) }
    }

    when (type) {
      MDCSelectType.Filled -> {
        Span(attrs = { classes("mdc-select__ripple") })
        floatingLabel()
      }
      MDCSelectType.Outlined -> MDCNotchedOutlineLayout {
        Leading()
        Notch { floatingLabel() }
        Trailing()
      }
    }
    applyContent(leadingIcon)
    Span(attrs = { classes("mdc-select__selected-text-container") }) {
      Span(attrs = {
        id(selectedId)
        classes("mdc-select__selected-text")
      })
    }
    DownDownIcon()
    if (type == MDCSelectType.Filled) MDCLineRippleLayout()
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-select)
 */
@MDCContentDsl
@Composable
public fun MDCSelectAnchorScope.LeadingIcon(
  clickable: Boolean = true,
  attrs: MDCAttrsRaw<HTMLElement>? = null,
  content: MDCContentRaw<HTMLElement>? = null,
) {
  I(
    attrs = {
      classes("mdc-select__icon")
      if (clickable) {
        tabIndex(0)
        role("button")
      }
      applyAttrs(attrs)
    },
  ) {
    MDCProvider(::MDCSelectIcon, clickable) {
      applyContent(content)
    }
  }
}
