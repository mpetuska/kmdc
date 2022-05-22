package dev.petuska.kmdc.radio

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCInitEffect
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

@JsModule("@material/radio/mdc-radio.scss")
public external val MDCRadioStyle: dynamic

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-radio)
 */
@MDCDsl
@Composable
public fun MDCRadio(
  checked: Boolean,
  touch: Boolean = false,
  disabled: Boolean = false,
  label: String? = null,
  attrs: MDCAttrs<InputAttrsScope<Boolean>>? = null,
) {
  MDCRadioBody(checked = checked, touch = touch, label = label, disabled = disabled, attrs = attrs)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-radio)
 */
@MDCDsl
@Composable
public fun MDCFormFieldScope.MDCRadio(
  checked: Boolean,
  touch: Boolean = false,
  disabled: Boolean = false,
  label: String? = null,
  attrs: MDCAttrs<InputAttrsScope<Boolean>>? = null,
) {
  MDCRadioBody(checked = checked, touch = touch, disabled = disabled, label = label, attrs = {
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
  touch: Boolean,
  disabled: Boolean = false,
  label: String? = null,
  attrs: MDCAttrs<InputAttrsScope<Boolean>>? = null,
) {
  MDCRadioStyle
  val radioId = rememberUniqueDomElementId()

  Div(attrs = {
    classes("mdc-radio")
    if (disabled) classes("mdc-radio--disabled")
    if (touch) classes("mdc-radio--touch")
  }) {
    MDCInitEffect(MDCRadioModule.MDCRadio::attachTo)
    Input(type = InputType.Radio, attrs = {
      classes("mdc-radio__native-control") // This must precede `checked()`
      checked(checked) // This must follow `classes(...)`
      id(radioId)
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
  label?.let {
    Label(forId = radioId, attrs = { id("$radioId-label") }) { Text(it) }
  }
}
