package dev.petuska.kmdc.dialog

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonScope
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.H2
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLHeadingElement

public class MDCDialogHeaderScope(scope: ElementScope<HTMLHeadingElement>, internal val titleId: String) : ElementScope<HTMLHeadingElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCDsl
@Composable
public fun MDCDialogScope.MDCDialogHeader(
  attrs: AttrBuilderContext<HTMLHeadingElement>? = null,
  content: ComposableBuilder<MDCDialogHeaderScope>? = null
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@Suppress("unused")
@MDCDsl
@Composable
public fun MDCDialogHeaderScope.MDCDialogCloseIconButton(
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: ComposableBuilder<MDCButtonScope>? = null
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
