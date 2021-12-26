package dev.petuska.kmdc.tooltip

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.mdc
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.Element
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.events.Event

@JsModule("@material/tooltip/dist/mdc.tooltip.css")
private external val MDCTooltipStyle: dynamic

@JsModule("@material/tooltip")
public external object MDCTooltipModule {
  public class MDCTooltip(element: Element) {
    public companion object {
      public fun attachTo(element: Element): MDCTooltip
    }

    public fun initialize()
    public fun initialSyncWithDOM()
    public fun destroy()
    public fun setTooltipPosition(
      xPos: dynamic = definedExternally,
      yPos: dynamic = definedExternally,
      withCaretPos: dynamic = definedExternally,
    )

    public fun setAnchorBoundaryType(type: dynamic)
    public fun setShowDelay(delayMs: Number)
    public fun setHideDelay(delayMs: Number)
    public fun hide()
    public fun isShown(): Boolean
    public fun <E : Event> attachScrollHandler(
      addEventListenerFn: (event: dynamic, handler: (event: E) -> Unit) -> Unit
    )

    public fun <E : Event> removeScrollHandler(
      removeEventHandlerFn: (event: dynamic, handler: (event: E) -> Unit) -> Unit
    )

    public fun getDefaultFoundation(): dynamic

    public var checked: Boolean
    public var indeterminate: Boolean
    public var disabled: Boolean
    public var value: String
  }
}

public open class MDCTooltipOpts(
  public var persistent: Boolean = false,
)

public class MDCTooltipScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-tooltip)
 */
@MDCDsl
@Composable
public fun MDCTooltip(
  id: String,
  opts: Builder<MDCTooltipOpts>? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null,
) {
  MDCTooltipStyle
  val options = MDCTooltipOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      id(id)
      classes("mdc-tooltip")
      attr("role", "tooltip")
      attr("aria-hidden", "true")
      if (options.persistent) {
        tabIndex(-1)
        attr("data-mdc-tooltip-persistent", "true")
      }
      ref {
        val mdc = MDCTooltipModule.MDCTooltip.attachTo(it)
        it.mdc = mdc
        onDispose {
          it.mdc<MDCTooltipModule.MDCTooltip> { destroy() }
        }
      }
      attrs?.invoke(this)
    }
  ) {
    Div(
      attrs = { classes("mdc-tooltip__surface", "mdc-tooltip__surface-animation") },
      content = content?.let { { MDCTooltipScope(this).it() } }
    )
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-tooltip)
 */
@MDCDsl
@Composable
public fun MDCTooltip(
  id: String,
  text: String,
  opts: Builder<MDCTooltipOpts>? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
) {
  MDCTooltip(
    id = id,
    opts = opts,
    attrs = attrs
  ) {
    Text(text)
  }
}

/**
 * Attaches tooltip to this element
 * @param id tooltip ID
 * @param hidden whether this element should be hidden from screen-readers to avoid duplication with tooltip content
 */
@MDCAttrsDsl
public fun <T : Element> AttrsBuilder<T>.tooltipId(id: String, hidden: Boolean = false): AttrsBuilder<T> = if (hidden) {
  attr("data-tooltip-id", id)
  attr("data-hide-tooltip-from-screenreader", "true")
} else {
  attr("aria-describedby", id)
}
