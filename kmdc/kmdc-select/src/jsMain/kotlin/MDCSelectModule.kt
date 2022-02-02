package dev.petuska.kmdc.select

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCEvent
import org.w3c.dom.Element

@JsModule("@material/select")
public external object MDCSelectModule {
  public class MDCSelect<T>(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public companion object {
      public fun <T> attachTo(element: Element): MDCSelect<T>
    }

    public var value: String?

    public fun setValue(value: String?, skipNotify: Boolean)

    public var disabled: Boolean

    public var required: Boolean

    public var items: List<T>
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
