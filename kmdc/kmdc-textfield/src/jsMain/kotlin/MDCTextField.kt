package dev.petuska.kmdc.textfield

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.KMDCInternalAPI
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.classes
import dev.petuska.kmdc.core.initialiseMDC
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

public open class MDCTextFieldCommonOpts(
  public var type: Type = Type.Filled,
  public var disabled: Boolean = false,
  public var label: String? = null,
  public var helperText: String? = null,
  public var maxLength: UInt? = null,
) {
  public enum class Type(public vararg val classes: String) {
    Filled("mdc-text-field--filled"), Outlined("mdc-text-field--outlined")
  }
}

public class MDCTextFieldScope(scope: ElementScope<HTMLLabelElement>) : ElementScope<HTMLLabelElement> by scope

public class MDCTextFieldOpts(
  type: Type = Type.Filled,
  disabled: Boolean = false,
  label: String? = null,
  helperText: String? = null,
  maxLength: UInt? = null,
  public var prefix: String? = null,
  public var suffix: String? = null,
) : MDCTextFieldCommonOpts(type, disabled, label, helperText, maxLength)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-textfield)
 */
@MDCDsl
@Composable
public fun MDCTextField(
  value: String,
  opts: Builder<MDCTextFieldOpts>? = null,
  attrs: Builder<InputAttrsScope<String>>? = null,
  leadingIcon: ComposableBuilder<MDCTextFieldScope>? = null,
  trailingIcon: ComposableBuilder<MDCTextFieldScope>? = null,
) {
  MDCTextFieldStyle
  val options = MDCTextFieldOpts().apply { opts?.invoke(this) }
  val labelId = rememberUniqueDomElementId()
  val helperId = "$labelId-helper"
  Label(
    attrs = {
      classes("mdc-text-field")
      classes(options.type.classes)
      if (options.label == null) classes("mdc-text-field--no-label")
      if (options.disabled) classes("mdc-text-field--disabled")
      leadingIcon?.let { classes("mdc-text-field--with-leading-icon") }
      trailingIcon?.let { classes("mdc-text-field--with-trailing-icon") }
      initialiseMDC(MDCTextFieldModule.MDCTextField::attachTo)
    }
  ) {
    when (options.type) {
      MDCTextFieldCommonOpts.Type.Filled -> {
        Span(attrs = { classes("mdc-text-field__ripple") })
        options.label?.let {
          Span(attrs = {
            classes("mdc-floating-label")
            if (value.isNotEmpty())
              classes("mdc-floating-label--float-above")
            id(labelId)
          }) { Text(it) }
        }
        MDCTextFieldCore(
          value = value,
          options = options,
          attrs = attrs,
          labelId = labelId,
          helperId = helperId,
          leadingIcon = leadingIcon,
          trailingIcon = trailingIcon,
        )
        MDCLineRipple(false)
      }
      MDCTextFieldCommonOpts.Type.Outlined -> {
        MDCTextFieldNotch(options, labelId, value.isNotEmpty())
        MDCTextFieldCore(
          value = value,
          options = options,
          attrs = attrs,
          labelId = labelId,
          helperId = helperId,
          leadingIcon = leadingIcon,
          trailingIcon = trailingIcon,
        )
      }
    }
  }
  MDCTextFieldHelperLine(options, helperId) {
    options.maxLength?.let {
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
  options: MDCTextFieldOpts,
  attrs: Builder<InputAttrsScope<String>>?,
  labelId: String,
  helperId: String,
  leadingIcon: ComposableBuilder<MDCTextFieldScope>?,
  trailingIcon: ComposableBuilder<MDCTextFieldScope>?
) {
  leadingIcon?.invoke(MDCTextFieldScope(this))
  options.prefix?.let {
    Span(attrs = {
      classes("mdc-text-field__affix", "mdc-text-field__affix--prefix")
    }) {
      Text(it)
    }
  }
  MDCTextFieldInput(value, options, attrs, labelId, helperId)
  options.suffix?.let {
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
internal fun MDCTextFieldNotch(options: MDCTextFieldCommonOpts, labelId: String, inputIsNotEmpty: Boolean) {
  Span(
    attrs = {
      classes("mdc-notched-outline")
      if (inputIsNotEmpty)
        classes("mdc-notched-outline--notched")
    }
  ) {
    Span(attrs = { classes("mdc-notched-outline__leading") })
    Span(attrs = { classes("mdc-notched-outline__notch") }) {
      options.label?.let {
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
  options: MDCTextFieldCommonOpts,
  helperId: String,
  content: ContentBuilder<HTMLDivElement>? = null,
) {
  if (options.helperText != null || options.maxLength != null) {
    Div(attrs = { classes("mdc-text-field-helper-line") }) {
      options.helperText?.let {
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
  options: MDCTextFieldOpts,
  attrs: Builder<InputAttrsScope<String>>?,
  labelId: String,
  helperId: String,
) {
  TextInput(value, attrs = {
    classes("mdc-text-field__input")
    attr("aria-labelledby", labelId)
    options.helperText?.let {
      attr("aria-describedby", helperId)
      attr("aria-controls", helperId)
    }
    options.maxLength?.let {
      maxLength(it.toInt())
    }
    if (options.disabled) disabled()
    attrs?.invoke(this)
  })
}
