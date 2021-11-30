package dev.petuska.kmdc.form.field

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffectScope
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.mdc
import dev.petuska.kmdc.ripple.MDCRippleModule
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement

@JsModule("@material/form-field/dist/mdc.form-field.css")
public external val MDCFormFieldStyle: dynamic

@JsModule("@material/form-field")
public external object MDCFormFieldModule {
  public class MDCFormField(element: Element) {
    public companion object {
      public fun attachTo(element: Element): MDCFormField
    }

    public var input: MDCFormFieldInput
  }

  public interface MDCFormFieldInput {
    public val ripple: MDCRippleModule.MDCRipple?
  }
}

public data class MDCFormFieldOpts(
  public var align: Align = Align.Start,
  public var nowrap: Boolean = false,
) {
  public enum class Align(public vararg val classes: String) {
    Start, End("mdc-form-field--align-end")
  }
}

public class MDCFormFieldScope(scope: ElementScope<HTMLElement>) : ElementScope<HTMLElement> by scope {
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-form-field)
 */
@MDCDsl
@Composable
public fun MDCFormField(
  opts: Builder<MDCFormFieldOpts>? = null,
  attrs: Builder<AttrsBuilder<HTMLDivElement>>? = null,
  content: ComposableBuilder<MDCFormFieldScope>? = null,
) {
  MDCFormFieldStyle
  val options = MDCFormFieldOpts().apply { opts?.invoke(this) }

  Div(attrs = {
    classes("mdc-form-field", *options.align.classes)
    if (options.nowrap) classes("mdc-form-field--nowrap")
    ref {
      it.mdc = MDCFormFieldModule.MDCFormField.attachTo(it)
      onDispose {}
    }
    attrs?.invoke(this)
  }) {
    content?.let { MDCFormFieldScope(this).it() }
  }
}
