package dev.petuska.kmdc.switch

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.ripple.MDCRippleModule
import org.w3c.dom.Element

@JsModule("@material/switch")
public external object MDCSwitchModule {
  public class MDCSwitch(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public companion object {
      public fun attachTo(element: Element): MDCSwitch
    }

    public var disabled: Boolean
    public var processing: Boolean
    public var selected: Boolean
    public var ripple: MDCRippleModule.MDCRipple
  }
}
