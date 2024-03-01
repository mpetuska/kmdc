package dev.petuska.kmdc.linear.progress

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLDivElement

@JsModule("@material/linear-progress/mdc-linear-progress.scss")
private external val Style: dynamic

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-linear-progress)
 */
@MDCContentDsl
@Composable
public fun MDCLinearProgress(
  progress: Number = 0,
  buffer: Number = 0,
  determinate: Boolean = false,
  closed: Boolean = false,
  label: String? = null,
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContentRaw<HTMLDivElement>? = null
) {
  Style
  Div(attrs = {
    classes("mdc-linear-progress")
    if (!determinate) classes("mdc-linear-progress--indeterminate")
    if (closed) classes("mdc-linear-progress--closed")
    attr("role", "progressbar")
    attr("aria-valuemin", "0")
    attr("aria-valuemax", "1")
    attr("aria-valuenow", "0")
    label?.let { attr("aria-label", it) }
    attrs?.invoke(this)
  }) {
    MDCProvider(::MDCLinearProgress) {
      MDCStateEffect(determinate, MDCLinearProgress::determinate)
      MDCStateEffect(progress, MDCLinearProgress::progress)
      MDCStateEffect(buffer, MDCLinearProgress::buffer)
      MDCSideEffect(closed) {
        if (closed) close() else open()
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
      applyContent(content)
    }
  }
}
