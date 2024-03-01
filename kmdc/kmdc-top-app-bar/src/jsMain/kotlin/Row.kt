package dev.petuska.kmdc.top.app.bar

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.reinterpret
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

public interface MDCTopAppBarRowScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCContentDsl
@Composable
public fun MDCTopAppBarScope.Row(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCTopAppBarRowScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-top-app-bar__row")
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}
