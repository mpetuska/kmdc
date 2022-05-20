package dev.petuska.kmdc.drawer

import dev.petuska.kmdc.core.MDCBaseModule
import org.w3c.dom.Element

@JsModule("@material/drawer")
public external object MDCDrawerModule {
  public class MDCDrawer(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public var open: Boolean
  }
}
