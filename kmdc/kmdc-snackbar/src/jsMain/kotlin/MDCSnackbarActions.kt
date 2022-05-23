package dev.petuska.kmdc.snackbar

import androidx.compose.runtime.*
import dev.petuska.kmdc.button.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.icon.button.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

public interface MDCSnackbarActionsScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCDsl
@Composable
public fun MDCSnackbarScope.MDCSnackbarActions(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCSnackbarActionsScope>? = null,
) {
  Div(
    attrs = {
      classes("mdc-snackbar__actions")
      attr("aria-atomic", "true")
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCDsl
@Composable
public fun MDCSnackbarActionsScope.MDCSnackbarAction(
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: MDCContent<MDCButtonScope>? = null,
) {
  MDCButton(
    type = type,
    icon = icon,
    attrs = {
      classes("mdc-snackbar__action")
      type(ButtonType.Button)
      attrs?.invoke(this)
    },
    content = content,
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCDsl
@Composable
public fun MDCSnackbarActionsScope.MDCSnackbarAction(
  text: String,
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
) {
  MDCSnackbarAction(type, icon, attrs) { Label(text) }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCDsl
@Composable
public fun MDCSnackbarActionsScope.MDCSnackbarDismiss(
  on: Boolean = false,
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  content: MDCContent<MDCIconButtonScope<HTMLButtonElement>>? = null,
) {
  MDCIconButton(
    on = on,
    attrs = {
      classes("mdc-snackbar__dismiss")
      attrs?.invoke(this)
    },
    content = content,
  )
}
