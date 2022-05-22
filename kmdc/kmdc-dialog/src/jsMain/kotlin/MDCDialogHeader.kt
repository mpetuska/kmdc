package dev.petuska.kmdc.dialog

import androidx.compose.runtime.*
import dev.petuska.kmdc.button.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

public class MDCDialogHeaderScope(scope: ElementScope<HTMLHeadingElement>, internal val titleId: String) :
  ElementScope<HTMLHeadingElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCDsl
@Composable
public fun MDCDialogScope.MDCDialogHeader(
  attrs: AttrBuilderContext<HTMLHeadingElement>? = null,
  content: MDCContent<MDCDialogHeaderScope>? = null
) {
  H2(
    attrs = {
      classes("mdc-dialog__header")
      attrs?.invoke(this)
    },
    content = content?.let { { MDCDialogHeaderScope(this, titleId).it() } }
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@Suppress("unused")
@MDCDsl
@Composable
public fun MDCDialogHeaderScope.MDCDialogCloseIconButton(
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: MDCContent<MDCButtonScope>? = null
) {
  MDCButton(
    attrs = {
      mdcDialogAction("close")
      classes("mdc-dialog__close")
      attrs?.invoke(this)
    },
    content = content
  )
}
