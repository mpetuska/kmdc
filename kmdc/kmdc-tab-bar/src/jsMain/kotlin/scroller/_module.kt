@file:JsModule("@material/tab-scroller")

package dev.petuska.kmdc.tab.scroller

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCTabScroller(element: Element) : MDCComponent<dynamic> {
  public fun getScrollPosition(): Number
  public fun getScrollContentWidth(): Number
  public fun scrollTo(scrollX: Number)
  public fun incrementScroll(scrollX: Number)
  public fun incrementScrollImmediate(scrollX: Number)
}
