@file:JsModule("@material/linear-progress")

package dev.petuska.kmdc.linear.progress

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCLinearProgress(element: Element) : MDCComponent<dynamic> {
  public var determinate: Boolean
  public var progress: Number
  public var buffer: Number
  public fun open()
  public fun close()
}
