package dev.petuska.kmdc.banner

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
@JsModule("@material/banner")
public external object MDCBannerModule {
  public class MDCBanner(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public val isOpen: Boolean
    public fun open()
    public fun close(closeReason: CloseReason)
    public fun getText(): String
    public fun setText(text: String)
    public fun getPrimaryActionText(): String
    public fun setPrimaryActionText(actionButtonText: String)
    public fun getSecondaryActionText(): String
    public fun setSecondaryActionText(actionButtonText: String)
    public fun layout()
  }

  public enum class CloseReason {
    PRIMARY,
    SECONDARY,
    UNSPECIFIED
  }
}
