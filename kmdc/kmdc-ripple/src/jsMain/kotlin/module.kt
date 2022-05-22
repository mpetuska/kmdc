@file:JsModule("@material/ripple")

package dev.petuska.kmdc.ripple

import dev.petuska.kmdc.core.*
import org.w3c.dom.*

@MDCExternalAPI
public external interface MDCRippleAttachOpts {
  public var isUnbounded: Boolean?
}

@MDCExternalAPI
public external class MDCRipple(element: Element, opts: MDCRippleAttachOpts = definedExternally) :
  MDCBaseModule.MDCComponent<dynamic> {
  public var unbounded: Boolean
  public var disabled: Boolean
  public fun activate()
  public fun deactivate()
}
