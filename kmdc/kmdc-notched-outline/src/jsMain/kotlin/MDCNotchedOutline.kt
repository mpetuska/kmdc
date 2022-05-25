package dev.petuska.kmdc.notched.outline

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

@JsModule("@material/notched-outline/mdc-notched-outline.scss")
private external val Style: dynamic

public interface MDCNotchedOutlineScope : ElementScope<HTMLSpanElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-notched-outline)
 */
@MDCDsl
@Composable
public fun MDCNotchedOutline(
  notched: Boolean = false,
  noLabel: Boolean = false,
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContent<MDCNotchedOutlineScope>? = null,
) {
  MDCNotchedOutlineLayout(
    notched = notched,
    noLabel = noLabel,
    attrs = attrs,
  ) {
    MDCProvider(::MDCNotchedOutline) {
      applyContent(content)
    }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-notched-outline)
 */
@Composable
@KMDCInternalAPI
public fun MDCNotchedOutlineLayout(
  notched: Boolean = false,
  noLabel: Boolean = false,
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContent<MDCNotchedOutlineScope>? = null,
) {
  Style
  Span(
    attrs = {
      classes("mdc-notched-outline")
      if (notched) classes("mdc-notched-outline--notched")
      if (noLabel) classes("mdc-notched-outline--no-label")
      attrs?.invoke(this)
    },
    content = content.reinterpret(),
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-notched-outline)
 */
@MDCDsl
@Composable
public fun MDCNotchedOutlineScope.Leading(
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContentRaw<HTMLSpanElement>? = null,
) {
  Span(attrs = {
    classes("mdc-notched-outline__leading")
    applyAttrs(attrs)
  }, content = content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-notched-outline)
 */
@MDCDsl
@Composable
public fun MDCNotchedOutlineScope.Notch(
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContentRaw<HTMLSpanElement>? = null,
) {
  Span(attrs = {
    classes("mdc-notched-outline__notch")
    applyAttrs(attrs)
  }, content = content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-notched-outline)
 */
@MDCDsl
@Composable
public fun MDCNotchedOutlineScope.Trailing(
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContentRaw<HTMLSpanElement>? = null,
) {
  Span(attrs = {
    classes("mdc-notched-outline__trailing")
    applyAttrs(attrs)
  }, content = content)
}
