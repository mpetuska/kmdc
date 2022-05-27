package dev.petuska.kmdc.tab.indicator

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

public enum class MDCTabIndicatorType(public vararg val classes: String) {
  Underline("mdc-tab-indicator__content--underline"),
  Icon("mdc-tab-indicator__content--icon")
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab-indicator)
 */
@MDCContentDsl
@Composable
public fun MDCTabIndicatorScope.Content(
  indicatorType: MDCTabIndicatorType,
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContentRaw<HTMLSpanElement>? = null
) {
  Span(
    attrs = {
      classes("mdc-tab-indicator__content")
      classes(indicatorType.classes)
      if (indicatorType == MDCTabIndicatorType.Icon) aria("hidden", true)
      attrs?.invoke(this)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab-indicator)
 */
@MDCContentDsl
@Composable
public fun MDCTabIndicatorScope.Icon(
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContentRaw<HTMLSpanElement>? = null
) {
  Content(MDCTabIndicatorType.Icon, attrs, content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab-indicator)
 */
@MDCContentDsl
@Composable
public fun MDCTabIndicatorScope.Underline(
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContentRaw<HTMLSpanElement>? = null
) {
  Content(MDCTabIndicatorType.Underline, attrs, content)
}
