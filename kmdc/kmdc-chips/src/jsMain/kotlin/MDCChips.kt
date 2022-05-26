package dev.petuska.kmdc.chips

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

@JsModule("@material/chips/styles.scss")
private external val Style: dynamic

public interface MDCChipsAttrsScope : AttrsScope<HTMLSpanElement>

public interface MDCChipsScope : ElementScope<HTMLSpanElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCContentDsl
@Composable
internal fun MDCChips(
  overflow: Boolean = false,
  attrs: MDCAttrs<MDCChipsAttrsScope>? = null,
  content: MDCContent<MDCChipsScope>? = null
) {
  Style
  Span(
    attrs = {
      classes("mdc-evolution-chip-set")
      if (overflow) classes("mdc-evolution-chip-set--overflow")
      applyAttrs(attrs)
    },
  ) {
    MDCProvider(::MDCChipSet) {
      Span(
        attrs = {
          classes("mdc-evolution-chip-set__chips")
          role("presentation")
        }, content = content.reinterpret()
      )
    }
  }
}
