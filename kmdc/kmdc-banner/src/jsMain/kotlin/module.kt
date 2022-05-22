@file:JsModule("@material/banner")

package dev.petuska.kmdc.banner

import dev.petuska.kmdc.core.*
import org.w3c.dom.*

@MDCExternalAPI
public external class MDCBanner(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
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

public external enum class CloseReason {
  PRIMARY,
  SECONDARY,
  UNSPECIFIED
}

public external interface MDCBannerCloseEventDetail {
  public val reason: CloseReason
}
