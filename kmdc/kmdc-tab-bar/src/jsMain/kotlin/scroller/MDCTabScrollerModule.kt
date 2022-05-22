package dev.petuska.kmdc.tab.scroller

import dev.petuska.kmdc.core.*
import org.w3c.dom.*

@MDCExternalAPI
@JsModule("@material/tab-scroller")
public external object MDCTabScrollerModule {
  public class MDCTabScroller(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public fun getScrollPosition(): Number
    public fun getScrollContentWidth(): Number
    public fun scrollTo(scrollX: Number)
    public fun incrementScroll(scrollX: Number)
    public fun incrementScrollImmediate(scrollX: Number)
  }
}
