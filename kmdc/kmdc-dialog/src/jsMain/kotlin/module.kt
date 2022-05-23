@file:JsModule("@material/dialog")

package dev.petuska.kmdc.dialog

import dev.petuska.kmdc.core.*
import org.w3c.dom.*

@MDCExternalAPI
public external class MDCDialog(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
  public val isOpen: Boolean
  public var escapeKeyAction: String
  public var scrimClickAction: String
  public var autoStackButtons: Boolean

  public fun layout()
  public fun open()
  public fun close(action: String = definedExternally)
}
