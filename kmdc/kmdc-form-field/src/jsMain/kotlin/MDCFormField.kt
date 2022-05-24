package dev.petuska.kmdc.form.field

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffectScope
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement

@JsModule("@material/form-field/dist/mdc.form-field.css")
public external val MDCFormFieldStyle: dynamic

public data class MDCFormFieldOpts(
  public var align: Align = Align.Start,
  public var nowrap: Boolean = false,
) {
  public enum class Align(public vararg val classes: String) {
    Start, End("mdc-form-field--align-end")
  }
}

public class MDCFormFieldScope(scope: ElementScope<HTMLElement>) : ElementScope<HTMLElement> by scope {
  @KMDCInternalAPI
  public fun DisposableEffectScope.setInput(htmlInput: Element, mdcInput: MDCFormFieldInput) {
    htmlInput.parentElement?.let {
      if (it.classList.contains("mdc-form-field")) {
        it.mdc<MDCFormField> { input = mdcInput }
      } else {
        setInput(it, mdcInput)
      }
    }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-form-field)
 */
@MDCDsl
@Composable
public fun MDCFormField(
  opts: MDCAttrs<MDCFormFieldOpts>? = null,
  attrs: MDCAttrs<AttrsScope<HTMLDivElement>>? = null,
  content: MDCContent<MDCFormFieldScope>? = null,
) {
  MDCFormFieldStyle
  val options = MDCFormFieldOpts().apply { opts?.invoke(this) }

  Div(attrs = {
    classes("mdc-form-field")
    classes(options.align.classes)
    if (options.nowrap) classes("mdc-form-field--nowrap")
    attrs?.invoke(this)
  }) {
    MDCInitEffect(::MDCFormField)
    content?.let { MDCFormFieldScope(this).it() }
  }
}
