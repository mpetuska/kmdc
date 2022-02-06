package dev.petuska.kmdc.icon.button

import dev.petuska.kmdc.core.MDCBaseModule
import org.w3c.dom.Element

@JsModule("@material/icon-button")
public external object MDCIconButtonModule {
  public class MDCIconButtonToggle(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public companion object {
      public fun attachTo(element: Element): MDCIconButtonToggle
    }
  }
}
