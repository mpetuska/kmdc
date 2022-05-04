package dev.petuska.kmdc.textfield

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.initialiseMDC
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

public class MDCTextAreaOpts(
  type: Type = Type.Filled,
  disabled: Boolean = false,
  label: String? = null,
  helperText: String? = null,
  maxLength: UInt? = null,
  public var rows: UInt = 8u,
  public var columns: UInt = 40u,
) : MDCTextFieldCommonOpts(type, disabled, label, helperText, maxLength)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-textfield)
 */
@MDCDsl
@Composable
public fun MDCTextArea(
  value: String,
  opts: Builder<MDCTextAreaOpts>? = null,
  attrs: Builder<TextAreaAttrsScope>? = null,
) {
  MDCTextFieldStyle
  val options = MDCTextAreaOpts().apply { opts?.invoke(this) }
  val labelId = rememberUniqueDomElementId()
  val helperId = rememberUniqueDomElementId()
  Label(
    attrs = {
      classes("mdc-text-field", "mdc-text-field--textarea", *options.type.classes)
      if (options.label == null) classes("mdc-text-field--no-label")
      if (options.disabled) classes("mdc-text-field--disabled")
      initialiseMDC(MDCTextFieldModule.MDCTextField::attachTo)
    }
  ) {
    options.maxLength?.let {
      Div(attrs = {
        classes("mdc-text-field-character-counter")
      })
    }
    when (options.type) {
      MDCTextFieldCommonOpts.Type.Filled -> {
        Span(attrs = { classes("mdc-text-field__ripple") })
        Span(attrs = { classes("mdc-text-field__resizer") }) {
          MDCTextAreaInput(value, options, attrs, labelId, helperId)
        }
        options.label?.let {
          Span(attrs = {
            classes("mdc-floating-label")
            if (value.isNotEmpty())
              classes("mdc-floating-label--float-above")
            id(labelId)
          }) { Text(it) }
        }
        Span(attrs = { classes("mdc-line-ripple") })
      }
      MDCTextFieldCommonOpts.Type.Outlined -> {
        MDCTextFieldNotch(options, labelId, value.isNotEmpty())
        Span(attrs = { classes("mdc-text-field__resizer") }) {
          MDCTextAreaInput(value, options, attrs, labelId, helperId)
        }
      }
    }
  }
  MDCTextFieldHelperLine(options, helperId)
}

@Composable
private fun MDCTextAreaInput(
  value: String,
  options: MDCTextAreaOpts,
  attrs: Builder<TextAreaAttrsScope>?,
  labelId: String,
  helperId: String,
) {
  TextArea(value, attrs = {
    classes("mdc-text-field__input")
    rows(options.rows.toInt())
    cols(options.columns.toInt())
    attr("aria-labelledby", labelId)
    options.maxLength?.let {
      maxLength(it.toInt())
    }
    options.helperText?.let {
      attr("aria-describedby", helperId)
      attr("aria-controls", helperId)
    }
    attrs?.invoke(this)
  })
}
