package dev.petuska.kmdc.chips

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.initialiseMDC
import dev.petuska.kmdc.core.reinterpret
import dev.petuska.kmdc.core.role
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

@JsModule("@material/chips/styles.scss")
private external val MDCChipsStyle: dynamic

public interface MDCChipsAttrsScope : AttrsScope<HTMLSpanElement>
public interface MDCChipsScope : ElementScope<HTMLSpanElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
internal fun MDCChips(
  overflow: Boolean = false,
  attrs: Builder<MDCChipsAttrsScope>? = null,
  content: ComposableBuilder<MDCChipsScope>? = null
) {
  MDCChipsStyle
  Span(attrs = {
    classes("mdc-evolution-chip-set")
    if (overflow) classes("mdc-evolution-chip-set--overflow")
    initialiseMDC(MDCChipsModule::MDCChipSet)
    applyAttrs(attrs)
  }, content = {
    Span(
      attrs = {
        classes("mdc-evolution-chip-set__chips")
        role("presentation")
      }, content = content.reinterpret()
    )
  })
}
