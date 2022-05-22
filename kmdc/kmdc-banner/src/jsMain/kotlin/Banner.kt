package dev.petuska.kmdc.banner

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCInitEffect
import dev.petuska.kmdc.core.MDCSideEffect
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.reinterpret
import dev.petuska.kmdc.core.role
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@JsModule("@material/banner/styles.scss")
private external val MDCBannerStyles: dynamic

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
  MDCBannerStyles
  Div(attrs = {
    classes("mdc-banner")
    role("banner")
    if (centered) classes("mdc-banner--centered")
    if (mobileStacked) classes("mdc-banner--mobile-stacked")
    applyAttrs(attrs)
  }) {
    MDCInitEffect(::MDCBanner)
    MDCSideEffect<MDCBanner>(open, centered, mobileStacked) {
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
