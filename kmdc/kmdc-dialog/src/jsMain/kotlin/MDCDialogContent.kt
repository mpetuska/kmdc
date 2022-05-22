package dev.petuska.kmdc.dialog

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

public class MDCDialogContentScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCDsl
@Composable
public fun MDCDialogScope.MDCDialogContent(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCDialogContentScope>? = null
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
