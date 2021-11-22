package dev.petuska.kmdc.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.I
import org.w3c.dom.HTMLElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-button#icon)
 */
@MDCDsl
@Composable
public fun MDCButtonScope.MDCButtonIcon(
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: ContentBuilder<HTMLElement>? = null,
) {
  I(
    attrs = {
      classes("mdc-button__icon")
      prop<HTMLElement, String>(
        { e, v ->
          e.setAttribute("aria-hidden", v)
        },
        "true"
      )
      attrs?.invoke(this)
    },
    content,
  )
}
