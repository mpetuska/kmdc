package dev.petuska.kmdc.card

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.classes
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

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
