package dev.petuska.kmdc.icon.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.I
import org.w3c.dom.HTMLElement

@Composable
private fun render(
  opts: MDCAttrs<MDCIconButtonOpts>?,
  attrs: AttrBuilderContext<HTMLElement>?,
  content: ContentBuilder<HTMLElement>?,
) {
  val options = MDCIconButtonOpts().apply { opts?.invoke(this) }
  I(
    attrs = {
      classes(
        *listOfNotNull(
          "mdc-icon-button__icon",
          if (options.on) "mdc-icon-button__icon--on" else null
        ).toTypedArray()
      )
      attrs?.invoke(this)
    },
    content = content,
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-icon-button)
 */
@MDCDsl
@Composable
public fun MDCIconButtonScope.MDCIconButtonIcon(
  opts: MDCAttrs<MDCIconButtonOpts>? = null,
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: ContentBuilder<HTMLElement>? = null,
): Unit = render(opts, attrs, content)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-icon-button)
 */
@MDCDsl
@Composable
public fun MDCIconLinkScope.MDCIconButtonIcon(
  opts: MDCAttrs<MDCIconButtonOpts>? = null,
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: ContentBuilder<HTMLElement>? = null,
): Unit = render(opts, attrs, content)
