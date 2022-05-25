@file:JsModule("@material/floating-label")

package dev.petuska.kmdc.button

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCFloatingLabel(element: Element) : MDCComponent<dynamic> {
  public fun shake(shouldShake: Boolean)
  public fun float(shouldFloat: Boolean)
  public fun setRequired(isRequired: Boolean)
  public fun getWidth(): Number
}
