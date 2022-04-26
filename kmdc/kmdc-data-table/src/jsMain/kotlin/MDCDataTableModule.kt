@file:Suppress("ClassName")

package dev.petuska.kmdc.data.table

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement

@MDCExternalAPI
@JsModule("@material/data-table")
public external object MDCDataTableModule {
  public class MDCDataTable(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public companion object {
      public fun attachTo(element: Element): MDCDataTable
    }

    public fun layout()
    public fun getHeaderCells(): Array<Element>
    public fun getRows(): Array<Element>
    public fun getSelectedRowIds(): Array<String?>
    public fun setSelectedRowIds(vararg rowIds: String)
    public fun showProgress()
    public fun hideProgress()
  }

  public object SortValue {
    public val ASCENDING: SortValue
    public val DESCENDING: SortValue
    public val NONE: SortValue
    public val OTHER: SortValue
  }

  public object events {
    public val ROW_SELECTION_CHANGED: String
    public val ROW_CLICK: String
    public val SELECTED_ALL: String
    public val UNSELECTED_ALL: String
    public val SORTED: String
  }

  public abstract class MDCRowSelectionChangedEvent : MDCEvent<MDCDataTableRowSelectionChangedEventDetail>
  public abstract class MDCRowClickEvent : MDCEvent<RowClickEventDetail>
  public abstract class MDCSelectedAllEvent : MDCEvent<Unit>
  public abstract class MDCSortedEvent : MDCEvent<SortActionEventDetail>

  public interface MDCDataTableRowSelectionChangedEventDetail {
    public val rowNumber: Number
    public val rowId: String?
    public val rowIndex: Int
    public val selected: Boolean?
  }

  public interface SortActionEventData {
    public val columnId: String?
    public val columnIndex: Number
    public val headerCell: HTMLElement
  }

  public interface SortActionEventDetail : SortActionEventData {
    public val sortValue: SortValue
  }

  public interface RowClickEventData {
    public val rowId: String?
    public val row: HTMLElement
  }

  public interface RowClickEventDetail : RowClickEventData

  public interface ProgressIndicatorStyles {
    public var height: String
    public var top: String
  }
}
