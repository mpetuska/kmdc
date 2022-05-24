@file:JsModule("@material/tab-indicator")

package dev.petuska.kmdc.tab.indicator

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCTabIndicator(element: Element) : MDCComponent<dynamic> {
  public fun activate(previousIndicatorClientRect: dynamic = definedExternally)
  public fun deactivate()
  public fun computeContentClientRect(): dynamic
}
