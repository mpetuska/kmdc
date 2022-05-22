package dev.petuska.kmdc.segmented.button

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

@JsModule("@material/segmented-button/dist/mdc.segmented-button.css")
private external val MDCSegmentedButtonStyle: dynamic

public class MDCSegmentedButtonAttrsScope(scope: AttrsScope<HTMLDivElement>) : AttrsScope<HTMLDivElement> by scope
public class MDCSegmentedButtonScope(
  scope: ElementScope<HTMLDivElement>,
  internal val singleSelect: Boolean,
) :
  ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCDsl
@Composable
public fun MDCSegmentedButton(
  singleSelect: Boolean = false,
  attrs: MDCAttrs<MDCSegmentedButtonAttrsScope>? = null,
  content: MDCContent<MDCSegmentedButtonScope>? = null
) {
  MDCSegmentedButtonStyle
  Div(
    attrs = {
      classes("mdc-segmented-button")
      if (singleSelect) {
        classes("mdc-segmented-button--single-select")
        attr("role", "radiogroup")
      } else {
        attr("role", "group")
      }
      attrs?.invoke(MDCSegmentedButtonAttrsScope(this))
    },
    content = {
      MDCInitEffect(MDCSegmentedButtonModule::MDCSegmentedButton)
      applyContent(content) { MDCSegmentedButtonScope(this, singleSelect) }
    }
  )
}
