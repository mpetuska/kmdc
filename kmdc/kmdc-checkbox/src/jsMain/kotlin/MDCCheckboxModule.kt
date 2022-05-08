package dev.petuska.kmdc.checkbox

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.form.field.MDCFormFieldModule
import dev.petuska.kmdc.ripple.MDCRippleModule
import org.w3c.dom.Element

@MDCExternalAPI
@JsModule("@material/checkbox")
public external object MDCCheckboxModule {
  public class MDCCheckbox(element: Element) :
    MDCBaseModule.MDCComponent<dynamic>,
    MDCFormFieldModule.MDCFormFieldInput {
    public companion object {
      public fun attachTo(element: Element): MDCCheckbox
    }

    public var checked: Boolean
    public var indeterminate: Boolean
    public var disabled: Boolean
    public var value: String
    override val ripple: MDCRippleModule.MDCRipple?
  }
}
