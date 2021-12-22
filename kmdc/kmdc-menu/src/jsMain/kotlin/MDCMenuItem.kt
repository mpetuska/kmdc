package dev.petuska.kmdc.menu

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.list.MDCListItem
import dev.petuska.kmdc.list.MDCListItemScope
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLLIElement
import org.w3c.dom.HTMLUListElement

public data class MDCMenuListItemOpts(
  public var text: String? = null,
  public var disabled: Boolean = false,
  public var selected: Boolean = false,
  public var activated: Boolean = false
)

public class MDCMenuListItemScope<T : HTMLElement>(scope: MDCListItemScope<T>) : MDCListItemScope<T>(scope)

@MDCDsl
@Composable
public fun MDCMenuListScope<HTMLUListElement>.MDCMenuListItem(
  opts: Builder<MDCMenuListItemOpts>? = null,
  attrs: Builder<AttrsBuilder<HTMLLIElement>>? = null,
  content: ComposableBuilder<MDCMenuListItemScope<HTMLLIElement>>? = null,
) {
  val options = MDCMenuListItemOpts().apply { opts?.invoke(this) }
  listScope.MDCListItem(attrs = {
    attr("role", "menuitem")
    attrs?.invoke(this)
  }, opts = {
    activated = options.activated
    disabled = options.disabled
    selected = options.selected
  }) {
    content?.let { MDCMenuListItemScope(this).it() }
    options.text?.let { Span({ classes("mdc-deprecated-list-item__text") }) { Text(it) } }
  }
}
