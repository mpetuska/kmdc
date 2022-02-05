package dev.petuska.kmdc.dialog

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.initialiseMDC
import dev.petuska.kmdc.core.mdc
import dev.petuska.kmdc.core.rememberUniqueDomElementId
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement

@JsModule("@material/dialog/dist/mdc.dialog.css")
private external val MDCDialogCSS: dynamic

public class MDCDialogAttrsScope private constructor() : AttrsBuilder<HTMLDivElement>()

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
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
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
      initialiseMDC(MDCDialogModule.MDCDialog::attachTo)
      attrs?.invoke(this.unsafeCast<MDCDialogAttrsScope>())
    }
  ) {
    DomSideEffect(options.open) {
      it.mdc<MDCDialogModule.MDCDialog> { if (options.open) open() else close("") }
    }
    DomSideEffect(options.scrimClickAction) {
      it.mdc<MDCDialogModule.MDCDialog> { scrimClickAction = options.scrimClickAction }
    }
    DomSideEffect(options.escapeKeyAction) {
      it.mdc<MDCDialogModule.MDCDialog> { escapeKeyAction = options.escapeKeyAction }
    }
    DomSideEffect(options.autoStackButtons) {
      it.mdc<MDCDialogModule.MDCDialog> { autoStackButtons = options.autoStackButtons }
    }

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
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCAttrsDsl
public fun AttrsBuilder<out HTMLElement>.mdcDialogInitialFocus() {
  attr(MDCDialogModule.strings.INITIAL_FOCUS_ATTRIBUTE, "true")
}
