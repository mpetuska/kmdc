package dev.petuska.kmdc.tab.indicator

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
@JsModule("@material/tab-indicator")
public external object MDCTabIndicatorModule {
  public class MDCTabIndicator(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public fun activate(previousIndicatorClientRect: dynamic = definedExternally)
    public fun deactivate()
    public fun computeContentClientRect(): dynamic
  }
}