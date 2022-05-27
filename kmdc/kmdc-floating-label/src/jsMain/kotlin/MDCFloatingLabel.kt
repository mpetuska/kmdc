package dev.petuska.kmdc.floating.label

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

@JsModule("@material/floating-label/mdc-floating-label.scss")
private external val Style: dynamic

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-floating-label)
 */
@MDCContentDsl
@Composable
public fun MDCFloatingLabel(
  id: String,
  float: Boolean = false,
  required: Boolean = false,
  shake: Boolean = false,
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContentRaw<HTMLSpanElement>? = null
) {
  MDCFloatingLabelLayout(
    id = id,
    float = float,
    required = required,
    shake = shake,
    attrs = attrs,
  ) {
    MDCProvider(::MDCFloatingLabel) {
      applyContent(content)
    }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-floating-label)
 */
@MDCContentDsl
@Composable
public fun MDCFloatingLabel(
  text: String,
  id: String,
  float: Boolean = false,
  required: Boolean = false,
  shake: Boolean = false,
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
) {
  MDCFloatingLabel(
    id = id,
    float = float,
    required = required,
    shake = shake,
    attrs = attrs,
  ) { Text(text) }
}

@Composable
@KMDCInternalAPI
public fun MDCFloatingLabelLayout(
  id: String,
  float: Boolean,
  required: Boolean,
  shake: Boolean,
  attrs: MDCAttrsRaw<HTMLSpanElement>?,
  content: MDCContentRaw<HTMLSpanElement>?,
) {
  Style
  Span(
    attrs = {
      classes("mdc-floating-label")
      if (float) classes("mdc-floating-label--float-above")
      if (required) classes("mdc-floating-label--required")
      if (shake) classes("mdc-floating-label--shake")
      id(id)
      applyAttrs(attrs)
    },
    content = content,
  )
}
