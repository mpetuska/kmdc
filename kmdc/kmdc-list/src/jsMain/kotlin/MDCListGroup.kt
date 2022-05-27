package dev.petuska.kmdc.list

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLHeadingElement

public interface MDCListGroupScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListGroup(
  attrs: MDCAttrs<AttrsScope<HTMLDivElement>>? = null,
  content: MDCContent<MDCListGroupScope>? = null,
) {
  Div(
    attrs = {
      classes("mdc-deprecated-list-group")
      attrs?.invoke(this)
    }, content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListGroupScope.Subheader(
  attrs: MDCAttrs<AttrsScope<HTMLHeadingElement>>? = null,
  content: MDCContentRaw<HTMLHeadingElement>? = null,
) {
  H3(attrs = {
    classes("mdc-deprecated-list-group__subheader")
    attrs?.invoke(this)
  }, content = content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCListGroupScope.Subheader(
  text: String,
  attrs: MDCAttrs<AttrsScope<HTMLHeadingElement>>? = null,
) {
  Subheader(attrs) { Text(text) }
}
