@file:JsModule("@material/notched-outline")

package dev.petuska.kmdc.notched.outline

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCNotchedOutline(element: Element) : MDCComponent<dynamic> {
  public fun closeNotch()
  public fun notch(notchWidth: Number)
}
