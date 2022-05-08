@file:Suppress("ClassName")

package dev.petuska.kmdc.data.table

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
@JsModule("@material/data-table")
public external object MDCDataTableModule {
  public class MDCDataTable(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
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

  public interface ProgressIndicatorStyles {
    public var height: String
    public var top: String
  }
}
