package dev.petuska.kmdc.tab

import dev.petuska.kmdc.core.*
import org.w3c.dom.*

@MDCExternalAPI
@JsModule("@material/tab")
public external object MDCTabModule {
  public class MDCTab(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public var id: String
    public val active: Boolean
    public var focusOnActivate: Boolean
    public fun activate(previousIndicatorClientRect: dynamic = definedExternally)
    public fun deactivate()
    public fun focus()
    public fun computeContentClientRect(): dynamic
    public fun computeDimensions(): dynamic
  }
}
