package dev.petuska.kmdc.radio

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffectScope
import androidx.compose.runtime.remember
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.mdc
import dev.petuska.kmdc.form.field.MDCFormFieldModule
import dev.petuska.kmdc.form.field.MDCFormFieldScope
import dev.petuska.kmdc.ripple.MDCRippleModule
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsBuilder
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.Element
import org.w3c.dom.HTMLDivElement
import kotlin.random.Random

@JsModule("@material/radio/dist/mdc.radio.css")
public external val MDCRadioStyle: dynamic

@JsModule("@material/radio")
public external object MDCRadioModule {
  public class MDCRadio(element: Element) : MDCFormFieldModule.MDCFormFieldInput {
    public companion object {
      public fun attachTo(element: Element): MDCRadio
    }

    public fun destroy()

    public var checked: Boolean
    public var disabled: Boolean
    public var value: String
    override val ripple: MDCRippleModule.MDCRipple?
  }
}

public data class MDCRadioOpts(
  public var disabled: Boolean = false,
  public var label: String? = null,
)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-radio)
 */
@MDCDsl
@Composable
public fun MDCRadio(
  checked: Boolean,
  opts: Builder<MDCRadioOpts>? = null,
  attrs: (InputAttrsBuilder<Boolean>.() -> Unit)? = null,
) {
  MDCRadioBody(checked, opts, attrs)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-radio)
 */
@MDCDsl
@Composable
public fun MDCFormFieldScope.MDCRadio(
  checked: Boolean,
  opts: Builder<MDCRadioOpts>? = null,
  attrs: (InputAttrsBuilder<Boolean>.() -> Unit)? = null,
) {
  MDCRadioBody(checked, opts, attrs) { parent, mdcRadio ->
    setInput(parent, mdcRadio)
  }
}

@MDCDsl
@Composable
private fun MDCRadioBody(
  checked: Boolean,
  opts: Builder<MDCRadioOpts>? = null,
  attrs: (InputAttrsBuilder<Boolean>.() -> Unit)? = null,
  initialize: (DisposableEffectScope.(parent: HTMLDivElement, mdcRadio: MDCRadioModule.MDCRadio) -> Unit)? = null,
) {
  MDCRadioStyle
  val options = MDCRadioOpts().apply { opts?.invoke(this) }
  val localId = remember { Random.nextInt(9999) }
  val radioId = remember { "mdc-radio__native-control__$localId" }

  Div(attrs = {
    classes("mdc-radio")
    if (options.disabled) classes("mdc-radio--disabled")
    ref {
      val mdc = MDCRadioModule.MDCRadio.attachTo(it)
      it.mdc = mdc
      initialize?.invoke(this, it, mdc)
      onDispose {
        it.mdc<MDCRadioModule.MDCRadio> { destroy() }
      }
    }
  }) {
    Input(type = InputType.Radio, attrs = {
      classes("mdc-radio__native-control") // This must precede `checked()`
      checked(checked) // This must follow `classes(...)`
      id(radioId)
      if (options.disabled) disabled()
      attrs?.invoke(this)
    })
    Div(attrs = {
      classes("mdc-radio__background")
    }) {
      Div(attrs = { classes("mdc-radio__outer-circle") })
      Div(attrs = { classes("mdc-radio__inner-circle") })
    }
    Div(attrs = { classes("mdc-radio__ripple") })
  }
  options.label?.let {
    Label(forId = radioId, attrs = { id("$radioId-label") }) { Text(it) }
  }
}
