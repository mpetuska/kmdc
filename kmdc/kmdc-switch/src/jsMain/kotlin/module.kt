@file:JsModule("@material/switch")

package dev.petuska.kmdc.switch

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.ripple.MDCRipple
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCSwitch(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
  public var disabled: Boolean
  public var processing: Boolean
  public var selected: Boolean
  public var ripple: MDCRipple
}
