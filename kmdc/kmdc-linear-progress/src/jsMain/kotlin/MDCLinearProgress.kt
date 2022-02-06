package dev.petuska.kmdc.linear.progress

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCSideEffect
import dev.petuska.kmdc.core.initialiseMDC
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLDivElement

@JsModule("@material/linear-progress/dist/mdc.linear-progress.css")
private external val MDCLinearProgressCSS: dynamic

public data class MDCLinearProgressOpts(
  var progress: Number = 0,
  var buffer: Number = 0,
  var determinate: Boolean = false,
  var closed: Boolean = false,
  var label: String? = null,
)

public class MDCLinearProgressScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-linear-progress)
 */
@MDCDsl
@Composable
public fun MDCLinearProgress(
  opts: Builder<MDCLinearProgressOpts>? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCLinearProgressScope>? = null
) {
  MDCLinearProgressCSS
  val options = MDCLinearProgressOpts().apply { opts?.invoke(this) }
  Div(attrs = {
    classes("mdc-linear-progress")
    if (!options.determinate) classes("mdc-linear-progress--indeterminate")
    if (options.closed) classes("mdc-linear-progress--closed")
    attr("role", "progressbar")
    attr("aria-valuemin", "0")
    attr("aria-valuemax", "1")
    attr("aria-valuenow", "0")
    options.label?.let { attr("aria-label", it) }
    initialiseMDC(MDCLinearProgressModule.MDCLinearProgress::attachTo) {
      determinate = options.determinate
      progress = options.progress
      buffer = options.buffer
    }
    attrs?.invoke(this)
  }) {
    MDCSideEffect(options.determinate, MDCLinearProgressModule.MDCLinearProgress::determinate)
    MDCSideEffect(options.progress, MDCLinearProgressModule.MDCLinearProgress::progress)
    MDCSideEffect(options.buffer, MDCLinearProgressModule.MDCLinearProgress::buffer)
    MDCSideEffect<MDCLinearProgressModule.MDCLinearProgress>(options.closed) {
      if (options.closed) close() else open()
    }
    Div({ classes("mdc-linear-progress__buffer") }) {
      Div({ classes("mdc-linear-progress__buffer-bar") })
      Div({ classes("mdc-linear-progress__buffer-dots") })
    }
    Div({ classes("mdc-linear-progress__bar", "mdc-linear-progress__primary-bar") }) {
      Span({ classes("mdc-linear-progress__bar-inner") })
    }
    Div({ classes("mdc-linear-progress__bar", "mdc-linear-progress__secondary-bar") }) {
      Span({ classes("mdc-linear-progress__bar-inner") })
    }
    content?.let { MDCLinearProgressScope(this).it() }
  }
}
