package dev.petuska.kmdc.top.app.bar

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

public class MDCTopAppBarRowScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCDsl
@Composable
public fun MDCTopAppBarScope.MDCTopAppBarRow(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCTopAppBarRowScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-top-app-bar__row")
      attrs?.invoke(this)
    },
    content = content?.let { { MDCTopAppBarRowScope(this).it() } }
  )
}
