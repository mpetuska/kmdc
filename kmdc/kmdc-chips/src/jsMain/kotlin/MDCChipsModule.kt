package dev.petuska.kmdc.chips

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.MDCExternalAPI
import org.w3c.dom.Element

@MDCExternalAPI
@JsModule("@material/chips")
public external object MDCChipsModule {
  public enum class MDCChipActionType { UNSPECIFIED, PRIMARY, TRAILING }

  public class MDCChipSet(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public companion object {
      public fun attachTo(element: Element): MDCChipSet
      public fun getChipIndexByID(chipID: String): Int
      public fun getChipIdAtIndex(index: Int): String
      public fun getSelectedChipIndexes(): Set<Int>
      public fun setChipSelected(index: Int, action: MDCChipActionType, isSelected: Boolean)
      public fun isChipSelected(index: Int, action: MDCChipActionType): Boolean
      public fun removeChip(index: Int): Boolean
    }

    public class InteractionEvent : MDCEvent<InteractionEvent.Detail> {
      public interface Detail {
        public val chipID: String
        public val chipIndex: Int
      }
    }

    public class RemovalEvent : MDCEvent<RemovalEvent.Detail> {
      public interface Detail : InteractionEvent.Detail {
        public val isComplete: Boolean
      }
    }

    public class SelectionEvent : MDCEvent<SelectionEvent.Detail> {
      public interface Detail : InteractionEvent.Detail {
        public val isSelected: Boolean
      }
    }
  }
}
