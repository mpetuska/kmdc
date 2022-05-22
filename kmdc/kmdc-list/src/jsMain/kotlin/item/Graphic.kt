package dev.petuska.kmdc.list.item

import androidx.compose.runtime.*
import dev.petuska.kmdc.checkbox.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.radio.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

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
