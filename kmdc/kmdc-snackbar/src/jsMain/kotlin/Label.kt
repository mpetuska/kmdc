package dev.petuska.kmdc.snackbar

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.MDCContentRaw
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCContentDsl
@Composable
public fun MDCSnackbarScope.Label(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContentRaw<HTMLDivElement>? = null,
) {
  Div(
    attrs = {
      classes("mdc-snackbar__label")
      attr("aria-atomic", "false")
      attrs?.invoke(this)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCContentDsl
@Composable
public fun MDCSnackbarScope.Label(
  text: String,
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
) {
  Label(attrs) { Text(text) }
}
