package dev.petuska.kmdc.menu.surface
import dev.petuska.kmdc.core.Destroyable
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement

@JsModule("@material/menu-surface")
public external object MDCMenuSurfaceModule {
  public class MDCMenuSurface(element: Element) : Destroyable {
    public companion object {
      public fun attachTo(element: Element): MDCMenuSurface
    }

    public override fun destroy()

    public var anchorElement: HTMLElement

    public fun isOpen(): Boolean
    public fun open()
    public fun close(skipRestoreFocus: Boolean)
    public fun setAnchorCorner(corner: Corner)
  }
}
