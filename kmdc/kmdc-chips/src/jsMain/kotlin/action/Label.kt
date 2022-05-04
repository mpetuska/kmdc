package dev.petuska.kmdc.chips.action

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.ContentBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
public fun MDCChipActionScope<*>.Label(
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null
) {
  Span(
    attrs = {
      classes("mdc-evolution-chip__text-label")
      applyAttrs(attrs)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
public fun MDCChipActionScope<*>.Label(
  text: String,
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
) {
  Label(attrs) { Text(text) }
}
