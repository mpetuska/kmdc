package dev.petuska.kmdc.select.anchor

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.line.ripple.MDCLineRippleLayout
import dev.petuska.kmdc.select.MDCSelectHelperTextIdLocal
import dev.petuska.kmdc.select.MDCSelectScope
import dev.petuska.kmdc.select.MDCSelectType
import dev.petuska.kmdc.select.MDCSelectTypeLocal
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

public interface MDCSelectAnchorScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-select)
 */
@MDCDsl
@Composable
public fun MDCSelectScope.Anchor(
  label: String,
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCSelectAnchorScope>? = null,
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
      Span(attrs = {
        id(labelId)
        classes("mdc-floating-label")
      }) { Text(label) }
    }

    when (type) {
      MDCSelectType.Filled -> {
        Span(attrs = { classes("mdc-select__ripple") })
        floatingLabel()
      }
      MDCSelectType.Outlined -> Span(attrs = { classes("mdc-notched-outline") }) {
        Span(attrs = { classes("mdc-notched-outline__leading") })
        Span(attrs = { classes("mdc-notched-outline__notch") }) { floatingLabel() }
        Span(attrs = { classes("mdc-notched-outline__trailing") })
      }
    }
    Span(attrs = { classes("mdc-select__selected-text-container") }) {
      Span(attrs = {
        id(selectedId)
        classes("mdc-select__selected-text")
      })
    }
    applyContent(content)
    DownDownIcon()
    if (type == MDCSelectType.Filled) MDCLineRippleLayout()
  }
}
