package dev.petuska.kmdc.card

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.applyContent
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLDivElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCContentDsl
@Composable
public fun MDCCardScope.PrimaryAction(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCCardScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-card__primary-action")
      tabIndex(0)
      attrs?.invoke(this)
    },
  ) {
    applyContent(content)
    Span(attrs = { classes("mdc-card__ripple") })
  }
}
