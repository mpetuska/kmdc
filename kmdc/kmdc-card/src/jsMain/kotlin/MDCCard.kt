package dev.petuska.kmdc.card

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

@JsModule("@material/card/dist/mdc.card.css")
private external val MDCCardCSS: dynamic

public data class MDCCardOpts(var type: Type = Type.Elevated) {
  public enum class Type(public vararg val classes: String) {
    Elevated,
    Outlined("mdc-card--outlined")
  }
}

public class MDCCardScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCDsl
@Composable
public fun MDCCard(
  opts: MDCAttrs<MDCCardOpts>? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCCardScope>? = null
) {
  MDCCardCSS
  val options = MDCCardOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-card")
      classes(options.type.classes)
      attrs?.invoke(this)
    },
    content = content?.let { { MDCCardScope(this).it() } }
  )
}
