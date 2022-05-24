@file:JsModule("@material/list")

package dev.petuska.kmdc.list

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCList(element: Element) : MDCComponent<dynamic> {
  public var vertical: Boolean
  public val listElements: Array<Element>
  public var wrapFocus: Boolean
  public val typeaheadInProgress: Boolean
  public var hasTypeahead: Boolean
  public var singleSelection: Boolean

  /**
   * type: `number | number[]`
   */
  public var selectedIndex: dynamic

  public fun layout()
  public fun getPrimaryText(item: Element): String
  public fun initializeListType()
  public fun setEnabled(itemIndex: Int, isEnabled: Boolean)
}

public external interface MDCListActionEventDetail {
  public val index: Int
}
