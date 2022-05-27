@file:JsModule("@material/list")

package dev.petuska.kmdc.list

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.core.MDCLayoutComponent
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCList(element: Element) : MDCComponent<dynamic>, MDCLayoutComponent {
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

  public override fun layout()
  public fun getPrimaryText(item: Element): String
  public fun initializeListType()
  public fun setEnabled(itemIndex: Int, isEnabled: Boolean)
}
