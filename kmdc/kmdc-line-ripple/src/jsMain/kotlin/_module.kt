@file:JsModule("@material/line-ripple")

package dev.petuska.kmdc.line.ripple

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCLineRipple(element: Element) : MDCComponent<dynamic> {
  public fun activate()
  public fun deactivate()
  public fun setRippleCenter(xCoordinate: Number)
}
