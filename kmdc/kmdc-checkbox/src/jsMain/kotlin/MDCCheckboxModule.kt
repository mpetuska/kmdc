package dev.petuska.kmdc.checkbox

import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.form.field.*
import dev.petuska.kmdc.ripple.*
import org.w3c.dom.*

@MDCExternalAPI
@JsModule("@material/checkbox")
public external object MDCCheckboxModule {
  public class MDCCheckbox(element: Element) :
    MDCBaseModule.MDCComponent<dynamic>,
    MDCFormFieldModule.MDCFormFieldInput {
    public var checked: Boolean
    public var indeterminate: Boolean
    public var disabled: Boolean
    public var value: String
    override val ripple: MDCRipple?
  }
}
