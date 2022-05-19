package dev.petuska.kmdc.textfield

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCInitEffect
import dev.petuska.kmdc.core.classes
import dev.petuska.kmdc.core.rememberUniqueDomElementId
import org.jetbrains.compose.web.attributes.builders.TextAreaAttrsScope
import org.jetbrains.compose.web.attributes.cols
import org.jetbrains.compose.web.attributes.maxLength
import org.jetbrains.compose.web.attributes.rows
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextArea

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
  attrs: Builder<TextAreaAttrsScope>? = null,
) {
  MDCTextFieldStyle
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
    MDCInitEffect(MDCTextFieldModule::MDCTextField, rebuildOnChange = true, keys = arrayOf(label))
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
  attrs: Builder<TextAreaAttrsScope>?,
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
