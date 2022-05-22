package dev.petuska.kmdc.form.field

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

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
  public fun DisposableEffectScope.setInput(htmlInput: Element, mdcInput: MDCFormFieldModule.MDCFormFieldInput) {
    htmlInput.parentElement?.let {
      if (it.classList.contains("mdc-form-field")) {
        it.mdc<MDCFormFieldModule.MDCFormField> { input = mdcInput }
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
    MDCInitEffect(MDCFormFieldModule::MDCFormField)
    content?.let { MDCFormFieldScope(this).it() }
  }
}
