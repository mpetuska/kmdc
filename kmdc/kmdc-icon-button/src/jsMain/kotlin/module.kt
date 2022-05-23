@file:JsModule("@material/icon-button")

package dev.petuska.kmdc.icon.button

import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.ripple.*
import org.w3c.dom.*

@MDCExternalAPI
public external class MDCIconButtonToggle(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
  public val ripple: MDCRipple
  public var on: Boolean
}
