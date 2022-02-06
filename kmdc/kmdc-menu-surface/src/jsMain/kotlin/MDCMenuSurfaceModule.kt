package dev.petuska.kmdc.menu.surface

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCEvent
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement

@JsModule("@material/menu-surface")
public external object MDCMenuSurfaceModule {
  public class MDCMenuSurface(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public companion object {
      public fun attachTo(element: Element): MDCMenuSurface
    }

    public var anchorElement: HTMLElement

    public fun isOpen(): Boolean
    public fun open()
    public fun close(skipRestoreFocus: Boolean)
    public fun setAnchorCorner(corner: Byte)
  }

// As of 1.6.20-M1, enum will be supported https://youtrack.jetbrains.com/issue/KT-37916
  // public enum class Corner { TOP_LEFT, ... }

// Until then, we import the Corner definition under object
  public object Corner {
    public val TOP_LEFT: Byte
    public val TOP_RIGHT: Byte
    public val BOTTOM_LEFT: Byte
    public val BOTTOM_RIGHT: Byte
    public val TOP_START: Byte
    public val TOP_END: Byte
    public val BOTTOM_START: Byte
    public val BOTTOM_END: Byte
  }

  @Suppress("ClassName")
  public object strings {
    public val CLOSED_EVENT: String
    public val CLOSING_EVENT: String
    public val OPENED_EVENT: String
  }

  public class MDCMenuSurfaceEventDetail {
    public val item: Element
  }

  public class MDCMenuSurfaceEvent : MDCEvent<MDCMenuSurfaceEventDetail>
}
