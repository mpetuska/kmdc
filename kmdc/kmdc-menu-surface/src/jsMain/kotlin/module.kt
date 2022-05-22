@file:JsModule("@material/menu-surface")

package dev.petuska.kmdc.menu.surface

import dev.petuska.kmdc.core.*
import org.w3c.dom.*

@MDCExternalAPI
public external class MDCMenuSurface(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
  public var anchorElement: HTMLElement

  public fun isOpen(): Boolean
  public fun open()
  public var quickOpen: Boolean
  public fun close(skipRestoreFocus: Boolean? = definedExternally)
  public fun setIsHoisted(isHoisted: Boolean)
  public fun setAnchorCorner(corner: Corner)
  public fun setAnchorMargin(margin: dynamic)
  public fun setFixedPosition(isFixed: Boolean)
  public fun setAbsolutePosition(x: Number, y: Number)
  public fun setMenuSurfaceAnchorElement(element: Element)
}

public external enum class Corner {
  TOP_LEFT,
  TOP_RIGHT,
  BOTTOM_LEFT,
  BOTTOM_RIGHT,
  TOP_START,
  TOP_END,
  BOTTOM_START,
  BOTTOM_END,
}
