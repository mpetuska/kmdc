package dev.petuska.kmdc.radio

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.form.field.MDCFormField
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement

@JsModule("@material/radio/mdc-radio.scss")
public external val Style: dynamic

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-radio)
 */
@MDCContentDsl
@Composable
public fun MDCRadio(
  checked: Boolean,
  touch: Boolean = false,
  disabled: Boolean = false,
  label: String? = null,
  attrs: MDCAttrs<InputAttrsScope<Boolean>>? = null,
) {
  val radioId = rememberUniqueDomElementId()
  MDCRadioLayout(
    id = radioId,
    checked = checked,
    touch = touch,
    disabled = disabled,
    attrs = attrs,
  ) {
    val formField = localMDC<MDCFormField>()
    MDCProvider(::MDCRadio) {
      MDCSideEffect(formField, onDispose = { formField?.input = null }) {
        formField?.input = this
      }
      applyContent(it)
    }
  }
  label?.let {
    Label(forId = radioId, attrs = { id("$radioId-label") }) { Text(it) }
  }
}

@Composable
@KMDCInternalAPI
public fun MDCRadioLayout(
  id: String,
  checked: Boolean,
  touch: Boolean,
  disabled: Boolean,
  attrs: MDCAttrs<InputAttrsScope<Boolean>>?,
  init: MDCComponentInit<ElementScope<HTMLDivElement>> = { it() },
) {
  Style
  Div(attrs = {
    classes("mdc-radio")
    if (disabled) classes("mdc-radio--disabled")
    if (touch) classes("mdc-radio--touch")
  }) {
    init {
      Input(type = InputType.Radio, attrs = {
        classes("mdc-radio__native-control") // This must precede `checked()`
        checked(checked) // This must follow `classes(...)`
        id(id)
        if (disabled) disabled()
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
  }
}
