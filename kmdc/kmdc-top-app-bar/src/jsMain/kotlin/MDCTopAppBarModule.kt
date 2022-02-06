package dev.petuska.kmdc.top.app.bar

import dev.petuska.kmdc.core.MDCBaseModule
import org.w3c.dom.Element

@JsModule("@material/top-app-bar")
public external object MDCTopAppBarModule {
  public class MDCTopAppBar(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public companion object {
      public fun attachTo(element: Element): MDCTopAppBar
    }
  }
}
