@file:JsModule("@material/tab-bar")

package dev.petuska.kmdc.tab.bar

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCTabBar(element: Element) : MDCComponent<dynamic> {
  public var focusOnActivate: Boolean
  public var useAutomaticActivation: Boolean
  public fun activateTab(index: Int)
  public fun scrollIntoView(index: Int)
}
