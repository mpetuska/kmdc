@file:JsModule("@material/drawer")

package dev.petuska.kmdc.drawer

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCDrawer(element: Element) : MDCComponent<dynamic> {
  public var open: Boolean
}
