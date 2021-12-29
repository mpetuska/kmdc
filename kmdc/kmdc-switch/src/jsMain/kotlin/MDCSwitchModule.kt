package dev.petuska.kmdc.switch

import dev.petuska.kmdc.core.Destroyable
import dev.petuska.kmdc.ripple.MDCRippleModule
import org.w3c.dom.Element

@JsModule("@material/switch")
public external object MDCSwitchModule {
  public class MDCSwitch(element: Element) : Destroyable {
    public companion object {
      public fun attachTo(element: Element)
    }

    public var disabled: Boolean
    public var processing: Boolean
    public var selected: Boolean
    public var ripple: MDCRippleModule.MDCRipple
    public fun initialise()
    public fun initialSyncWithDOM()
    override fun destroy()
    public fun getDefaultFoundation(): dynamic
  }
}
