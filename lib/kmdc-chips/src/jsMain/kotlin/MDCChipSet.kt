package dev.petuska.kmdc.chips

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element

@JsModule("@material/chips/dist/mdc.chips.css")
private external val MDCChipsCSS: dynamic

@JsModule("@material/chips")
private external object MDCChipsModule {
  class MDCChipSet(element: Element) {
    companion object {
      fun attachTo(element: Element)
    }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
public fun ElementScope<*>.MDCChipSet() {
  MDCChipsCSS
}
