@file:JsModule("@material/radio")

package dev.petuska.kmdc.radio

import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.form.field.*
import dev.petuska.kmdc.ripple.*
import org.w3c.dom.*

@MDCExternalAPI
public external class MDCRadio(element: Element) :
  MDCBaseModule.MDCComponent<dynamic>,
  MDCFormFieldModule.MDCFormFieldInput {

  public var checked: Boolean
  public var disabled: Boolean
  public var value: String
  override val ripple: MDCRipple?
}
