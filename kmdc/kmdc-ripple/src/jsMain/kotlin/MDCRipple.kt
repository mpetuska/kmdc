package dev.petuska.kmdc.ripple

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-ripple)
 */
@MDCContentDsl
@Composable
public fun ElementScope<*>.MDCRipple(
  unbounded: Boolean = false
) {
  MDCProvider(::MDCRipple) {
    MDCStateEffectNew(unbounded, MDCRipple::unbounded)
  }
}
