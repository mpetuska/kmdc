@file:JsModule("@material/checkbox")

package dev.petuska.kmdc.checkbox

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.form.field.MDCFormFieldInput
import dev.petuska.kmdc.ripple.MDCRipple
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCCheckbox(element: Element) : MDCComponent<dynamic>, MDCFormFieldInput {
  public var checked: Boolean
  public var indeterminate: Boolean
  public var disabled: Boolean
  public var value: String
  override val ripple: MDCRipple?
}
