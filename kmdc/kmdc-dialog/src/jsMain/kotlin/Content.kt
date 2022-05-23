package dev.petuska.kmdc.dialog

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

public interface MDCDialogContentScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCDsl
@Composable
public fun MDCDialogScope.Content(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCDialogContentScope>? = null
) {
  val contentId = ContentIdLocal.current
  val open = OpenLocal.current
  Div(
    attrs = {
      classes("mdc-dialog__content")
      aria("hidden", !open)
      id(contentId)
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun AttrsScope<out HTMLElement>.mdcDialogInitialFocus() {
  tabIndex(0)
  data("mdc-dialog-initial-focus", "true")
}
