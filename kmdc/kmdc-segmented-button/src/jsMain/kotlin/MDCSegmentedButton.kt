package dev.petuska.kmdc.segmented.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@JsModule("@material/segmented-button/styles.scss")
private external val Style: dynamic

public interface MDCSegmentedButtonAttrsScope : AttrsScope<HTMLDivElement>
public interface MDCSegmentedButtonScope : ElementScope<HTMLDivElement>

internal val MDCSegmentedButtonSingleSelectLocal = strictCompositionLocalOf<Boolean>()

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-segmented-button)
 */
@MDCContentDsl
@Composable
public fun MDCSegmentedButton(
  singleSelect: Boolean = false,
  attrs: MDCAttrs<MDCSegmentedButtonAttrsScope>? = null,
  content: MDCContent<MDCSegmentedButtonScope>? = null
) {
  Style
  Div(
    attrs = {
      classes("mdc-segmented-button")
      if (singleSelect) {
        classes("mdc-segmented-button--single-select")
        attr("role", "radiogroup")
      } else {
        attr("role", "group")
      }
      applyAttrs(attrs)
    },
  ) {
    CompositionLocalProvider(MDCSegmentedButtonSingleSelectLocal provides singleSelect) {
      MDCProvider(::MDCSegmentedButton) {
        applyContent(content)
      }
    }
  }
}
