package dev.petuska.kmdc.textfield

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.floating.label.MDCFloatingLabelLayout
import dev.petuska.kmdc.line.ripple.MDCLineRipple
import dev.petuska.kmdc.notched.outline.Leading
import dev.petuska.kmdc.notched.outline.MDCNotchedOutlineLayout
import dev.petuska.kmdc.notched.outline.Notch
import dev.petuska.kmdc.notched.outline.Trailing
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.maxLength
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLLabelElement

@JsModule("@material/textfield/mdc-text-field.scss")
public external val Style: dynamic

public enum class MDCTextFieldType(public vararg val classes: String) {
  Filled("mdc-text-field--filled"), Outlined("mdc-text-field--outlined")
}

public interface MDCTextFieldScope : ElementScope<HTMLLabelElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-textfield)
 */
@MDCContentDsl
@Composable
public fun MDCTextField(
  value: String,
  type: MDCTextFieldType = MDCTextFieldType.Filled,
  disabled: Boolean = false,
  label: String? = null,
  helperText: String? = null,
  maxLength: UInt? = null,
  prefix: String? = null,
  suffix: String? = null,
  leadingIcon: MDCContent<MDCTextFieldScope>? = null,
  trailingIcon: MDCContent<MDCTextFieldScope>? = null,
  attrs: MDCAttrs<InputAttrsScope<String>>? = null,
) {
  MDCTextField(
    value = value,
    inputType = InputType.Text,
    type = type,
    disabled = disabled,
    label = label,
    helperText = helperText,
    maxLength = maxLength,
    prefix = prefix,
    suffix = suffix,
    leadingIcon = leadingIcon,
    trailingIcon = trailingIcon,
    attrs = attrs
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-textfield)
 */
@MDCContentDsl
@Composable
@Suppress("LongMethod")
public fun <R> MDCTextField(
  value: String,
  inputType: InputType<R>,
  type: MDCTextFieldType = MDCTextFieldType.Filled,
  disabled: Boolean = false,
  label: String? = null,
  helperText: String? = null,
  maxLength: UInt? = null,
  prefix: String? = null,
  suffix: String? = null,
  leadingIcon: MDCContent<MDCTextFieldScope>? = null,
  trailingIcon: MDCContent<MDCTextFieldScope>? = null,
  attrs: MDCAttrs<InputAttrsScope<R>>? = null,
) {
  Style
  val labelId = rememberUniqueDomElementId()
  val helperId = "$labelId-helper"
  Label(
    attrs = {
      classes("mdc-text-field")
      classes(type.classes)
      if (label == null) classes("mdc-text-field--no-label")
      if (disabled) classes("mdc-text-field--disabled")
      leadingIcon?.let { classes("mdc-text-field--with-leading-icon") }
      trailingIcon?.let { classes("mdc-text-field--with-trailing-icon") }
    }
  ) {
    MDCProvider(::MDCTextField, type, label, prefix, suffix, leadingIcon == null, trailingIcon == null) {
      MDCStateEffect(value, MDCTextField::value)
      when (type) {
        MDCTextFieldType.Filled -> {
          Span(attrs = { classes("mdc-text-field__ripple") })
          MDCFloatingLabelLayout(
            id = labelId,
            float = false,
            required = false,
            shake = false,
            attrs = null,
          ) { label?.let { Text(it) } }
          MDCTextFieldCore(
            value = value,
            prefix = prefix,
            suffix = suffix,
            attrs = attrs,
            inputType = inputType,
            labelId = labelId,
            helperId = helperId,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            maxLength = maxLength,
            helperText = helperText,
            disabled = disabled,
          )
          MDCLineRipple(false)
        }

        MDCTextFieldType.Outlined -> {
          MDCNotchedOutlineLayout {
            Leading()
            Notch {
              MDCFloatingLabelLayout(
                id = labelId,
                float = false,
                required = false,
                shake = false,
                attrs = null,
              ) { label?.let { Text(it) } }
            }
            Trailing()
          }
          MDCTextFieldCore(
            value = value,
            prefix = prefix,
            suffix = suffix,
            attrs = attrs,
            inputType = inputType,
            labelId = labelId,
            helperId = helperId,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            maxLength = maxLength,
            helperText = helperText,
            disabled = disabled,
          )
        }
      }
    }
  }
  MDCTextFieldHelperLine(helperText = helperText, maxLength = maxLength, helperId = helperId) {
    maxLength?.let {
      Div(attrs = {
        classes("mdc-text-field-character-counter")
      })
    }
  }
}

@Composable
@KMDCInternalAPI
private fun <R> ElementScope<HTMLLabelElement>.MDCTextFieldCore(
  value: String,
  labelId: String,
  helperId: String,
  prefix: String?,
  suffix: String?,
  disabled: Boolean,
  maxLength: UInt?,
  helperText: String?,
  attrs: MDCAttrs<InputAttrsScope<R>>?,
  inputType: InputType<R>,
  leadingIcon: MDCContent<MDCTextFieldScope>?,
  trailingIcon: MDCContent<MDCTextFieldScope>?
) {
  applyContent(leadingIcon)
  prefix?.let {
    Span(attrs = {
      classes("mdc-text-field__affix", "mdc-text-field__affix--prefix")
    }) {
      Text(it)
    }
  }
  MDCTextFieldInput(
    value = value,
    helperText = helperText,
    disabled = disabled,
    labelId = labelId,
    helperId = helperId,
    maxLength = maxLength,
    attrs = attrs,
    inputType = inputType,
  )
  suffix?.let {
    Span(attrs = {
      classes("mdc-text-field__affix", "mdc-text-field__affix--suffix")
    }) {
      Text(it)
    }
  }
  applyContent(trailingIcon)
}

@MDCContentDsl
@Composable
internal fun MDCTextFieldHelperLine(
  helperText: String?,
  maxLength: UInt?,
  helperId: String,
  content: MDCContentRaw<HTMLDivElement>? = null,
) {
  if (helperText != null || maxLength != null) {
    Div(attrs = { classes("mdc-text-field-helper-line") }) {
      helperText?.let {
        Div(attrs = {
          classes("mdc-text-field-helper-text")
          id(helperId)
          attr("aria-hidden", "true")
        }) {
          Text(it)
        }
      }
      content?.invoke(this)
    }
  }
}

@MDCContentDsl
@Composable
private fun <R> MDCTextFieldInput(
  value: String,
  maxLength: UInt?,
  disabled: Boolean,
  helperText: String?,
  helperId: String,
  labelId: String,
  attrs: MDCAttrs<InputAttrsScope<R>>?,
  inputType: InputType<R>,
) {
  Input(type = inputType, attrs = {
    value(value)
    classes("mdc-text-field__input")
    attr("aria-labelledby", labelId)
    helperText?.let {
      attr("aria-describedby", helperId)
      attr("aria-controls", helperId)
    }
    maxLength?.let {
      maxLength(it.toInt())
    }
    if (disabled) disabled()
    attrs?.invoke(this)
  })
}
