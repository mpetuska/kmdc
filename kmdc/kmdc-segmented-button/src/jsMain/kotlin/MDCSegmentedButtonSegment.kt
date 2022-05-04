package dev.petuska.kmdc.segmented.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLButtonElement

public data class MDCSegmentedButtonSegmentOpts(
  var selected: Boolean = false,
  var touch: Boolean = false
)

public class MDCSegmentedButtonSegmentAttrsScope(scope: AttrsScope<HTMLButtonElement>) :
  AttrsScope<HTMLButtonElement> by scope

public class MDCSegmentedButtonSegmentScope(scope: ElementScope<HTMLButtonElement>) :
  ElementScope<HTMLButtonElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCDsl
@Composable
public fun MDCSegmentedButtonScope.MDCSegmentedButtonSegment(
  opts: Builder<MDCSegmentedButtonSegmentOpts>? = null,
  attrs: Builder<MDCSegmentedButtonSegmentAttrsScope>? = null,
  content: ComposableBuilder<MDCSegmentedButtonSegmentScope>? = null,
) {
  val options = MDCSegmentedButtonSegmentOpts().apply { opts?.invoke(this) }
  Button(
    attrs = {
      classes("mdc-segmented-button__segment")
      if (options.touch) {
        classes("mdc-segmented-button--touch")
      }
      if (options.selected) {
        classes("mdc-segmented-button__segment--selected")
      }
      if (this@MDCSegmentedButtonSegment.options.singleSelect) {
        attr("aria-checked", "${options.selected}")
        attr("role", "radio")
      } else {
        attr("aria-pressed", "${options.selected}")
      }
      attrs?.invoke(MDCSegmentedButtonSegmentAttrsScope(this))
    }
  ) {
    if (options.touch) {
      Div(attrs = {
        classes("mdc-segmented-button__touch")
      })
    }
    Div(attrs = { classes("mdc-segmented-button__ripple") })
    content?.invoke(MDCSegmentedButtonSegmentScope(this))
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCDsl
@Composable
public fun MDCSegmentedButtonScope.MDCSegmentedButtonSegment(
  text: String,
  opts: Builder<MDCSegmentedButtonSegmentOpts>? = null,
  attrs: Builder<MDCSegmentedButtonSegmentAttrsScope>? = null,
) {
  MDCSegmentedButtonSegment(opts, attrs) {
    MDCSegmentedButtonLabel(text)
  }
}
