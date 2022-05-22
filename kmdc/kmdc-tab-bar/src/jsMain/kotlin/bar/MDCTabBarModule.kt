package dev.petuska.kmdc.tab.bar

import dev.petuska.kmdc.core.*
import org.w3c.dom.*

@MDCExternalAPI
@JsModule("@material/tab-bar")
public external object MDCTabBarModule {
  public class MDCTabBar(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public var focusOnActivate: Boolean
    public var useAutomaticActivation: Boolean
    public fun activateTab(index: Int)
    public fun scrollIntoView(index: Int)
  }
}
