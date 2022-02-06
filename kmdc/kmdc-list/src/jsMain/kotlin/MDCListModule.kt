package dev.petuska.kmdc.list

import dev.petuska.kmdc.core.MDCBaseModule
import org.w3c.dom.Element
import org.w3c.dom.events.Event

@JsModule("@material/list")
public external object MDCListModule {
  public class MDCList(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public companion object {
      public fun attachTo(element: Element): MDCList
    }

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
