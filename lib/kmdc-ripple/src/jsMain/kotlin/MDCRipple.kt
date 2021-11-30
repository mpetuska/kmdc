package dev.petuska.kmdc.ripple

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.css.jsObject
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element

@JsModule("@material/ripple")
public external object MDCRippleModule {
  public interface MDCRippleAttachOpts {
    public var isUnbounded: Boolean?
  }

  public class MDCRipple(element: Element, opts: MDCRippleAttachOpts = definedExternally) {
    public companion object {
      public fun attachTo(element: Element, opts: MDCRippleAttachOpts = definedExternally): MDCRipple
    }
  }
}

public data class MDCRippleOpts(var isUnbounded: Boolean = false)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-ripple)
 */
@MDCDsl
@Composable
public fun ElementScope<*>.MDCRipple(
  opts: Builder<MDCRippleOpts>? = null
) {
  val options = MDCRippleOpts().apply { opts?.invoke(this) }
  DisposableRefEffect {
    MDCRippleModule.MDCRipple.attachTo(
      element = it,
      opts = jsObject {
        isUnbounded = options.isUnbounded
      }
    )
    onDispose {}
  }
}
