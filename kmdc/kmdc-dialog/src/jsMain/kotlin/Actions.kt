package dev.petuska.kmdc.dialog

import androidx.compose.runtime.*
import dev.petuska.kmdc.button.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

public interface MDCDialogActionsScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCDsl
@Composable
public fun MDCDialogScope.Actions(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCDialogActionsScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-dialog__actions")
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCDsl
@Composable
public fun MDCDialogActionsScope.Action(
  action: String,
  default: Boolean = false,
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  content: MDCContent<MDCButtonScope>? = null
) {
  ActionImpl(
    action = action,
    default = default,
    attrs = attrs,
    content = content,
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCDsl
@Composable
public fun MDCDialogActionsScope.Action(
  action: String,
  text: String,
  default: Boolean = false,
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
) {
  Action(
    action = action,
    default = default,
    attrs = attrs,
  ) {
    Label(text)
  }
}

@MDCDsl
@Composable
internal fun ActionImpl(
  action: String,
  default: Boolean,
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  content: MDCContent<MDCButtonScope>? = null
) {
  MDCButton(
    attrs = {
      classes("mdc-dialog__button")
      data("mdc-dialog-action", action)
      if (default) {
        classes("mdc-dialog__button")
        data("mdc-dialog-button-default", "true")
      }
      attrs?.invoke(this)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun AttrsScope<out HTMLElement>.mdcDialogAction(action: String) {
  data("mdc-dialog-action", action)
}
