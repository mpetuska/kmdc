package dev.petuska.kmdc.snackbar

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonLabel
import dev.petuska.kmdc.button.MDCButtonOpts
import dev.petuska.kmdc.button.MDCButtonScope
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.icon.button.MDCIconButton
import dev.petuska.kmdc.icon.button.MDCIconButtonOpts
import dev.petuska.kmdc.icon.button.MDCIconButtonScope
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement

public class MDCSnackbarActionsScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-snackbar)
 */
@MDCDsl
@Composable
public fun MDCSnackbarScope.MDCSnackbarActions(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCSnackbarActionsScope>? = null,
) {
  Div(
    attrs = {
      classes("mdc-snackbar__actions")
      attr("aria-atomic", "true")
      attrs?.invoke(this)
    },
    content = content?.let { { MDCSnackbarActionsScope(this).it() } }
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-snackbar)
 */
@MDCDsl
@Composable
public fun MDCSnackbarActionsScope.MDCSnackbarAction(
  opts: Builder<MDCButtonOpts>? = null,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: ComposableBuilder<MDCButtonScope>? = null,
) {
  MDCButton(
    opts = opts,
    attrs = {
      classes("mdc-snackbar__action")
      type(ButtonType.Button)
      attrs?.invoke(this)
    },
    content = content,
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-snackbar)
 */
@MDCDsl
@Composable
public fun MDCSnackbarActionsScope.MDCSnackbarAction(
  text: String,
  opts: Builder<MDCButtonOpts>? = null,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
) {
  MDCSnackbarAction(opts, attrs) { MDCButtonLabel(text) }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-snackbar)
 */
@MDCDsl
@Composable
public fun MDCSnackbarActionsScope.MDCSnackbarDismiss(
  opts: Builder<MDCIconButtonOpts>? = null,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: ComposableBuilder<MDCIconButtonScope>? = null,
) {
  MDCIconButton(
    opts = opts,
    attrs = {
      classes("mdc-snackbar__dismiss")
      attrs?.invoke(this)
    },
    content = content,
  )
}
