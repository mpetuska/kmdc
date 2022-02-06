package dev.petuska.kmdc.circular.progress

import dev.petuska.kmdc.core.MDCBaseModule
import org.w3c.dom.Element

@JsModule("@material/circular-progress")
public external object MDCCircularProgressModule {
  public class MDCCircularProgress(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public companion object {
      public fun attachTo(element: Element): MDCCircularProgress
    }

    public var determinate: Boolean
    public var progress: Number
    public val isClosed: Boolean
    public fun open()
    public fun close()
  }
}
