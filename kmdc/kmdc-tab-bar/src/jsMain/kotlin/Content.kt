package dev.petuska.kmdc.tab

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.core.ContentBuilder
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

public interface MDCTabContentScope : ElementScope<HTMLSpanElement>, MDCTabBaseScope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tab)
 */
@MDCDsl
@Composable
public fun MDCTabScope.Content(
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
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
@MDCDsl
@Composable
public fun MDCTabContentScope.Icon(
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null
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
@MDCDsl
@Composable
public fun MDCTabContentScope.Label(
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null
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
@MDCDsl
@Composable
public fun MDCTabContentScope.Label(
  text: String,
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
) {
  Label(attrs = attrs, content = { Text(text) })
}
