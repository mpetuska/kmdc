package dev.petuska.kmdc.snackbar

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.button.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.icon.button.MDCIconButton
import dev.petuska.kmdc.icon.button.MDCIconButtonScope
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement

public interface MDCSnackbarActionsScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCContentDsl
@Composable
public fun MDCSnackbarScope.Actions(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
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
@MDCContentDsl
@Composable
public fun MDCSnackbarActionsScope.Action(
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  content: MDCContent<MDCButtonScope<HTMLButtonElement>>? = null,
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
@MDCContentDsl
@Composable
public fun MDCSnackbarActionsScope.Action(
  text: String,
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
) {
  Action(type, icon, attrs) { Label(text) }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCContentDsl
@Composable
public fun MDCSnackbarActionsScope.Dismiss(
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  content: MDCContent<MDCIconButtonScope<HTMLButtonElement>>? = null,
) {
  MDCIconButton(
    attrs = {
      classes("mdc-snackbar__dismiss")
      attrs?.invoke(this)
    },
    content = content,
  )
}
