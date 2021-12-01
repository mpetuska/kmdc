package dev.petuska.kmdc.textfield

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.mdc
import dev.petuska.kmdc.ripple.MDCRippleModule
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsBuilder
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.maxLength
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.Element
import org.w3c.dom.HTMLDivElement
import kotlin.random.Random

@JsModule("@material/textfield/dist/mdc.textfield.css")
public external val MDCTextFieldStyle: dynamic

@JsModule("@material/textfield")
public external object MDCTextFieldModule {
  public class MDCTextField(element: Element) {
    public companion object {
      public fun attachTo(element: Element): MDCTextField
    }
    public fun destroy()

    public var value: String
    public var disabled: Boolean
    public var valid: Boolean
    public var prefixText: String
    public var suffixText: String

    // Proxied from input element
    public var required: Boolean
    public var pattern: String
    public var minLength: Number
    public var maxLength: Number
    public var min: Number
    public var max: Number
    public var step: Number

    // Write-only
    public var useNativeValidation: Boolean
    public var helperTextContent: String
    public var ripple: MDCRippleModule.MDCRipple
    public var leadingIconAriaLabel: String
    public var trailingIconAriaLabel: String
    public var leadingIconContent: String
    public var trailingIconContent: String

    public fun focus()
    public fun layout()
  }
}

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
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-textfield)
 */
@MDCDsl
@Composable
public fun MDCTextField(
  opts: Builder<MDCTextFieldOpts>? = null,
  attrs: (InputAttrsBuilder<String>.() -> Unit)? = null,
) {
  MDCTextFieldStyle
  val options = MDCTextFieldOpts().apply { opts?.invoke(this) }
  val localId = remember { Random.nextInt(9999) }
  val labelId = remember { "mdc-floating-label__$localId" }
  val helperId = remember { "mdc-text-field-helper-text__$localId" }
  Label(
    attrs = {
      classes("mdc-text-field", *options.type.classes)
      if (options.label == null) classes("mdc-text-field--no-label")
      if (options.disabled) classes("mdc-text-field--disabled")
      ref {
        it.mdc = MDCTextFieldModule.MDCTextField.attachTo(it)
        onDispose {
          it.mdc<MDCTextFieldModule.MDCTextField> { destroy() }
        }
      }
    }
  ) {
    when (options.type) {
      MDCTextFieldCommonOpts.Type.Filled -> {
        Span(attrs = { classes("mdc-text-field__ripple") })
        options.label?.let {
          Span(attrs = {
            classes("mdc-floating-label")
            id("mdc-floating-label__$labelId")
          }) { Text(it) }
        }
        options.prefix?.let {
          Span(attrs = {
            classes("mdc-text-field__affix", "mdc-text-field__affix--prefix")
          }) {
            Text(it)
          }
        }
        options.suffix?.let {
          Span(attrs = {
            classes("mdc-text-field__affix", "mdc-text-field__affix--suffix")
          }) {
            Text(it)
          }
        }
        MDCTextFieldInput(options, attrs, labelId, helperId)
        Span(attrs = { classes("mdc-line-ripple") })
      }
      MDCTextFieldCommonOpts.Type.Outlined -> {
        MDCTextFieldNotch(options, labelId)
        MDCTextFieldInput(options, attrs, labelId, helperId)
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

@MDCDsl
@Composable
internal fun MDCTextFieldNotch(options: MDCTextFieldCommonOpts, labelId: String) {
  Span(attrs = { classes("mdc-notched-outline") }) {
    Span(attrs = { classes("mdc-notched-outline__leading") })
    Span(attrs = { classes("mdc-notched-outline__notch") }) {
      options.label?.let {
        Span(attrs = {
          classes("mdc-floating-label")
          id("mdc-floating-label__$labelId")
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
  options: MDCTextFieldOpts,
  attrs: (InputAttrsBuilder<String>.() -> Unit)?,
  labelId: String,
  helperId: String,
) {
  Input(InputType.Text, attrs = {
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
