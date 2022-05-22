package dev.petuska.kmdc.drawer

import dev.petuska.kmdc.core.*
import org.w3c.dom.*

@JsModule("@material/drawer")
public external object MDCDrawerModule {
  public class MDCDrawer(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public var open: Boolean
  }
}
