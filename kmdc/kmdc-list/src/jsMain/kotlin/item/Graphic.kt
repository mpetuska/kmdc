package dev.petuska.kmdc.list.item

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentRaw
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.radio.MDCRadio
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemScope<*>.Graphic(
  attrs: MDCAttrs<AttrsScope<HTMLSpanElement>>? = null,
  content: MDCContentRaw<HTMLSpanElement>? = null,
) {
  Span(attrs = {
    classes("mdc-deprecated-list-item__graphic")
    attrs?.invoke(this)
  }, content = content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemScope<*>.RadioGraphic(
  checked: Boolean,
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
) {
  Graphic(attrs) {
    MDCRadio(checked = checked)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListItemScope<*>.CheckboxGraphic(
  checked: Boolean,
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
) {
  Graphic(attrs) {
    MDCCheckbox(checked = checked)
  }
}
