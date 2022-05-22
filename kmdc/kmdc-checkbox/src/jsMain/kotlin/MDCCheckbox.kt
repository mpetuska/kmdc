package dev.petuska.kmdc.checkbox

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.form.field.*
import org.jetbrains.compose.web.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.attributes.builders.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.svg.*
import org.w3c.dom.*

@JsModule("@material/checkbox/mdc-checkbox.scss")
public external val MDCCheckboxStyles: dynamic

public interface MDCCheckboxScope : ElementScope<HTMLDivElement>

@MDCDsl
@Composable
public fun MDCCheckbox(
  disabled: Boolean = false,
  indeterminate: Boolean = false,
  touch: Boolean = false,
  attrs: AttrsBuilder<HTMLDivElement>? = null,
  content: MDCContent<MDCCheckboxScope>? = null,
) {
  MDCCheckboxStyles

  Div(attrs = {
    classes("mdc-checkbox")
    if (touch) classes("mdc-checkbox--touch")
    applyAttrs(attrs)
  }) {
    MDCInitEffect(MDCCheckboxModule::MDCCheckbox)
    MDCStateEffect(indeterminate, MDCCheckboxModule.MDCCheckbox::indeterminate)
    MDCStateEffect(disabled, MDCCheckboxModule.MDCCheckbox::disabled)
    applyContent(content)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-checkbox)
 */
@MDCDsl
@Composable
public fun MDCCheckbox(
  checked: Boolean?,
  disabled: Boolean = false,
  touch: Boolean = false,
  label: String? = null,
  attrs: MDCAttrs<InputAttrsScope<Boolean>>? = null,
) {
  val checkboxId = rememberUniqueDomElementId()
  MDCCheckbox(
    touch = touch,
    disabled = disabled,
    indeterminate = checked == null,
  ) {
    MDCCheckboxInput(
      checked = checked,
      disabled = disabled,
      attrs = {
        id(checkboxId)
        applyAttrs(attrs)
      }
    )
    MDCCheckboxBackground()
    MDCCheckboxRipple()
  }
  label?.let {
    Label(forId = checkboxId, attrs = { id("$checkboxId-label") }) { Text(it) }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-checkbox)
 */
@MDCDsl
@Composable
public fun MDCFormFieldScope.MDCCheckbox(
  checked: Boolean?,
  disabled: Boolean = false,
  touch: Boolean = false,
  label: String? = null,
  attrs: MDCAttrs<InputAttrsScope<Boolean>>? = null,
) {
  val checkboxId = rememberUniqueDomElementId()
  MDCCheckbox(
    touch = touch,
    disabled = disabled,
    indeterminate = checked == null,
  ) {
    MDCCheckboxInput(
      checked = checked,
      disabled = disabled,
      attrs = {
        ref {
          it.mdc<MDCCheckboxModule.MDCCheckbox> { setInput(it, this) }
          onDispose { }
        }
        id(checkboxId)
        applyAttrs(attrs)
      }
    )
    MDCCheckboxBackground()
    MDCCheckboxRipple()
  }
  label?.let {
    Label(forId = checkboxId, attrs = { id("$checkboxId-label") }) { Text(it) }
  }
}

@MDCDsl
@Composable
public fun MDCCheckboxScope.MDCCheckboxInput(
  checked: Boolean?,
  disabled: Boolean = false,
  attrs: MDCAttrs<InputAttrsScope<Boolean>>? = null,
) {
  // WORKAROUND https://github.com/JetBrains/compose-jb/issues/1528
  //     We cannot use the controlled CheckboxInput directly, but the workaround is functionally equivalent.
  Input(type = InputType.Checkbox, attrs = {
    classes("mdc-checkbox__native-control") // This must precede `checked()`
    checked(checked == true) // This must follow `classes(...)`
    if (disabled) disabled()
    if (checked == null) attr("data-indeterminate", "true")
    applyAttrs(attrs)
  })
}

@OptIn(ExperimentalComposeWebSvgApi::class)
@MDCDsl
@Composable
public fun MDCCheckboxScope.MDCCheckboxBackground(
  attrs: AttrsBuilder<HTMLDivElement>? = null,
) {
  Div(attrs = {
    classes("mdc-checkbox__background")
    applyAttrs(attrs)
  }) {
    Svg(attrs = {
      classes("mdc-checkbox__checkmark")
      attr("viewBox", "0 0 24 24")
    }) {
      Path(
        d = "M1.73,12.91 8.1,19.28 22.79,4.59",
        attrs = {
          classes("mdc-checkbox__checkmark-path")
          attr("fill", "none")
        }
      )
    }
    Div(attrs = { classes("mdc-checkbox__mixedmark") })
  }
}

@MDCDsl
@Composable
public fun MDCCheckboxScope.MDCCheckboxRipple(
  attrs: AttrsBuilder<HTMLDivElement>? = null
) {
  Div(attrs = {
    classes("mdc-checkbox__ripple")
    applyAttrs(attrs)
  })
}
