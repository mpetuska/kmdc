package dev.petuska.kmdc.checkbox

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.form.field.MDCFormField
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.svg.Path
import org.jetbrains.compose.web.svg.Svg
import org.w3c.dom.HTMLDivElement

@JsModule("@material/checkbox/mdc-checkbox.scss")
public external val Style: dynamic

public interface MDCCheckboxScope : ElementScope<HTMLDivElement>

@MDCContentDsl
@Composable
public fun MDCCheckbox(
  checked: Boolean?,
  disabled: Boolean = false,
  indeterminate: Boolean = false,
  touch: Boolean = false,
  label: String? = null,
  attrs: MDCAttrs<InputAttrsScope<Boolean>>? = null,
) {
  val checkboxId = rememberUniqueDomElementId()
  MDCCheckboxLayoutFull(
    id = checkboxId,
    checked = checked == true,
    disabled = disabled,
    touch = touch,
    attrs = attrs,
  ) {
    val formField = localMDC<MDCFormField>()
    MDCProvider(::MDCCheckbox) {
      MDCSideEffect(formField, onDispose = { formField?.input = null }) {
        formField?.input = this
      }
      MDCStateEffect(indeterminate, MDCCheckbox::indeterminate)
      MDCStateEffect(disabled, MDCCheckbox::disabled)
      it()
    }
  }
  label?.let {
    Label(forId = checkboxId, attrs = { id("$checkboxId-label") }) { Text(it) }
  }
}

@Composable
@KMDCInternalAPI
public fun MDCCheckboxLayoutFull(
  id: String,
  checked: Boolean = false,
  touch: Boolean = false,
  disabled: Boolean = false,
  attrs: MDCAttrs<InputAttrsScope<Boolean>>? = null,
  init: MDCComponentInit<MDCCheckboxScope> = { it() },
) {
  MDCCheckboxLayout(
    touch = touch,
  ) {
    unsafeCast<MDCCheckboxScope>().init {
      MDCCheckboxInput(
        checked = checked,
        disabled = disabled,
        attrs = {
          id(id)
          applyAttrs(attrs)
        }
      )
      MDCCheckboxBackground()
      MDCCheckboxRipple()
    }
  }
}

@Composable
@KMDCInternalAPI
public fun MDCCheckboxLayout(
  touch: Boolean = false,
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCCheckboxScope>? = null,
) {
  Style
  Div(
    attrs = {
      classes("mdc-checkbox")
      if (touch) classes("mdc-checkbox--touch")
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}

@MDCContentDsl
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
@MDCContentDsl
@Composable
public fun MDCCheckboxScope.MDCCheckboxBackground(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
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

@MDCContentDsl
@Composable
public fun MDCCheckboxScope.MDCCheckboxRipple(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null
) {
  Div(attrs = {
    classes("mdc-checkbox__ripple")
    applyAttrs(attrs)
  })
}
