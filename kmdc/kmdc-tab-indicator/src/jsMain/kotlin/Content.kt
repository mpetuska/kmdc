package dev.petuska.kmdc.tab.indicator

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.Classes
import dev.petuska.kmdc.core.ContentBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.classes
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

public enum class MDCTabIndicator(public val classes: Classes = listOf()) {
  Underline(listOf("mdc-tab-indicator__content--underline")),
  Icon(listOf("mdc-tab-indicator__content--icon"))
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-tab-indicator)
 */
@MDCDsl
@Composable
public fun MDCTabIndicatorScope.Content(
  indicator: MDCTabIndicator,
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null
) {
  Span(
    attrs = {
      classes("mdc-tab-indicator__content")
      classes(indicator.classes)
      if (indicator == MDCTabIndicator.Icon) aria("hidden", true)
      attrs?.invoke(this)
    },
    content = content
  )
}
