package dev.petuska.kmdc.linear.progress

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
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
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-linear-progress)
 */
@MDCContentDsl
@Composable
public fun MDCLinearProgress(
  opts: MDCAttrs<MDCLinearProgressOpts>? = null,
  attrs: AttrsBuilder<HTMLDivElement>? = null,
  content: MDCContent<MDCLinearProgressScope>? = null
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
    attrs?.invoke(this)
  }) {
    MDCInitEffect(::MDCLinearProgress)
    MDCStateEffect(options.determinate, MDCLinearProgress::determinate)
    MDCStateEffect(options.progress, MDCLinearProgress::progress)
    MDCStateEffect(options.buffer, MDCLinearProgress::buffer)
    MDCSideEffect<MDCLinearProgress>(options.closed) {
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
