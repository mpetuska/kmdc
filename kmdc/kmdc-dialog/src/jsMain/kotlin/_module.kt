@file:JsModule("@material/dialog")

package dev.petuska.kmdc.dialog

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.core.MDCLayoutComponent
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCDialog(element: Element) : MDCComponent<dynamic>, MDCLayoutComponent {
  public val isOpen: Boolean
  public var escapeKeyAction: String
  public var scrimClickAction: String
  public var autoStackButtons: Boolean

  public override fun layout()
  public fun open()
  public fun close(action: String = definedExternally)
}
