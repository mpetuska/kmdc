package dev.petuska.kmdc.list

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Hr
import org.jetbrains.compose.web.dom.Li
import org.w3c.dom.HTMLHRElement
import org.w3c.dom.HTMLLIElement

public class MDCListDividerOpts(
  public var inset: Inset = Inset.None,
) {
  public enum class Inset(public vararg var classes: String) {
    None,
    Leading("mdc-deprecated-list-divider--inset-leading"),
    Trailing("mdc-deprecated-list-divider--inset-trailing"),
    Padding("mdc-deprecated-list-divider--inset-padding")
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListScope<*>.MDCListDivider(
  opts: Builder<MDCListDividerOpts>? = null,
  attrs: Builder<AttrsScope<HTMLLIElement>>? = null,
  content: ContentBuilder<HTMLLIElement>? = null,
) {
  val options = MDCListDividerOpts().apply { opts?.invoke(this) }
  Li(
    attrs = {
      classes("mdc-deprecated-list-divider", *options.inset.classes)
      attr("role", "separator")
      attrs?.invoke(this)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListGroupScope.MDCListDivider(
  opts: Builder<MDCListDividerOpts>? = null,
  attrs: Builder<AttrsScope<HTMLHRElement>>? = null,
) {
  val options = MDCListDividerOpts().apply { opts?.invoke(this) }
  Hr(
    attrs = {
      classes("mdc-deprecated-list-divider", *options.inset.classes)
      attrs?.invoke(this)
    },
  )
}
