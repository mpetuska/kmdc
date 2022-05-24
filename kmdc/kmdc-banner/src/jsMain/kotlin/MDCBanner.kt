package dev.petuska.kmdc.banner

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

@JsModule("@material/banner/styles.scss")
private external val Style: dynamic

public interface MDCBannerAttrsScope : AttrsScope<HTMLDivElement>
public interface MDCBannerScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCDsl
@Composable
public fun MDCBanner(
  open: Boolean,
  centered: Boolean = false,
  fixed: Boolean = false,
  mobileStacked: Boolean = false,
  attrs: MDCAttrs<MDCBannerAttrsScope>? = null,
  content: MDCContent<MDCBannerScope>? = null,
) {
  Style
  Div(attrs = {
    classes("mdc-banner")
    role("banner")
    if (centered) classes("mdc-banner--centered")
    if (mobileStacked) classes("mdc-banner--mobile-stacked")
    applyAttrs(attrs)
  }) {
    MDCProvider(::MDCBanner) {
      MDCSideEffectNew<MDCBanner>(open, centered, mobileStacked) {
        if (open) open() else close(CloseReason.UNSPECIFIED)
      }
      if (fixed) {
        Div(attrs = {
          classes("mdc-banner__fixed")
        }, content = { InnerContent(content) })
      } else {
        InnerContent(content)
      }
    }
  }
}

@Composable
private fun InnerContent(
  content: MDCContent<MDCBannerScope>? = null,
) {
  Div(
    attrs = {
      classes("mdc-banner__content")
      role("alertdialog")
      aria("live", "assertive")
    }, content = content.reinterpret()
  )
}
