package dev.petuska.kmdc.segmented.button

import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.ripple.MDCRippleModule
import org.w3c.dom.Element

@JsModule("@material/segmented-button")
public external object MDCSegmentedButtonModule {
  public class MDCSegmentedButton(element: Element) {
    public companion object {
      public fun attachTo(element: Element): MDCSegmentedButton
    }

    public val segments: Array<MDCSegmentedButtonSegment>
    public fun initialize(
      segmentFactory: (
        el: Element,
        foundation: dynamic
      ) -> MDCSegmentedButtonSegment = definedExternally
    )

    public fun initialSyncWithDOM()
    public fun destroy()
    public fun getDefaultFoundation(): dynamic
    public fun getSelectedSegments(): Array<dynamic>
    public fun selectSegment(indexOrSegmentId: dynamic)
    public fun unselectSegment(indexOrSegmentId: dynamic)
    public fun isSegmentSelected(indexOrSegmentId: dynamic): Boolean
  }

  public class MDCSegmentedButtonSegment(element: Element) {
    public companion object {
      public fun attachTo(element: Element): MDCSegmentedButtonSegment
    }

    public var ripple: MDCRippleModule.MDCRipple
    public fun initialize(rippleFactory: (el: Element, foundation: dynamic) -> MDCRippleModule.MDCRipple)
    public fun initialSyncWithDOM()
    public fun destroy()
    public fun getDefaultFoundation(): dynamic
    public fun setIndex(index: Number)
    public fun setIsSingleSelect(isSingleSelect: Boolean)
    public fun isSelected(): Boolean
    public fun setSelected()
    public fun setUnselected()
    public fun getSegmentId(): dynamic
  }

  public interface SegmentDetail {
    public val index: Number
    public val selected: Boolean
    public val segmentId: String?
  }

  public class MDCSegmentedButtonEvent : MDCEvent<SegmentDetail>

  public class MDCSegmentedButtonSegmentEvent : MDCEvent<SegmentDetail>
  public class MDCSegmentedButtonSegmentClickEvent : MDCEvent<Number>
}
