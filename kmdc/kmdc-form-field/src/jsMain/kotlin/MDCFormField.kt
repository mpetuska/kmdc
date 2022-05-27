package dev.petuska.kmdc.form.field

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement

@JsModule("@material/form-field/mdc-form-field.scss")
public external val Style: dynamic

public enum class MDCFormFieldAlign(public vararg val classes: String) {
  Start, End("mdc-form-field--align-end")
}

public interface MDCFormFieldScope : ElementScope<HTMLElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-form-field)
 */
@MDCContentDsl
@Composable
public fun MDCFormField(
  align: MDCFormFieldAlign = MDCFormFieldAlign.Start,
  noWrap: Boolean = false,
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCFormFieldScope>? = null,
) {
  Style

  Div(attrs = {
    classes("mdc-form-field")
    classes(align.classes)
    if (noWrap) classes("mdc-form-field--nowrap")
    applyAttrs(attrs)
  }) {
    MDCProvider(::MDCFormField) {
      applyContent(content)
    }
  }
}
