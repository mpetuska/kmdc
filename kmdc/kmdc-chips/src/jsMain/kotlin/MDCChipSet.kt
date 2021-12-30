package dev.petuska.kmdc.chips

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element

@JsModule("@material/chips/dist/mdc.chips.css")
private external val MDCChipsCSS: dynamic

@JsModule("@material/chips")
public external object MDCChipsModule {
  public class MDCChipSet(element: Element) {
    public companion object {
      public fun attachTo(element: Element): MDCChipSet
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
