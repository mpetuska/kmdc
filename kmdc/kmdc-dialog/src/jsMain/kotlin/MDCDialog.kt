package dev.petuska.kmdc.dialog

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

@JsModule("@material/dialog/mdc-dialog.scss")
private external val Style: dynamic

public interface MDCDialogAttrsScope : AttrsScope<HTMLDivElement>

public interface MDCDialogScope : ElementScope<HTMLDivElement>, MDCDialogTitleScope<HTMLDivElement>

internal val TitleIdLocal = strictCompositionLocalOf<String>()
internal val ContentIdLocal = strictCompositionLocalOf<String>()
internal val OpenLocal = strictCompositionLocalOf<Boolean>()

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCContentDsl
@Composable
public fun MDCDialog(
  open: Boolean,
  fullscreen: Boolean = false,
  stacked: Boolean = true,
  scrimClickAction: String = "close",
  escapeKeyAction: String = "close",
  attrs: MDCAttrs<MDCDialogAttrsScope>? = null,
  content: MDCContent<MDCDialogScope>? = null
) {
  Style
  val titleId = rememberUniqueDomElementId()
  val contentId = rememberUniqueDomElementId()
  CompositionLocalProvider(
    TitleIdLocal provides titleId,
    ContentIdLocal provides contentId,
    OpenLocal provides open,
  ) {
    Div(
      attrs = {
        classes("mdc-dialog")
        if (fullscreen) classes("mdc-dialog--fullscreen")
        if (stacked) classes("mdc-dialog--stacked")
        applyAttrs(attrs)
      }
    ) {
      MDCProvider(::MDCDialog) {
        MDCSideEffectNew(open) {
          if (open) open() else close()
        }
        MDCStateEffectNew(scrimClickAction, MDCDialog::scrimClickAction)
        MDCStateEffectNew(escapeKeyAction, MDCDialog::escapeKeyAction)
        MDCStateEffectNew(!stacked, MDCDialog::autoStackButtons)
      }

      Div(attrs = { classes("mdc-dialog__container") }) {
        Div(
          attrs = {
            classes("mdc-dialog__surface")
            role(if (fullscreen) "dialog" else "alertdialog")
            aria("modal", "true")
            aria("labelledby", titleId)
            aria("describedby", contentId)
          },
          content = content.reinterpret(),
        )
      }
      Div(attrs = { classes("mdc-dialog__scrim") })
    }
  }
}
