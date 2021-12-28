package dev.petuska.kmdc.icon.button

import dev.petuska.kmdc.core.Destroyable
import org.w3c.dom.Element

@JsModule("@material/icon-button")
public external object MDCIconButtonModule {
  public class MDCIconButtonToggle(element: Element) : Destroyable {
    public companion object {
      public fun attachTo(element: Element): MDCIconButtonToggle
    }

    override fun destroy()
  }
}
