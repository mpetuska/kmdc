package dev.petuska.kmdc.list.item

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.checkbox.MDCCheckboxLayoutFull
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.MDCContentRaw
import dev.petuska.kmdc.radio.MDCRadioLayout
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
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
@MDCContentDsl
@Composable
public fun MDCListItemScope<*>.RadioGraphic(
  checked: Boolean,
  id: String,
  touch: Boolean = false,
  disabled: Boolean = false,
  attrs: MDCAttrs<InputAttrsScope<Boolean>>? = null,
) {
  Graphic {
    MDCRadioLayout(
      id = id,
      checked = checked,
      touch = touch,
      disabled = disabled,
      attrs = attrs,
    )
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListItemScope<*>.CheckboxGraphic(
  checked: Boolean,
  id: String,
  touch: Boolean = false,
  disabled: Boolean = false,
  attrs: MDCAttrs<InputAttrsScope<Boolean>>? = null,
) {
  Graphic {
    MDCCheckboxLayoutFull(
      checked = checked,
      id = id,
      touch = touch,
      disabled = disabled,
      attrs = attrs,
    )
  }
}
