package dev.petuska.kmdc.tooltip

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.Element
import org.w3c.dom.HTMLDivElement

@JsModule("@material/tooltip/dist/mdc.tooltip.css")
private external val MDCTooltipStyle: dynamic

public interface MDCTooltipScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCContentDsl
@Composable
public fun MDCTooltip(
  id: String,
  persistent: Boolean = false,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null,
) {
  MDCTooltipStyle
  Div(
    attrs = {
      id(id)
      classes("mdc-tooltip")
      attr("role", "tooltip")
      attr("aria-hidden", "true")
      if (persistent) {
        tabIndex(-1)
        attr("data-mdc-tooltip-persistent", "true")
      }
      applyAttrs(attrs)
    }
  ) {
    MDCInitEffect(::MDCTooltip, persistent)
    Div(
      attrs = { classes("mdc-tooltip__surface", "mdc-tooltip__surface-animation") },
      content = content.reinterpret()
    )
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-tooltip)
 */
@MDCContentDsl
@Composable
public fun MDCTooltip(
  id: String,
  text: String,
  persistent: Boolean = false,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
) {
  MDCTooltip(
    id = id,
    persistent = persistent,
    attrs = attrs
  ) {
    Text(text)
  }
}

/**
 * Attaches tooltip to this element
 * @param T
 * @param id tooltip ID
 * @param hidden whether this element should be hidden from screen-readers to avoid duplication with tooltip content
 */
@MDCAttrsDsl
public fun <T : Element> AttrsScope<T>.tooltipId(id: String, hidden: Boolean = false) {
  if (hidden) {
    attr("data-tooltip-id", id)
    attr("data-hide-tooltip-from-screenreader", "true")
  } else {
    attr("aria-describedby", id)
  }
}
