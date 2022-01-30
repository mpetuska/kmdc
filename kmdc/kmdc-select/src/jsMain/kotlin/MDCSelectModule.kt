package dev.petuska.kmdc.select

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCEvent
import org.w3c.dom.Element

@JsModule("@material/select")
public external object MDCSelectModule {
  public class MDCSelect(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public companion object {
      public fun attachTo(element: Element): MDCSelect
    }

    public var value: String?

    public fun setValue(value: String?, skipNotify: Boolean)

    public var disabled: Boolean

    public var required: Boolean
  }

  public class MDCSelectHelperText(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public companion object {
      public fun attachTo(element: Element): MDCSelectHelperText
    }
  }

  @Suppress("ClassName")
  public object strings {
    public val CHANGE_EVENT: String
  }

  public class MDCSelectChangeEventDetail {
    public val value: String
    public val index: Int
  }

  public class MDCSelectChangeEvent : MDCEvent<MDCSelectChangeEventDetail>
}
