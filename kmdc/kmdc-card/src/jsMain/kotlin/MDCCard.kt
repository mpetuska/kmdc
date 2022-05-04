package dev.petuska.kmdc.card

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
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
  opts: Builder<MDCCardOpts>? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCCardScope>? = null
) {
  MDCCardCSS
  val options = MDCCardOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-card", *options.type.classes)
      attrs?.invoke(this)
    },
    content = content?.let { { MDCCardScope(this).it() } }
  )
}
