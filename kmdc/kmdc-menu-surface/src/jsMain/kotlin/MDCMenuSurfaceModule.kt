package dev.petuska.kmdc.menu.surface

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement

@MDCExternalAPI
@JsModule("@material/menu-surface")
public external object MDCMenuSurfaceModule {
  public class MDCMenuSurface(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public var anchorElement: HTMLElement

    public fun isOpen(): Boolean
    public fun open()
    public fun close(skipRestoreFocus: Boolean)
    public fun setAnchorCorner(corner: Byte)
  }

  public enum class Corner {
    TOP_LEFT,
    TOP_RIGHT,
    BOTTOM_LEFT,
    BOTTOM_RIGHT,
    TOP_START,
    TOP_END,
    BOTTOM_START,
    BOTTOM_END,
  }
}
