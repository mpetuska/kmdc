package dev.petuska.kmdc.dialog

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonScope
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement

public class MDCDialogActionsScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@Suppress("unused")
@MDCDsl
@Composable
public fun MDCDialogScope.MDCDialogActions(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCDialogActionsScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-dialog__actions")
      attrs?.invoke(this)
    },
    content = content?.let { { MDCDialogActionsScope(this).it() } }
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@Suppress("unused")
@MDCDsl
@Composable
public fun MDCDialogActionsScope.MDCDialogActionButton(
  action: String,
  default: Boolean = false,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: ComposableBuilder<MDCButtonScope>? = null
) {
  MDCButton(
    attrs = {
      mdcDialogAction(action)
      if (default) mdcDialogButtonDefault()
      attrs?.invoke(this)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun AttrsBuilder<out HTMLButtonElement>.mdcDialogButtonDefault() {
  classes("mdc-dialog__button")
  attr(MDCDialogModule.strings.BUTTON_DEFAULT_ATTRIBUTE, "true")
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun AttrsBuilder<out HTMLButtonElement>.mdcDialogAction(action: String) {
  classes("mdc-dialog__button")
  attr(MDCDialogModule.strings.ACTION_ATTRIBUTE, action)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun AttrsBuilder<out HTMLElement>.mdcDialogAction(action: String) {
  attr(MDCDialogModule.strings.ACTION_ATTRIBUTE, action)
}
