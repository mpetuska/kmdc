package dev.petuska.kmdc.ripple

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.jsObject
import org.jetbrains.compose.web.dom.ElementScope

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
    val mdc = MDCRippleModule.MDCRipple.attachTo(
      element = it,
      opts = jsObject {
        isUnbounded = options.isUnbounded
      }
    )
    onDispose { mdc.destroy() }
  }
}
