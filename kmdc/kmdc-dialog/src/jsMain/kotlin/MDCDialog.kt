package dev.petuska.kmdc.dialog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.mdc
import dev.petuska.kmdc.core.uniqueDomElementId
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement

@JsModule("@material/dialog/dist/mdc.dialog.css")
private external val MDCDialogCSS: dynamic

@JsModule("@material/dialog")
public external object MDCDialogModule {
  internal class MDCDialog(element: Element) {
    public companion object {
      public fun attachTo(element: Element): MDCDialog
    }

    public fun destroy()

    public val open: Boolean
    public var scrimClickAction: String?
    public var escapeKeyAction: String?
    public var autoStackButtons: Boolean

    public fun open()
    public fun close(action: String)
  }

  public class MDCDialogCloseEventDetail {
    public val action: String?
  }

  public class MDCDialogCloseEvent : MDCEvent<MDCDialogCloseEventDetail>
}

@JsModule("@material/dialog/constants")
internal external object MDCDialogConstants {
  @Suppress("ClassName")
  object strings {
    val ACTION_ATTRIBUTE: String
    val BUTTON_DEFAULT_ATTRIBUTE: String
    val CLOSED_EVENT: String
    val CLOSING_EVENT: String
    val OPENED_EVENT: String
    val OPENING_EVENT: String
    val INITIAL_FOCUS_ATTRIBUTE: String
  }

  @Suppress("ClassName")
  object cssClasses {
    val STACKED: String
    val FULLSCREEN: String
  }
}

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
  val headerId = remember { uniqueDomElementId() }
  val contentId = remember { uniqueDomElementId() }
  Div(
    attrs = {
      classes("mdc-dialog")
      if (options.fullscreen) classes(MDCDialogConstants.cssClasses.FULLSCREEN)
      if (!options.autoStackButtons) classes(MDCDialogConstants.cssClasses.STACKED)
      ref {
        it.mdc = MDCDialogModule.MDCDialog.attachTo(it)
        onDispose {
          it.mdc<MDCDialogModule.MDCDialog> { destroy() }
        }
      }
      attrs?.invoke(this.unsafeCast<MDCDialogAttrsScope>())
    }
  ) {
    DomSideEffect(options.open) {
      it.mdc<MDCDialogModule.MDCDialog> { it.mdc<MDCDialogModule.MDCDialog> { if (options.open) open() else close("") } }
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
          aria("labelledby", headerId)
          aria("describedby", contentId)
        },
        content = content?.let { { MDCDialogScope(this, headerId, contentId).it() } }
      )
    }
    Div(attrs = { classes("mdc-dialog__scrim") })
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-dialog)
 */
@MDCDsl
public fun AttrsBuilder<out HTMLElement>.mdcDialogInitialFocus() {
  attr(MDCDialogConstants.strings.INITIAL_FOCUS_ATTRIBUTE, "true")
}
