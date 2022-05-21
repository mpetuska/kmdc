package dev.petuska.kmdc.segmented.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCInitEffect
import dev.petuska.kmdc.core.applyContent
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

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
  attrs: Builder<MDCSegmentedButtonAttrsScope>? = null,
  content: ComposableBuilder<MDCSegmentedButtonScope>? = null
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
