import dev.petuska.kmdc.core.Destroyable
import dev.petuska.kmdc.core.MDCEvent
import org.w3c.dom.Element

@JsModule("@material/snackbar")
public external object MDCSnackbarModule {
  public class MDCSnackbar(element: Element) : Destroyable {
    public companion object {
      public fun attachTo(element: Element): MDCSnackbar
    }

    public fun initialize(
      segmentFactory: (
        el: Element,
        foundation: dynamic
      ) -> (() -> (ariaEl: Element, labelEl: Element?) -> Unit) = definedExternally
    )

    public fun initialSyncWithDOM()
    public override fun destroy()
    public fun open()
    public fun close(reason: String = definedExternally)
    public fun getDefaultFoundation(): dynamic
    public var timeoutMs: Number
    public var closeOnEscape: Boolean
    public val isOpen: Boolean
    public var labelText: String
    public var actionButtonText: String
  }

  public interface MDCSnackbarOpenEventDetail
  public interface MDCSnackbarCloseEventDetail {
    public val reason: String?
  }

  public class MDCSnackbarOpenEvent : MDCEvent<MDCSnackbarOpenEventDetail>
  public class MDCSnackbarCloseEvent : MDCEvent<MDCSnackbarCloseEventDetail>
}
