package dev.petuska.kmdc.top.app.bar

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.classes
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Section
import org.w3c.dom.HTMLElement

public class MDCTopAppBarSectionScope(scope: ElementScope<HTMLElement>) : ElementScope<HTMLElement> by scope

public data class MDCTopAppBarSectionOpts(
  var align: Align = Align.Start,
  var role: String? = null,
) {
  public enum class Align(public vararg val classes: String) {
    Start("mdc-top-app-bar__section--align-start"),
    End("mdc-top-app-bar__section--align-end"),
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCDsl
@Composable
public fun MDCTopAppBarRowScope.MDCTopAppBarSection(
  opts: MDCAttrs<MDCTopAppBarSectionOpts>? = null,
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: MDCContent<MDCTopAppBarSectionScope>? = null
) {
  val options = MDCTopAppBarSectionOpts().apply { opts?.invoke(this) }
  Section(
    attrs = {
      classes("mdc-top-app-bar__section")
      classes(options.align.classes)
      options.role?.let {
        attr("role", it)
      }
      attrs?.invoke(this)
    },
    content = content?.let { { MDCTopAppBarSectionScope(this).it() } }
  )
}
