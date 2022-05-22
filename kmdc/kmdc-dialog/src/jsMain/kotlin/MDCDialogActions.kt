package dev.petuska.kmdc.dialog

import androidx.compose.runtime.*
import dev.petuska.kmdc.button.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

public class MDCDialogActionsScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@Suppress("unused")
@MDCDsl
@Composable
public fun MDCDialogScope.MDCDialogActions(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCDialogActionsScope>? = null
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@Suppress("unused")
@MDCDsl
@Composable
public fun MDCDialogActionsScope.MDCDialogActionButton(
  action: String,
  default: Boolean = false,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: MDCContent<MDCButtonScope>? = null
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun AttrsScope<out HTMLButtonElement>.mdcDialogButtonDefault() {
  classes("mdc-dialog__button")
  attr(MDCDialogModule.strings.BUTTON_DEFAULT_ATTRIBUTE, "true")
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun AttrsScope<out HTMLButtonElement>.mdcDialogAction(action: String) {
  classes("mdc-dialog__button")
  attr(MDCDialogModule.strings.ACTION_ATTRIBUTE, action)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun AttrsScope<out HTMLElement>.mdcDialogAction(action: String) {
  attr(MDCDialogModule.strings.ACTION_ATTRIBUTE, action)
}
