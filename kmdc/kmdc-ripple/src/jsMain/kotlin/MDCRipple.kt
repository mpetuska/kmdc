package dev.petuska.kmdc.ripple

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.MDCProvider
import dev.petuska.kmdc.core.MDCStateEffectNew
import kotlinx.dom.addClass
import kotlinx.dom.removeClass
import org.jetbrains.compose.web.dom.ElementScope

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
  Style
  MDCProvider(
    init = {
      it.addClass("mdc-ripple-surface")
      MDCRipple(it)
    },
    keys = arrayOf(unbounded),
    onDispose = { it.removeClass("mdc-ripple-surface") }
  ) {
    MDCStateEffectNew(unbounded, MDCRipple::unbounded)
    MDCStateEffectNew(disabled, MDCRipple::disabled)
  }
}
