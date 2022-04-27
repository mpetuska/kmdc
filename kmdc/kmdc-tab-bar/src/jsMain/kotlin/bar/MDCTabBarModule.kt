package dev.petuska.kmdc.tab.bar

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
@JsModule("@material/tab-bar")
public external object MDCTabBarModule {
  public class MDCTabBar(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public var focusOnActivate: Boolean
    public var useAutomaticActivation: Boolean
    public fun activateTab(index: Int)
    public fun scrollIntoView(index: Int)
  }

  public class MDCTabBarActivatedEvent : MDCEvent<MDCTabBarActivatedEvent.Detail> {
    public interface Detail {
      public val index: Int
      public val tabId: String
    }
  }
}
