package dev.petuska.kmdc.chips

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

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
  attrs: MDCAttrs<MDCChipsAttrsScope>? = null,
  content: MDCContent<MDCChipsScope>? = null
) {
  MDCChipsStyle
  Span(attrs = {
    classes("mdc-evolution-chip-set")
    if (overflow) classes("mdc-evolution-chip-set--overflow")
    applyAttrs(attrs)
  }, content = {
    MDCInitEffect(MDCChipsModule::MDCChipSet)
    Span(
      attrs = {
        classes("mdc-evolution-chip-set__chips")
        role("presentation")
      }, content = content.reinterpret()
    )
  })
}
