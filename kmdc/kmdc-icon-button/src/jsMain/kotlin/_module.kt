@file:JsModule("@material/icon-button")

package dev.petuska.kmdc.icon.button

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.ripple.MDCRipple
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCIconButtonToggle(element: Element) : MDCComponent<dynamic> {
  public val ripple: MDCRipple
  public var on: Boolean
}
