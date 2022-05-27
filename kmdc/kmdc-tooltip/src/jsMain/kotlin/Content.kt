package dev.petuska.kmdc.tooltip

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.reinterpret
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLParagraphElement

public interface MDCTooltipRichContentScope : ElementScope<HTMLParagraphElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCContentDsl
@Composable
public fun MDCRichTooltipScope.Content(
  attrs: MDCAttrsRaw<HTMLParagraphElement>? = null,
  content: MDCContent<MDCTooltipRichContentScope>? = null,
) {
  P(
    attrs = {
      classes("mdc-tooltip__content")
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCContentDsl
@Composable
public fun MDCRichTooltipScope.Content(
  text: String,
  attrs: MDCAttrsRaw<HTMLParagraphElement>? = null,
) {
  Content(attrs) {
    Text(text)
  }
}
