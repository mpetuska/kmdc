package dev.petuska.kmdc.menu.surface

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@MDCDsl
@Composable
public fun MDCMenuSurfaceAnchor(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null,
) {
  Div(
    attrs = {
      classes("mdc-menu-surface--anchor")
      applyAttrs(attrs)
    },
    content = content
  )
}
