package dev.petuska.kmdc.tab.indicator

import dev.petuska.kmdc.core.*
import org.w3c.dom.*

@MDCExternalAPI
@JsModule("@material/tab-indicator")
public external object MDCTabIndicatorModule {
  public class MDCTabIndicator(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public fun activate(previousIndicatorClientRect: dynamic = definedExternally)
    public fun deactivate()
    public fun computeContentClientRect(): dynamic
  }
}
