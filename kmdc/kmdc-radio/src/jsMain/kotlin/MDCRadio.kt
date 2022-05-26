package dev.petuska.kmdc.radio

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.form.field.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.attributes.builders.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

@JsModule("@material/radio/mdc-radio.scss")
public external val MDCRadioStyle: dynamic

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
  MDCRadioBody(checked = checked, touch = touch, label = label, disabled = disabled, attrs = attrs)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-radio)
 */
@MDCContentDsl
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
      it.mdc<MDCRadio> { setInput(it, this) }
      onDispose { }
    }
    attrs?.invoke(this)
  })
}

@MDCContentDsl
@Composable
private fun MDCRadioBody(
  checked: Boolean,
  touch: Boolean,
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
    MDCProvider(::MDCRadio) {
      it()
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
  init: @Composable ElementScope<HTMLDivElement>.(content: @Composable () -> Unit) -> Unit = { it() },
) {
  MDCRadioStyle
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
