package dev.petuska.kmdc.checkbox

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.initialiseMDC
import dev.petuska.kmdc.core.mdc
import dev.petuska.kmdc.core.uniqueDomElementId
import dev.petuska.kmdc.form.field.MDCFormFieldScope
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsBuilder
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.svg.Path
import org.jetbrains.compose.web.svg.Svg

@JsModule("@material/checkbox/dist/mdc.checkbox.css")
public external val MDCCheckboxStyle: dynamic

public data class MDCCheckboxOpts(
  public var disabled: Boolean = false,
  public var label: String? = null,
  public var indeterminate: Boolean = false,
)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-checkbox)
 */
@MDCDsl
@Composable
public fun MDCCheckbox(
  checked: Boolean,
  opts: Builder<MDCCheckboxOpts>? = null,
  attrs: (InputAttrsBuilder<Boolean>.() -> Unit)? = null,
) {
  MDCCheckboxBody(checked, opts, attrs)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-checkbox)
 */
@MDCDsl
@Composable
public fun MDCFormFieldScope.MDCCheckbox(
  checked: Boolean,
  opts: Builder<MDCCheckboxOpts>? = null,
  attrs: (InputAttrsBuilder<Boolean>.() -> Unit)? = null,
) {
  MDCCheckboxBody(checked, opts, attrs = {
    ref {
      it.mdc<MDCCheckboxModule.MDCCheckbox> { setInput(it, this) }
      onDispose { }
    }
    attrs?.invoke(this)
  })
}

@OptIn(ExperimentalComposeWebSvgApi::class)
@MDCDsl
@Composable
private fun MDCCheckboxBody(
  checked: Boolean,
  opts: Builder<MDCCheckboxOpts>? = null,
  attrs: (InputAttrsBuilder<Boolean>.() -> Unit)? = null,
) {
  MDCCheckboxStyle
  val options = MDCCheckboxOpts().apply { opts?.invoke(this) }
  val checkboxId = remember { uniqueDomElementId() }

  Div(attrs = {
    classes("mdc-checkbox")
    if (options.disabled) classes("mdc-checkbox--disabled")
    initialiseMDC(MDCCheckboxModule.MDCCheckbox::attachTo)
  }) {
    DomSideEffect(options.indeterminate) {
      it.mdc<MDCCheckboxModule.MDCCheckbox> { indeterminate = options.indeterminate }
    }
    // WORKAROUND https://github.com/JetBrains/compose-jb/issues/1528
    //     We cannot use the controlled CheckboxInput directly, but the workaround is functionally equivalent.
    Input(type = InputType.Checkbox, attrs = {
      classes("mdc-checkbox__native-control") // This must precede `checked()`
      checked(checked) // This must follow `classes(...)`
      id(checkboxId)
      if (options.disabled) disabled()
      if (options.indeterminate) attr("data-indeterminate", "true")
      attrs?.invoke(this)
    })
    Div(attrs = {
      classes("mdc-checkbox__background")
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
    Div(attrs = { classes("mdc-checkbox__ripple") })
  }
  options.label?.let {
    Label(forId = checkboxId, attrs = { id("$checkboxId-label") }) { Text(it) }
  }
}
