package dev.petuska.kmdc.menu.surface

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@MDCDsl
@Composable
public fun MDCMenuSurfaceAnchor(
  attrs: Builder<AttrsScope<HTMLDivElement>>? = null,
  content: ContentBuilder<HTMLDivElement>? = null,
) {
  Div(
    attrs = {
      classes("mdc-menu-surface--anchor")
      attrs?.invoke(this.unsafeCast<AttrsScope<HTMLDivElement>>())
    },
    content = content
  )
}
