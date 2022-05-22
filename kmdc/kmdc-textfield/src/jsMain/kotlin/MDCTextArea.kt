package dev.petuska.kmdc.textfield

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.attributes.builders.*
import org.jetbrains.compose.web.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-textfield)
 */
@MDCDsl
@Composable
public fun MDCTextArea(
  value: String,
  type: MDCTextFieldType = MDCTextFieldType.Filled,
  disabled: Boolean = false,
  label: String? = null,
  helperText: String? = null,
  maxLength: UInt? = null,
  rows: UInt = 8u,
  columns: UInt = 40u,
  attrs: MDCAttrs<TextAreaAttrsScope>? = null,
) {
  Style
  val labelId = rememberUniqueDomElementId()
  val helperId = rememberUniqueDomElementId()
  Label(
    attrs = {
      classes("mdc-text-field", "mdc-text-field--textarea")
      classes(type.classes)
      if (label == null) classes("mdc-text-field--no-label")
      if (disabled) classes("mdc-text-field--disabled")
    }
  ) {
    MDCInitEffect(MDCTextFieldModule::MDCTextField, label)
    maxLength?.let {
      Div(attrs = {
        classes("mdc-text-field-character-counter")
      })
    }
    when (type) {
      MDCTextFieldType.Filled -> {
        Span(attrs = { classes("mdc-text-field__ripple") })
        Span(attrs = { classes("mdc-text-field__resizer") }) {
          MDCTextAreaInput(
            value = value,
            rows = rows,
            columns = columns,
            helperText = helperText,
            maxLength = maxLength,
            attrs = attrs,
            labelId = labelId,
            helperId = helperId
          )
        }
        label?.let {
          Span(attrs = {
            classes("mdc-floating-label")
            if (value.isNotEmpty())
              classes("mdc-floating-label--float-above")
            id(labelId)
          }) { Text(it) }
        }
        Span(attrs = { classes("mdc-line-ripple") })
      }
      MDCTextFieldType.Outlined -> {
        MDCTextFieldNotch(label = label, labelId = labelId, inputIsNotEmpty = value.isNotEmpty())
        Span(attrs = { classes("mdc-text-field__resizer") }) {
          MDCTextAreaInput(
            value = value,
            rows = rows,
            columns = columns,
            helperText = helperText,
            maxLength = maxLength,
            attrs = attrs,
            labelId = labelId,
            helperId = helperId
          )
        }
      }
    }
  }
  MDCTextFieldHelperLine(helperText = helperText, maxLength = maxLength, helperId = helperId)
}

@Composable
private fun MDCTextAreaInput(
  value: String,
  maxLength: UInt?,
  helperText: String?,
  rows: UInt,
  columns: UInt,
  attrs: MDCAttrs<TextAreaAttrsScope>?,
  labelId: String,
  helperId: String,
) {
  TextArea(value, attrs = {
    classes("mdc-text-field__input")
    rows(rows.toInt())
    cols(columns.toInt())
    attr("aria-labelledby", labelId)
    maxLength?.let {
      maxLength(it.toInt())
    }
    helperText?.let {
      attr("aria-describedby", helperId)
      attr("aria-controls", helperId)
    }
    attrs?.invoke(this)
  })
}
