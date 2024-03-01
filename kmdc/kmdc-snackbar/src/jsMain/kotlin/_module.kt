@file:JsModule("@material/snackbar")

package dev.petuska.kmdc.snackbar

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCSnackbar(element: Element) : MDCComponent<dynamic> {
  public fun initialize(
    segmentFactory: (
      el: Element,
      foundation: dynamic
    ) -> (() -> (ariaEl: Element, labelEl: Element?) -> Unit) = definedExternally
  )

  public fun open()
  public fun close(reason: String = definedExternally)
  public var timeoutMs: Int
  public var closeOnEscape: Boolean
  public val isOpen: Boolean
  public var labelText: String
  public var actionButtonText: String
}
