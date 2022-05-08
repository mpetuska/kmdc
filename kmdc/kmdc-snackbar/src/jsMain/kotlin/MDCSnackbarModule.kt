import dev.petuska.kmdc.core.MDCBaseModule
import org.w3c.dom.Element

@JsModule("@material/snackbar")
public external object MDCSnackbarModule {
  public class MDCSnackbar(element: Element) : MDCBaseModule.MDCComponent<dynamic> {
    public companion object {
      public fun attachTo(element: Element): MDCSnackbar
    }

    public fun initialize(
      segmentFactory: (
        el: Element,
        foundation: dynamic
      ) -> (() -> (ariaEl: Element, labelEl: Element?) -> Unit) = definedExternally
    )

    public fun open()
    public fun close(reason: String = definedExternally)
    public var timeoutMs: Number
    public var closeOnEscape: Boolean
    public val isOpen: Boolean
    public var labelText: String
    public var actionButtonText: String
  }

  public interface MDCSnackbarCloseEventDetail {
    public val reason: String?
  }
}
