package dev.petuska.kmdc.segmented.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.data
import dev.petuska.kmdc.core.role
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLButtonElement

public class MDCSegmentedButtonSegmentAttrsScope(scope: AttrsScope<HTMLButtonElement>) :
  AttrsScope<HTMLButtonElement> by scope

public class MDCSegmentedButtonSegmentScope(scope: ElementScope<HTMLButtonElement>) :
  ElementScope<HTMLButtonElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCDsl
@Composable
public fun MDCSegmentedButtonScope.Segment(
  selected: Boolean = false,
  touch: Boolean = false,
  segmentId: String? = null,
  attrs: Builder<MDCSegmentedButtonSegmentAttrsScope>? = null,
  content: ComposableBuilder<MDCSegmentedButtonSegmentScope>? = null,
) {
  Button(
    attrs = {
      classes("mdc-segmented-button__segment")
      if (touch) {
        classes("mdc-segmented-button--touch")
      }
      if (selected) {
        classes("mdc-segmented-button__segment--selected")
      }
      segmentId?.let { data("segment-id", it) }
      if (this@Segment.singleSelect) {
        aria("checked", "$selected")
        role("radio")
      } else {
        aria("pressed", "$selected")
      }
      attrs?.invoke(MDCSegmentedButtonSegmentAttrsScope(this))
    }
  ) {
    if (touch) {
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
public fun MDCSegmentedButtonScope.Segment(
  text: String,
  selected: Boolean = false,
  touch: Boolean = false,
  segmentId: String? = null,
  attrs: Builder<MDCSegmentedButtonSegmentAttrsScope>? = null,
) {
  Segment(selected = selected, touch = touch, segmentId = segmentId, attrs = attrs) {
    Label(text)
  }
}
