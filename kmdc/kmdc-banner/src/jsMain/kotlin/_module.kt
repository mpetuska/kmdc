@file:JsModule("@material/banner")

package dev.petuska.kmdc.banner

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.core.MDCLayoutComponent
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCBanner(element: Element) : MDCComponent<dynamic>, MDCLayoutComponent {
  public val isOpen: Boolean
  public fun open()
  public fun close(closeReason: CloseReason)
  public fun getText(): String
  public fun setText(text: String)
  public fun getPrimaryActionText(): String
  public fun setPrimaryActionText(actionButtonText: String)
  public fun getSecondaryActionText(): String
  public fun setSecondaryActionText(actionButtonText: String)
  public override fun layout()
}

public external enum class CloseReason {
  PRIMARY,
  SECONDARY,
  UNSPECIFIED
}
