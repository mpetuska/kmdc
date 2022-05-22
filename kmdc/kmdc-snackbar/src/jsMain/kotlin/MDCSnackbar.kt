package dev.petuska.kmdc.snackbar

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

@JsModule("@material/snackbar/mdc-snackbar.scss")
private external val MDCStyle: dynamic

public enum class MDCSnackbarType(public vararg val classes: String) {
  Default,
  Stacked("mdc-snackbar--stacked"),
  Leading("mdc-snackbar--leading"),
}

public interface MDCSnackbarAttrsScope : AttrsScope<HTMLElement>
public interface MDCSnackbarScope : ElementScope<HTMLElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-snackbar)
 */
@MDCDsl
@Composable
public fun MDCSnackbar(
  type: MDCSnackbarType = MDCSnackbarType.Default,
  open: Boolean = false,
  dismissible: Boolean = false,
  timeoutMs: Int? = 5000,
  closeOnEscape: Boolean = true,
  attrs: MDCAttrs<MDCSnackbarAttrsScope>? = null,
  content: MDCContent<MDCSnackbarScope>? = null,
) {
  MDCStyle
  Aside(attrs = {
    classes("mdc-snackbar")
    classes(type.classes)
    applyAttrs(attrs)
  }) {
    MDCInitEffect(MDCSnackbarModule::MDCSnackbar, type)
    MDCStateEffect(timeoutMs?.coerceIn(4000, 10000) ?: -1, MDCSnackbarModule.MDCSnackbar::timeoutMs)
    MDCStateEffect(closeOnEscape, MDCSnackbarModule.MDCSnackbar::closeOnEscape)
    MDCSideEffect<MDCSnackbarModule.MDCSnackbar>(open) {
      if (open) open() else close()
    }
    Div(
      attrs = {
        classes("mdc-snackbar__surface")
        attr("role", "status")
        attr("aria-relevant", "additions")
      },
      content = content.reinterpret()
    )
  }
}
