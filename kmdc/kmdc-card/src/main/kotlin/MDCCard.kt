package dev.petuska.kmdc.card

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@JsModule("@material/card/mdc-card.scss")
private external val Style: dynamic

public enum class MDCCardType(public vararg val classes: String) {
  Elevated,
  Outlined("mdc-card--outlined")
}

public interface MDCCardScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCContentDsl
@Composable
public fun MDCCard(
  type: MDCCardType = MDCCardType.Elevated,
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCCardScope>? = null
) {
  Style
  Div(
    attrs = {
      classes("mdc-card")
      classes(type.classes)
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}
