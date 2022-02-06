package dev.petuska.kmdc.ripple

import dev.petuska.kmdc.core.MDCBaseModule
import org.w3c.dom.Element

@JsModule("@material/ripple")
public external object MDCRippleModule {
  public interface MDCRippleAttachOpts {
    public var isUnbounded: Boolean?
  }

  public class MDCRipple(element: Element, opts: MDCRippleAttachOpts = definedExternally) :
    MDCBaseModule.MDCComponent<dynamic> {
    public companion object {
      public fun attachTo(element: Element, opts: MDCRippleAttachOpts = definedExternally): MDCRipple
    }
  }
}
