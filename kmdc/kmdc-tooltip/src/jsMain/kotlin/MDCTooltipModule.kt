package dev.petuska.kmdc.tooltip

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element
import org.w3c.dom.events.Event

@MDCExternalAPI
@JsModule("@material/tooltip")
public external object MDCTooltipModule {
  public class MDCTooltip(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public fun initialize()
    public fun setTooltipPosition(
      xPos: dynamic = definedExternally,
      yPos: dynamic = definedExternally,
      withCaretPos: dynamic = definedExternally,
    )

    public fun setAnchorBoundaryType(type: dynamic)
    public fun setShowDelay(delayMs: Number)
    public fun setHideDelay(delayMs: Number)
    public fun hide()
    public fun isShown(): Boolean
    public fun <E : Event> attachScrollHandler(
      addEventListenerFn: (event: dynamic, handler: (event: E) -> Unit) -> Unit
    )

    public fun <E : Event> removeScrollHandler(
      removeEventHandlerFn: (event: dynamic, handler: (event: E) -> Unit) -> Unit
    )

    public var checked: Boolean
    public var indeterminate: Boolean
    public var disabled: Boolean
    public var value: String
  }
}
