package dev.petuska.kmdc.segmented.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLButtonElement

public interface MDCSegmentedButtonSegmentAttrsScope : AttrsScope<HTMLButtonElement>

public interface MDCSegmentedButtonSegmentScope : ElementScope<HTMLButtonElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCContentDsl
@Composable
public fun MDCSegmentedButtonScope.Segment(
  selected: Boolean = false,
  touch: Boolean = false,
  segmentId: String? = null,
  attrs: MDCAttrs<MDCSegmentedButtonSegmentAttrsScope>? = null,
  content: MDCContent<MDCSegmentedButtonSegmentScope>? = null,
) {
  val singleSelect = MDCSegmentedButtonSingleSelectLocal.current
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
      if (singleSelect) {
        aria("checked", "$selected")
        role("radio")
      } else {
        aria("pressed", "$selected")
      }
      applyAttrs(attrs)
    }
  ) {
    if (touch) {
      Div(attrs = {
        classes("mdc-segmented-button__touch")
      })
    }
    Div(attrs = { classes("mdc-segmented-button__ripple") })
    applyContent(content)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCContentDsl
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
