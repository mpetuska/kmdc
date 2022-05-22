package dev.petuska.kmdc.ripple

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCProvider
import dev.petuska.kmdc.core.MDCStateEffectNew
import org.jetbrains.compose.web.dom.ElementScope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-ripple)
 */
@MDCDsl
@Composable
public fun ElementScope<*>.MDCRipple(
  unbounded: Boolean = false
) {
  MDCProvider(::MDCRipple) {
    MDCStateEffectNew(unbounded, MDCRipple::unbounded)
  }
}
