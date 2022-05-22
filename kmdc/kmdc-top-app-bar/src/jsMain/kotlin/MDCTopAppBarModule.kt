package dev.petuska.kmdc.top.app.bar

import dev.petuska.kmdc.core.*
import org.w3c.dom.*

@JsModule("@material/top-app-bar")
public external object MDCTopAppBarModule {
  public class MDCTopAppBar(element: Element) : MDCBaseModule.MDCComponent<dynamic>
}
