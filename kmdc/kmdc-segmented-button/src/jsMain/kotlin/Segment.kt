package dev.petuska.kmdc.segmented.button

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

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
  attrs: MDCAttrs<MDCSegmentedButtonSegmentAttrsScope>? = null,
  content: MDCContent<MDCSegmentedButtonSegmentScope>? = null,
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
  attrs: MDCAttrs<MDCSegmentedButtonSegmentAttrsScope>? = null,
) {
  Segment(selected = selected, touch = touch, segmentId = segmentId, attrs = attrs) {
    Label(text)
  }
}
