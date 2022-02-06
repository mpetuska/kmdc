package dev.petuska.kmdc.snackbar

import MDCSnackbarModule
import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCSideEffect
import dev.petuska.kmdc.core.initialiseMDC
import org.jetbrains.compose.web.dom.Aside
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLElement

@JsModule("@material/snackbar/dist/mdc.snackbar.css")
private external val MDCSnackbarCSS: dynamic

public data class MDCSnackbarOpts(
  var type: Type = Type.Default,
  var open: Boolean = false,
  var dismissible: Boolean = false,
) {
  public enum class Type(public vararg val classes: String) {
    Default,
    Stacked("mdc-snackbar--stacked"),
    Leading("mdc-snackbar--leading"),
  }
}

public class MDCSnackbarScope(scope: ElementScope<HTMLElement>) : ElementScope<HTMLElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-snackbar)
 */
@MDCDsl
@Composable
public fun MDCSnackbar(
  opts: Builder<MDCSnackbarOpts>? = null,
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: ComposableBuilder<MDCSnackbarScope>? = null,
) {
  val options = MDCSnackbarOpts().apply { opts?.invoke(this) }
  MDCSnackbarCSS
  Aside(attrs = {
    classes("mdc-snackbar", *options.type.classes)
    attrs?.invoke(this)
    initialiseMDC(MDCSnackbarModule.MDCSnackbar::attachTo)
  }) {
    MDCSideEffect<MDCSnackbarModule.MDCSnackbar>(options.open) { if (options.open) open() else close() }
    Div(
      attrs = {
        classes("mdc-snackbar__surface")
        attr("role", "status")
        attr("aria-relevant", "additions")
      },
      content = content?.let { { MDCSnackbarScope(this).it() } }
    )
  }
}
