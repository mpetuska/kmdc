@file:JsModule("@material/switch")

package dev.petuska.kmdc.switch

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.ripple.MDCRipple
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCSwitch(element: Element) : MDCComponent<dynamic> {
  public var disabled: Boolean
  public var processing: Boolean
  public var selected: Boolean
  public var ripple: MDCRipple
}
