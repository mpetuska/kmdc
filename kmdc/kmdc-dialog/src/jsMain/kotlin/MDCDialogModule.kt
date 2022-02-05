package dev.petuska.kmdc.dialog

import dev.petuska.kmdc.core.MDCBaseModule
import dev.petuska.kmdc.core.MDCEvent
import org.w3c.dom.Element

@JsModule("@material/dialog")
public external object MDCDialogModule {
  public class MDCDialog(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public companion object {
      public fun attachTo(element: Element): MDCDialog
    }

    public val open: Boolean
    public var scrimClickAction: String?
    public var escapeKeyAction: String?
    public var autoStackButtons: Boolean

    public fun open()
    public fun close(action: String)
  }

  @Suppress("ClassName")
  public object strings {
    public val ACTION_ATTRIBUTE: String
    public val BUTTON_DEFAULT_ATTRIBUTE: String
    public val CLOSED_EVENT: String
    public val CLOSING_EVENT: String
    public val OPENED_EVENT: String
    public val OPENING_EVENT: String
    public val INITIAL_FOCUS_ATTRIBUTE: String
  }

  @Suppress("ClassName")
  public object cssClasses {
    public val STACKED: String
    public val FULLSCREEN: String
  }

  public interface MDCDialogOpenEventDetail

  public class MDCDialogOpenEvent : MDCEvent<MDCDialogOpenEventDetail>

  public class MDCDialogCloseEventDetail {
    public val action: String?
  }

  public class MDCDialogCloseEvent : MDCEvent<MDCDialogCloseEventDetail>
}
