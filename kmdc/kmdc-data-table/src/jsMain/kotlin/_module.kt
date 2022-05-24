@file:JsModule("@material/data-table")

package dev.petuska.kmdc.data.table

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCDataTable(element: Element) : MDCComponent<dynamic> {
  public fun layout()
  public fun getHeaderCells(): Array<Element>
  public fun getRows(): Array<Element>
  public fun getSelectedRowIds(): Array<String?>
  public fun setSelectedRowIds(vararg rowIds: String)
  public fun showProgress()
  public fun hideProgress()
}

public external enum class SortValue {
  ASCENDING,
  DESCENDING,
  NONE,
  OTHER
}

public external interface ProgressIndicatorStyles {
  public var height: String
  public var top: String
}
