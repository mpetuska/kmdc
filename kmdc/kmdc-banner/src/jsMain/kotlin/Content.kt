package dev.petuska.kmdc.banner

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*
import org.jetbrains.compose.web.dom.Text as ComposeText

public interface MDCBannerContentScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCContentDsl
@Composable
public fun MDCBannerScope.Content(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCBannerContentScope>? = null,
) {
  Div(
    attrs = {
      classes("mdc-banner__graphic-text-wrapper")
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCContentDsl
@Composable
public fun MDCBannerContentScope.Text(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCBannerContentScope>? = null,
) {
  Div(
    attrs = {
      classes("mdc-banner__text")
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCContentDsl
@Composable
public fun MDCBannerContentScope.Text(
  text: String,
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
) {
  Text(attrs) { ComposeText(text) }
}

public interface MDCBannerGraphicScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCContentDsl
@Composable
public fun MDCBannerContentScope.Graphic(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCBannerGraphicScope>? = null,
) {
  Div(
    attrs = {
      classes("mdc-banner__graphic")
      role("img")
      attr("alt", "")
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCContentDsl
@Composable
public fun MDCBannerGraphicScope.Icon(
  attrs: MDCAttrsRaw<HTMLElement>? = null,
  content: MDCContent<HTMLElement>? = null,
) {
  I(
    attrs = {
      classes("mdc-banner__icon")
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}
