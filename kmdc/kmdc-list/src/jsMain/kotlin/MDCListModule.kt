package dev.petuska.kmdc.list

import dev.petuska.kmdc.core.*
import org.w3c.dom.*
import org.w3c.dom.events.*

@JsModule("@material/list")
public external object MDCListModule {
  public class MDCList(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
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

  public interface MDCListActionEventDetail {
    public val index: Int
  }

  public class MDCListActionEvent : Event {
    public val detail: MDCListActionEventDetail
  }
}
