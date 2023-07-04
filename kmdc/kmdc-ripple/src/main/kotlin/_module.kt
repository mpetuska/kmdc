@file:JsModule("@material/ripple")

package dev.petuska.kmdc.ripple

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.core.MDCLayoutComponent
import org.w3c.dom.Element

@MDCExternalAPI
public external interface MDCRippleAttachOpts {
  public var isUnbounded: Boolean?
}

@MDCExternalAPI
public external class MDCRipple(element: Element, opts: MDCRippleAttachOpts = definedExternally) :
  MDCComponent<dynamic>, MDCLayoutComponent {
  public var unbounded: Boolean
  public var disabled: Boolean
  public fun activate()
  public fun deactivate()
  public fun handleFocus()
  public fun handleBlur()
  override fun layout()
}
