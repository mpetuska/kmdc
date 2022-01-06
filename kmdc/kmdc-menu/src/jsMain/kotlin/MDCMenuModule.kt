package dev.petuska.kmdc.menu

import dev.petuska.kmdc.core.Destroyable
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.menu.surface.Corner
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement

@JsModule("@material/menu")
public external object MDCMenuModule {
  public class MDCMenu(element: Element) : Destroyable {
    public companion object {
      public fun attachTo(element: Element): MDCMenu
    }

    override fun destroy()

    public var open: Boolean

    public fun setAnchorCorner(corner: Corner)
    public fun setAbsolutePosition(x: Double, y: Double)
    public fun setFixedPosition(isFixed: Boolean)
    public fun setSelectedIndex(index: Int)
    public fun setIsHoisted(isHoisted: Boolean)
    public fun setAnchorElement(element: HTMLElement)
    public fun getPrimaryTextAtIndex(index: Int): String
    public fun setEnabled(index: Int, isEnabled: Boolean)
    public fun typeaheadMatchItem(nextChar: String): Int
  }

  @Suppress("ClassName")
  public object strings {
    public val SELECTED_EVENT: String
  }

  public class MDCMenuSelectedEventDetail {
    public val item: Element
    public val index: Int
  }

  public class MDCMenuSelectedEvent : MDCEvent<MDCMenuSelectedEventDetail>
}
