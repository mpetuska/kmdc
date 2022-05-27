@file:JsModule("@material/form-field")

package dev.petuska.kmdc.form.field

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.ripple.MDCRipple
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCFormField(element: Element) : MDCComponent<dynamic> {
  public var input: MDCFormFieldInput?
}

@MDCExternalAPI
public external interface MDCFormFieldInput {
  public val ripple: MDCRipple?
}
