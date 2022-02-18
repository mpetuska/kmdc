package dev.petuska.kmdc.radio

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.initialiseMDC
import dev.petuska.kmdc.core.mdc
import dev.petuska.kmdc.core.rememberUniqueDomElementId
import dev.petuska.kmdc.form.field.MDCFormFieldScope
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text

@JsModule("@material/radio/dist/mdc.radio.css")
public external val MDCRadioStyle: dynamic

public data class MDCRadioOpts(
  public var disabled: Boolean = false,
  public var label: String? = null,
)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-radio)
 */
@MDCDsl
@Composable
public fun MDCRadio(
  checked: Boolean,
  opts: Builder<MDCRadioOpts>? = null,
  attrs: Builder<InputAttrsScope<Boolean>>? = null,
) {
  MDCRadioBody(checked, opts, attrs)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-radio)
 */
@MDCDsl
@Composable
public fun MDCFormFieldScope.MDCRadio(
  checked: Boolean,
  opts: Builder<MDCRadioOpts>? = null,
  attrs: Builder<InputAttrsScope<Boolean>>? = null,
) {
  MDCRadioBody(checked, opts, attrs = {
    ref {
      it.mdc<MDCRadioModule.MDCRadio> { setInput(it, this) }
      onDispose { }
    }
    attrs?.invoke(this)
  })
}

@MDCDsl
@Composable
private fun MDCRadioBody(
  checked: Boolean,
  opts: Builder<MDCRadioOpts>? = null,
  attrs: Builder<InputAttrsScope<Boolean>>? = null,
) {
  MDCRadioStyle
  val options = MDCRadioOpts().apply { opts?.invoke(this) }
  val radioId = rememberUniqueDomElementId()

  Div(attrs = {
    classes("mdc-radio")
    if (options.disabled) classes("mdc-radio--disabled")
    initialiseMDC(MDCRadioModule.MDCRadio::attachTo)
  }) {
    Input(type = InputType.Radio, attrs = {
      classes("mdc-radio__native-control") // This must precede `checked()`
      checked(checked) // This must follow `classes(...)`
      id(radioId)
      if (options.disabled) disabled()
      attrs?.invoke(this)
    })
    Div(attrs = {
      classes("mdc-radio__background")
    }) {
      Div(attrs = { classes("mdc-radio__outer-circle") })
      Div(attrs = { classes("mdc-radio__inner-circle") })
    }
    Div(attrs = { classes("mdc-radio__ripple") })
  }
  options.label?.let {
    Label(forId = radioId, attrs = { id("$radioId-label") }) { Text(it) }
  }
}
