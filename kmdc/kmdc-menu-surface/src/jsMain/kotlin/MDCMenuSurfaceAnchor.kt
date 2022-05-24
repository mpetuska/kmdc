package dev.petuska.kmdc.menu.surface

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.*

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
