package dev.petuska.kmdc.tab

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.ContentBuilder
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.reinterpret
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

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
