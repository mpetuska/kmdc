package dev.petuska.kmdc.ripple

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.jsObject
import org.jetbrains.compose.web.dom.ElementScope

public data class MDCRippleOpts(var isUnbounded: Boolean = false)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-ripple)
 */
@MDCDsl
@Composable
public fun ElementScope<*>.MDCRipple(
  opts: MDCAttrs<MDCRippleOpts>? = null
) {
  val options = MDCRippleOpts().apply { opts?.invoke(this) }
  DisposableEffect(null) {
    val mdc = MDCRippleModule.MDCRipple.attachTo(
      element = scopeElement,
      opts = jsObject {
        isUnbounded = options.isUnbounded
      }
    )
    onDispose { mdc.destroy() }
  }
}
