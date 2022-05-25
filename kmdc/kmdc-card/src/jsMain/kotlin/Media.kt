package dev.petuska.kmdc.card

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.classes
import dev.petuska.kmdc.core.reinterpret
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
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
@MDCDsl
@Composable
public fun MDCCardScope.Media(
  type: MDCCardMediaType = MDCCardMediaType.Free,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCCardMediaScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-card__media")
      classes(type.classes)
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCDsl
@Composable
public fun MDCCardMediaScope.MediaContent(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null
) {
  Div(
    attrs = {
      classes("mdc-card__media-content")
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}
