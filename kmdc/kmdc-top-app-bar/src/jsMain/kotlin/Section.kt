package dev.petuska.kmdc.top.app.bar

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.classes
import dev.petuska.kmdc.core.reinterpret
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLElement

public interface MDCTopAppBarSectionScope : ElementScope<HTMLElement>

public enum class MDCTopAppBarSectionAlign(public vararg val classes: String) {
  Start("mdc-top-app-bar__section--align-start"),
  End("mdc-top-app-bar__section--align-end"),
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCContentDsl
@Composable
public fun MDCTopAppBarRowScope.Section(
  align: MDCTopAppBarSectionAlign = MDCTopAppBarSectionAlign.Start,
  role: String? = null,
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: MDCContent<MDCTopAppBarSectionScope>? = null
) {
  org.jetbrains.compose.web.dom.Section(
    attrs = {
      classes("mdc-top-app-bar__section")
      classes(align.classes)
      role?.let {
        attr("role", it)
      }
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}
