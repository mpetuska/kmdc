@file:JsModule("@material/menu")

package dev.petuska.kmdc.menu

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.menu.surface.Corner
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement

@MDCExternalAPI
public external class MDCMenu(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
  public var open: Boolean
  public var wrapFocus: Boolean
  public var hasTypeahead: Boolean
  public val typeaheadInProgress: Boolean
  public val items: Array<Element>
  public var singleSelection: Boolean

  /**
   * Int | Array<Int>
   */
  public var selectedIndex: dynamic
  public var quickOpen: Boolean

  public fun typeaheadMatchItem(nextChar: String, startingIndex: Number = definedExternally): Int

  public fun setDefaultFocusState(corner: DefaultFocusState)
  public fun setAnchorCorner(corner: Corner)
  public fun setAnchorMargin(margin: dynamic)
  public fun setSelectedIndex(index: Int)
  public fun setEnabled(index: Int, isEnabled: Boolean)
  public fun getOptionByIndex(index: Int): Element?
  public fun getPrimaryTextAtIndex(index: Int): String
  public fun setFixedPosition(isFixed: Boolean)
  public fun setIsHoisted(isHoisted: Boolean)
  public fun setAbsolutePosition(x: Number, y: Number)
  public fun setAnchorElement(element: HTMLElement)
}

public external enum class DefaultFocusState {
  NONE,
  LIST_ROOT,
  FIRST_ITEM,
  LAST_ITEM
}
