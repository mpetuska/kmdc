package dev.petuska.kmdc.linear.progress

import dev.petuska.kmdc.core.MDCBaseModule
import org.w3c.dom.Element

@JsModule("@material/linear-progress")
public external object MDCLinearProgressModule {
  public class MDCLinearProgress(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public var determinate: Boolean
    public var progress: Number
    public var buffer: Number
    public fun open()
    public fun close()
  }
}
