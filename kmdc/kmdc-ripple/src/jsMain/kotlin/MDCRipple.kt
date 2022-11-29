package dev.petuska.kmdc.ripple

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.KMDCInternalAPI
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.MDCProvider
import dev.petuska.kmdc.core.MDCStateEffect
import kotlinx.dom.addClass
import kotlinx.dom.removeClass
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element

@JsModule("@material/ripple/mdc-ripple.scss")
private external val Style: dynamic

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-ripple)
 */
@MDCContentDsl
@Composable
public fun ElementScope<*>.MDCRipple(
  unbounded: Boolean = false,
  disabled: Boolean = false,
) {
  MDCRippleLayout(
    unbounded = unbounded,
    disabled = disabled,
    init = {
      it.addClass("mdc-ripple-surface")
    },
    onDispose = { it.removeClass("mdc-ripple-surface") }
  )
}

@Composable
@KMDCInternalAPI
public fun ElementScope<*>.MDCRippleLayout(
  unbounded: Boolean = false,
  disabled: Boolean = false,
  vararg keys: Any?,
  init: (Element) -> Unit = {},
  onDispose: (Element) -> Unit = {},
) {
  Style
  MDCProvider(
    init = {
      init(it)
      MDCRipple(it)
    },
    keys = keys + unbounded,
    onDispose = { onDispose(it) }
  ) {
    MDCStateEffect(unbounded, MDCRipple::unbounded)
    MDCStateEffect(disabled, MDCRipple::disabled)
  }
}
