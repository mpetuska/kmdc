package dev.petuska.kmdc.select

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.role
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.I
import org.w3c.dom.HTMLElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-select)
 */
@MDCAttrsDsl
public fun AttrsBuilder<HTMLElement>.mdcSelectIcon(clickable: Boolean) {
  classes("mdc-select__icon")
  if (clickable) {
    tabIndex(0)
    role("button")
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-select)
 */
@Suppress("unused")
@MDCDsl
@Composable
public fun MDCSelectLeadingIconScope.MDCSelectLeadingIcon(
  clickable: Boolean = true,
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: ContentBuilder<HTMLElement>? = null,
) {
  I(
    attrs = {
      mdcSelectIcon(clickable)
      attrs?.invoke(this)
    },
    content = content
  )
}
