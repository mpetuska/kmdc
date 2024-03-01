@file:JsModule("@material/segmented-button")

package dev.petuska.kmdc.segmented.button

import dev.petuska.kmdc.core.MDCComponent
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.ripple.MDCRipple
import org.w3c.dom.Element

@MDCExternalAPI
public external class MDCSegmentedButton(element: Element) : MDCComponent<dynamic> {
  public val segments: Array<MDCSegmentedButtonSegment>
  public fun initialize(
    segmentFactory: (
      el: Element,
      foundation: dynamic
    ) -> MDCSegmentedButtonSegment = definedExternally
  )

  public fun getSelectedSegments(): Array<dynamic>
  public fun selectSegment(indexOrSegmentId: dynamic)
  public fun unselectSegment(indexOrSegmentId: dynamic)
  public fun isSegmentSelected(indexOrSegmentId: dynamic): Boolean
}

@MDCExternalAPI
public external class MDCSegmentedButtonSegment(element: Element) : MDCComponent<dynamic> {
  public var ripple: MDCRipple
  public fun initialize(rippleFactory: (el: Element, foundation: dynamic) -> MDCRipple)
  public fun setIndex(index: Number)
  public fun setIsSingleSelect(isSingleSelect: Boolean)
  public fun isSelected(): Boolean
  public fun setSelected()
  public fun setUnselected()
  public fun getSegmentId(): String?
}
