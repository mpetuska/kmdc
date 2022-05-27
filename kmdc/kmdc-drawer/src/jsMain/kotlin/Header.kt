package dev.petuska.kmdc.drawer

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLHeadingElement

public interface MDCDrawerHeaderScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-drawer)
 */
@MDCContentDsl
@Composable
public fun MDCDrawerScope.Header(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCDrawerHeaderScope>? = null,
) {
  Div(
    attrs = {
      classes("mdc-drawer__header")
      attrs?.invoke(this)
    },
    content = content.reinterpret(),
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-drawer)
 */
@MDCContentDsl
@Composable
public fun MDCDrawerHeaderScope.Title(
  attrs: MDCAttrsRaw<HTMLHeadingElement>? = null,
  content: MDCContentRaw<HTMLHeadingElement>? = null
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-drawer)
 */
@MDCContentDsl
@Composable
public fun MDCDrawerHeaderScope.Title(
  text: String,
  attrs: MDCAttrsRaw<HTMLHeadingElement>? = null,
): Unit = Title(attrs) { Text(text) }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-drawer)
 */
@MDCContentDsl
@Composable
public fun MDCDrawerHeaderScope.Subtitle(
  attrs: MDCAttrsRaw<HTMLHeadingElement>? = null,
  content: MDCContentRaw<HTMLHeadingElement>? = null
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-drawer)
 */
@MDCContentDsl
@Composable
public fun MDCDrawerHeaderScope.Subtitle(
  text: String,
  attrs: MDCAttrsRaw<HTMLHeadingElement>? = null,
): Unit = Subtitle(attrs) { Text(text) }
