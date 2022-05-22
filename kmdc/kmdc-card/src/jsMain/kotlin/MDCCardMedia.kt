package dev.petuska.kmdc.card

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.classes
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

public data class MDCCardMediaOpts(var type: Type = Type.Free) {
  public enum class Type(public vararg val classes: String) {
    Free,
    Square("mdc-card__media--square"),
    Cinema("mdc-card__media--16-9")
  }
}

public class MDCCardMediaScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCDsl
@Composable
public fun MDCCardScope.MDCCardMedia(
  opts: MDCAttrs<MDCCardMediaOpts>? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCCardMediaScope>? = null
) {
  val options = MDCCardMediaOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-card__media")
      classes(options.type.classes)
      attrs?.invoke(this)
    },
  ) {
    content?.let { MDCCardMediaScope(this).it() }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCDsl
@Composable
public fun MDCCardMediaScope.MDCCardMediaContent(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null
) {
  Div(
    attrs = {
      classes("mdc-card__media-content")
      attrs?.invoke(this)
    },
    content = content?.let { { MDCCardScope(this).it() } }
  )
}
