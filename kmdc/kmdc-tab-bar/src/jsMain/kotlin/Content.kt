package dev.petuska.kmdc.tab

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

public interface MDCTabContentScope : ElementScope<HTMLSpanElement>, MDCTabBaseScope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab)
 */
@MDCContentDsl
@Composable
public fun MDCTabScope.Content(
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContent<MDCTabContentScope>? = null
) {
  Span(
    attrs = {
      classes("mdc-tab__content")
      applyAttrs(attrs)
    },
    content = content.reinterpret(),
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab)
 */
@MDCContentDsl
@Composable
public fun MDCTabContentScope.Icon(
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContentRaw<HTMLSpanElement>? = null
) {
  Span(
    attrs = {
      classes("mdc-tab__icon")
      aria("hidden", true)
      applyAttrs(attrs)
    },
    content = content,
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab)
 */
@MDCContentDsl
@Composable
public fun MDCTabContentScope.Label(
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContentRaw<HTMLSpanElement>? = null
) {
  Span(
    attrs = {
      classes("mdc-tab__text-label")
      applyAttrs(attrs)
    },
    content = content,
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab)
 */
@MDCContentDsl
@Composable
public fun MDCTabContentScope.Label(
  text: String,
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
) {
  Label(attrs = attrs, content = { Text(text) })
}
