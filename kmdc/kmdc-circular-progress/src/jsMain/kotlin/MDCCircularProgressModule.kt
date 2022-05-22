package dev.petuska.kmdc.circular.progress

import dev.petuska.kmdc.core.*
import org.w3c.dom.*

@JsModule("@material/circular-progress")
public external object MDCCircularProgressModule {
  public class MDCCircularProgress(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public var determinate: Boolean
    public var progress: Number
    public val isClosed: Boolean
    public fun open()
    public fun close()
  }
}
