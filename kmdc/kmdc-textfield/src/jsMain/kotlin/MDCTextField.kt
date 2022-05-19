package dev.petuska.kmdc.textfield

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.KMDCInternalAPI
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCInitEffect
import dev.petuska.kmdc.core.classes
import dev.petuska.kmdc.core.rememberUniqueDomElementId
import dev.petuska.kmdc.line.ripple.MDCLineRipple
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.maxLength
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextInput
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLLabelElement

@JsModule("@material/textfield/dist/mdc.textfield.css")
public external val MDCTextFieldStyle: dynamic

public enum class MDCTextFieldType(public vararg val classes: String) {
  Filled("mdc-text-field--filled"), Outlined("mdc-text-field--outlined")
}

public class MDCTextFieldScope(scope: ElementScope<HTMLLabelElement>) : ElementScope<HTMLLabelElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-textfield)
 */
@MDCDsl
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
  attrs: Builder<InputAttrsScope<String>>? = null,
  leadingIcon: ComposableBuilder<MDCTextFieldScope>? = null,
  trailingIcon: ComposableBuilder<MDCTextFieldScope>? = null,
) {
  MDCTextFieldStyle
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
    MDCInitEffect(
      MDCTextFieldModule::MDCTextField,
      rebuildOnChange = true,
      keys = arrayOf(label, prefix, suffix, leadingIcon == null, trailingIcon == null)
    )
    when (type) {
      MDCTextFieldType.Filled -> {
        Span(attrs = { classes("mdc-text-field__ripple") })
        label?.let {
          Span(attrs = {
            classes("mdc-floating-label")
            if (value.isNotEmpty())
              classes("mdc-floating-label--float-above")
            id(labelId)
          }) { Text(it) }
        }
        MDCTextFieldCore(
          value = value,
          prefix = prefix,
          suffix = suffix,
          attrs = attrs,
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
        MDCTextFieldNotch(
          label = label,
          labelId = labelId,
          inputIsNotEmpty = value.isNotEmpty()
        )
        MDCTextFieldCore(
          value = value,
          prefix = prefix,
          suffix = suffix,
          attrs = attrs,
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
private fun ElementScope<HTMLLabelElement>.MDCTextFieldCore(
  value: String,
  labelId: String,
  helperId: String,
  prefix: String?,
  suffix: String?,
  disabled: Boolean,
  maxLength: UInt?,
  helperText: String?,
  attrs: Builder<InputAttrsScope<String>>?,
  leadingIcon: ComposableBuilder<MDCTextFieldScope>?,
  trailingIcon: ComposableBuilder<MDCTextFieldScope>?
) {
  leadingIcon?.invoke(MDCTextFieldScope(this))
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
    attrs = attrs,
    labelId = labelId,
    helperId = helperId,
    maxLength = maxLength,
  )
  suffix?.let {
    Span(attrs = {
      classes("mdc-text-field__affix", "mdc-text-field__affix--suffix")
    }) {
      Text(it)
    }
  }
  trailingIcon?.invoke(MDCTextFieldScope(this))
}

@MDCDsl
@Composable
internal fun MDCTextFieldNotch(
  label: String?,
  labelId: String,
  inputIsNotEmpty: Boolean
) {
  Span(
    attrs = {
      classes("mdc-notched-outline")
      if (inputIsNotEmpty)
        classes("mdc-notched-outline--notched")
    }
  ) {
    Span(attrs = { classes("mdc-notched-outline__leading") })
    Span(attrs = { classes("mdc-notched-outline__notch") }) {
      label?.let {
        Span(attrs = {
          classes("mdc-floating-label")
          if (inputIsNotEmpty)
            classes("mdc-floating-label--float-above")
          id(labelId)
        }) { Text(it) }
      }
    }
    Span(attrs = { classes("mdc-notched-outline__trailing") })
  }
}

@MDCDsl
@Composable
internal fun MDCTextFieldHelperLine(
  helperText: String?,
  maxLength: UInt?,
  helperId: String,
  content: ContentBuilder<HTMLDivElement>? = null,
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

@MDCDsl
@Composable
private fun MDCTextFieldInput(
  value: String,
  maxLength: UInt?,
  disabled: Boolean,
  helperText: String?,
  helperId: String,
  labelId: String,
  attrs: Builder<InputAttrsScope<String>>?,
) {
  TextInput(value, attrs = {
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
