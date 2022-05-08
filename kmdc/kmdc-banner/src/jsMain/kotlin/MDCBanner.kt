package dev.petuska.kmdc.banner

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.ContentBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.reinterpret
import dev.petuska.kmdc.core.role
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@JsModule("@material/banner/style.scss")
private external val MDCBannerStyle: dynamic

public interface MDCBannerAttrsScope : AttrsScope<HTMLDivElement>
public interface MDCBannerScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCDsl
@Composable
public fun MDCBanner(
  centered: Boolean = false,
  fixed: Boolean = false,
  mobileStacked: Boolean = false,
  attrs: Builder<MDCBannerAttrsScope>? = null,
  content: ComposableBuilder<MDCBannerScope>? = null,
) {
  MDCBannerStyle
  val innerContent: ContentBuilder<HTMLDivElement> = {
    Div(
      attrs = {
        classes("mdc-banner__content")
        role("alertdialog")
        aria("live", "assertive")
        applyAttrs(attrs)
      },
      content = content.reinterpret()
    )
  }
  Div(
    attrs = {
      classes("mdc-banner")
      role("banner")
      if (centered) classes("mdc-banner--centered")
      if (mobileStacked) classes("mdc-banner--mobile-stacked")
    },
    content = {
      if (fixed) {
        Div(
          attrs = {
            classes("mdc-banner__fixed")
          },
          content = innerContent
        )
      } else {
        innerContent()
      }
    }
  )
}
