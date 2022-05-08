package dev.petuska.kmdc.banner

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.reinterpret
import dev.petuska.kmdc.core.role
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.I
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import org.jetbrains.compose.web.dom.Text as ComposeText

public interface MDCBannerContentScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCDsl
@Composable
public fun MDCBannerScope.Content(
  attrs: AttrsBuilder<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCBannerContentScope>? = null,
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
@MDCDsl
@Composable
public fun MDCBannerContentScope.Text(
  attrs: AttrsBuilder<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCBannerContentScope>? = null,
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
@MDCDsl
@Composable
public fun MDCBannerContentScope.Text(
  text: String,
  attrs: AttrsBuilder<HTMLDivElement>? = null,
) {
  Text(attrs) { ComposeText(text) }
}

public interface MDCBannerGraphicScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCDsl
@Composable
public fun MDCBannerContentScope.Graphic(
  attrs: AttrsBuilder<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCBannerGraphicScope>? = null,
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
@MDCDsl
@Composable
public fun MDCBannerGraphicScope.Icon(
  attrs: AttrsBuilder<HTMLElement>? = null,
  content: ComposableBuilder<HTMLElement>? = null,
) {
  I(
    attrs = {
      classes("mdc-banner__icon")
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}
