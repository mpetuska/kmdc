package dev.petuska.kmdc.menu

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.list.MDCListItem
import dev.petuska.kmdc.list.MDCListItemOpts
import dev.petuska.kmdc.list.MDCListItemScope
import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.HTMLLIElement

@MDCDsl
@Composable
public fun MDCMenuScope.MDCMenuItem(
  opts: Builder<MDCListItemOpts>? = null,
  attrs: Builder<AttrsScope<HTMLLIElement>>? = null,
  content: ComposableBuilder<MDCListItemScope<HTMLLIElement>>? = null,
) {
  MDCListItem(attrs = {
    attrs?.invoke(this)
  }, opts = opts, content = content)
}
