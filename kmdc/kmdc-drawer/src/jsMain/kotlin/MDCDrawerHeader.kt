package dev.petuska.kmdc.drawer

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLHeadingElement

public class MDCDrawerHeaderScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-drawer)
 */
@MDCDsl
@Composable
public fun MDCDrawerScope.MDCDrawerHeader(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCDrawerHeaderScope>? = null,
) {
  Div(
    attrs = {
      classes("mdc-drawer__header")
      attrs?.invoke(this)
    },
    content = content?.let { { MDCDrawerHeaderScope(this).it() } },
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-drawer)
 */
@MDCDsl
@Composable
public fun MDCDrawerScope.MDCDrawerHeader(
  text: String,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
): Unit = MDCDrawerHeader(attrs) { Text(text) }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-drawer)
 */
@MDCDsl
@Composable
public fun MDCDrawerScope.MDCDrawerTitle(
  attrs: AttrBuilderContext<HTMLHeadingElement>? = null,
  content: ContentBuilder<HTMLHeadingElement>? = null
) {
  H3(
    attrs = {
      classes("mdc-drawer__title")
      attrs?.invoke(this)
    },
    content = content,
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-drawer)
 */
@MDCDsl
@Composable
public fun MDCDrawerScope.MDCDrawerTitle(
  text: String,
  attrs: AttrBuilderContext<HTMLHeadingElement>? = null,
): Unit = MDCDrawerTitle(attrs) { Text(text) }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-drawer)
 */
@MDCDsl
@Composable
public fun MDCDrawerScope.MDCDrawerSubtitle(
  attrs: AttrBuilderContext<HTMLHeadingElement>? = null,
  content: ContentBuilder<HTMLHeadingElement>? = null
) {
  H6(
    attrs = {
      classes("mdc-drawer__subtitle")
      attrs?.invoke(this)
    },
    content = content,
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-drawer)
 */
@MDCDsl
@Composable
public fun MDCDrawerScope.MDCDrawerSubtitle(
  text: String,
  attrs: AttrBuilderContext<HTMLHeadingElement>? = null,
): Unit = MDCDrawerSubtitle(attrs) { Text(text) }
