@file:JsModule("@material/switch")

package dev.petuska.kmdc.switch

import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.ripple.*
import org.w3c.dom.*

@MDCExternalAPI
public external class MDCSwitch(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
  public var disabled: Boolean
  public var processing: Boolean
  public var selected: Boolean
  public var ripple: MDCRipple
}
