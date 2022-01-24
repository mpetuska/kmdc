package dev.petuska.kmdc.dialog

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

public class MDCDialogContentScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCDsl
@Composable
public fun MDCDialogScope.MDCDialogContent(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCDialogContentScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-dialog__content")
      id(contentId)
      attrs?.invoke(this)
    },
    content = content?.let { { MDCDialogContentScope(this).it() } }
  )
}
