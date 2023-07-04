@file:JsModule("@material/chips")

package dev.petuska.kmdc.chips

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

public external enum class MDCChipActionType { UNSPECIFIED, PRIMARY, TRAILING }

@MDCExternalAPI
public external class MDCChipSet(element: Element) : MDCComponent<dynamic> {
  public companion object {
    public fun attachTo(element: Element): MDCChipSet
    public fun getChipIndexByID(chipID: String): Int
    public fun getChipIdAtIndex(index: Int): String
    public fun getSelectedChipIndexes(): Set<Int>
    public fun setChipSelected(index: Int, action: MDCChipActionType, isSelected: Boolean)
    public fun isChipSelected(index: Int, action: MDCChipActionType): Boolean
    public fun removeChip(index: Int): Boolean
  }
}
