package dev.petuska.kmdc.dialog

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.icon.button.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

public interface MDCDialogHeaderScope : ElementScope<HTMLDivElement>, MDCDialogTitleScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCDsl
@Composable
public fun MDCDialogScope.Header(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCDialogHeaderScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-dialog__header")
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@Suppress("unused")
@MDCDsl
@Composable
public fun MDCDialogHeaderScope.CloseButton(
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  content: MDCContent<MDCIconButtonScope<HTMLButtonElement>>? = null
) {
  MDCIconButton(
    attrs = {
      classes("mdc-dialog__close")
      data("mdc-dialog-action", "close")
      applyAttrs(attrs)
    },
    content = content,
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@Suppress("unused")
@MDCDsl
@Composable
public fun MDCDialogHeaderScope.CloseButton(
  text: String,
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
) {
  CloseButton(attrs = attrs) {
    Text(text)
  }
}
