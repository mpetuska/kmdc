package dev.petuska.kmdc.card

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

public enum class MDCCardMediaType(public vararg val classes: String) {
  Free,
  Square("mdc-card__media--square"),
  Cinema("mdc-card__media--16-9")
}

public interface MDCCardMediaScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCContentDsl
@Composable
public fun MDCCardScope.Media(
  type: MDCCardMediaType = MDCCardMediaType.Free,
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCCardMediaScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-card__media")
      classes(type.classes)
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCContentDsl
@Composable
public fun MDCCardMediaScope.MediaContent(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContentRaw<HTMLDivElement>? = null
) {
  Div(
    attrs = {
      classes("mdc-card__media-content")
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}
