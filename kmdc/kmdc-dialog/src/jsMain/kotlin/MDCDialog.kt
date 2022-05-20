package dev.petuska.kmdc.dialog

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCInitEffect
import dev.petuska.kmdc.core.MDCStateEffect
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.rememberUniqueDomElementId
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement

@JsModule("@material/dialog/dist/mdc.dialog.css")
private external val MDCDialogCSS: dynamic

public class MDCDialogAttrsScope(scope: AttrsScope<HTMLDivElement>) : AttrsScope<HTMLDivElement> by scope

public data class MDCDialogOpts(
  var open: Boolean = false,
  var fullscreen: Boolean = false,
  var scrimClickAction: String? = null,
  var escapeKeyAction: String? = null,
  var autoStackButtons: Boolean = true
)

public class MDCDialogScope(
  scope: ElementScope<HTMLDivElement>,
  internal val titleId: String,
  internal val contentId: String
) : ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCDsl
@Composable
public fun MDCDialog(
  opts: Builder<MDCDialogOpts>? = null,
  attrs: Builder<MDCDialogAttrsScope>? = null,
  content: ComposableBuilder<MDCDialogScope>? = null
) {
  MDCDialogCSS
  val options = MDCDialogOpts().apply { opts?.invoke(this) }
  val titleId = rememberUniqueDomElementId()
  val contentId = rememberUniqueDomElementId()
  Div(
    attrs = {
      classes("mdc-dialog")
      if (options.fullscreen) classes(MDCDialogModule.cssClasses.FULLSCREEN)
      if (!options.autoStackButtons) classes(MDCDialogModule.cssClasses.STACKED)
      attrs?.invoke(MDCDialogAttrsScope(this))
    }
  ) {
    MDCInitEffect(MDCDialogModule.MDCDialog::attachTo, keys = arrayOf(options.open)) {
      if (options.open) open() else close("")
    }
    MDCStateEffect(options.scrimClickAction, MDCDialogModule.MDCDialog::scrimClickAction)
    MDCStateEffect(options.escapeKeyAction, MDCDialogModule.MDCDialog::escapeKeyAction)
    MDCStateEffect(options.autoStackButtons, MDCDialogModule.MDCDialog::autoStackButtons)

    Div(attrs = { classes("mdc-dialog__container") }) {
      Div(
        attrs = {
          classes("mdc-dialog__surface")
          attr("role", if (options.fullscreen) "dialog" else "alertdialog")
          aria("modal", "true")
          aria("labelledby", titleId)
          aria("describedby", contentId)
        },
        content = content?.let { { MDCDialogScope(this, titleId, contentId).it() } }
      )
    }
    Div(attrs = { classes("mdc-dialog__scrim") })
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun AttrsScope<out HTMLElement>.mdcDialogInitialFocus() {
  attr(MDCDialogModule.strings.INITIAL_FOCUS_ATTRIBUTE, "true")
}
