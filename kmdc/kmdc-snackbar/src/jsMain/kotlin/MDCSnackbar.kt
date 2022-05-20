package dev.petuska.kmdc.snackbar

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCInitEffect
import dev.petuska.kmdc.core.MDCSideEffect
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.classes
import dev.petuska.kmdc.core.reinterpret
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Aside
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLElement

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
  attrs: Builder<MDCSnackbarAttrsScope>? = null,
  content: ComposableBuilder<MDCSnackbarScope>? = null,
) {
  MDCStyle
  Aside(attrs = {
    classes("mdc-snackbar")
    classes(type.classes)
    applyAttrs(attrs)
  }) {
    MDCInitEffect(MDCSnackbarModule::MDCSnackbar, rebuildOnChange = true, keys = arrayOf(type)) {
      if (open) open() else close()
      this.timeoutMs = timeoutMs?.coerceIn(4000, 10000) ?: -1
      this.closeOnEscape = closeOnEscape
    }
    MDCSideEffect(timeoutMs?.coerceIn(4000, 10000) ?: -1, MDCSnackbarModule.MDCSnackbar::timeoutMs)
    MDCSideEffect(closeOnEscape, MDCSnackbarModule.MDCSnackbar::closeOnEscape)
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
