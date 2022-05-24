@file:JsModule("@material/tab")

package dev.petuska.kmdc.tab

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCTab(element: Element) : MDCComponent<dynamic> {
  public var id: String
  public val active: Boolean
  public var focusOnActivate: Boolean
  public fun activate(previousIndicatorClientRect: dynamic = definedExternally)
  public fun deactivate()
  public fun focus()
  public fun computeContentClientRect(): dynamic
  public fun computeDimensions(): dynamic
}
