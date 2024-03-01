@file:JsModule("@material/circular-progress")

package dev.petuska.kmdc.circular.progress

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCCircularProgress(element: Element) : MDCComponent<dynamic> {
  public var determinate: Boolean
  public var progress: Number
  public val isClosed: Boolean
  public fun open()
  public fun close()
}
