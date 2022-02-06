package dev.petuska.kmdc.segmented.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.initialiseMDC
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement

@JsModule("@material/segmented-button/dist/mdc.segmented-button.css")
private external val MDCSegmentedButtonStyle: dynamic

public data class MDCSegmentedButtonOpts(
  var singleSelect: Boolean = false,
)

public class MDCSegmentedButtonAttrsScope private constructor() : AttrsBuilder<HTMLButtonElement>()
public class MDCSegmentedButtonScope(
  scope: ElementScope<HTMLDivElement>,
  internal val options: MDCSegmentedButtonOpts
) :
  ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-segmented-button)
 */
@MDCDsl
@Composable
public fun MDCSegmentedButton(
  opts: Builder<MDCSegmentedButtonOpts>? = null,
  attrs: Builder<MDCSegmentedButtonAttrsScope>? = null,
  content: ComposableBuilder<MDCSegmentedButtonScope>? = null
) {
  MDCSegmentedButtonStyle
  val options = MDCSegmentedButtonOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-segmented-button")
      if (options.singleSelect) {
        classes("mdc-segmented-button--single-select")
        attr("role", "radiogroup")
      } else {
        attr("role", "group")
      }
      initialiseMDC(MDCSegmentedButtonModule.MDCSegmentedButton::attachTo)
      attrs?.invoke(this.unsafeCast<MDCSegmentedButtonAttrsScope>())
    },
    content = content?.let { { MDCSegmentedButtonScope(this, options).it() } }
  )
}
