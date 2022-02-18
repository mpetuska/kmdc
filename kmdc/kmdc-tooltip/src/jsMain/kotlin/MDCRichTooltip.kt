package dev.petuska.kmdc.tooltip

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element
import org.w3c.dom.HTMLDivElement

public class MDCRichTooltipOpts(
  persistent: Boolean = false,
  public var interactive: Boolean = false,
) : MDCTooltipOpts(persistent)

public class MDCRichTooltipScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope
public class MDCRichTooltipAnchorScope(
  private val options: MDCRichTooltipOpts,
  scope: ElementScope<HTMLDivElement>
) : ElementScope<HTMLDivElement> by scope {
  /**
   * Attaches tooltip to this element
   * @param id tooltip ID
   */
  @MDCAttrsDsl
  public fun <E : Element> AttrsScope<E>.tooltipId(id: String): AttrsScope<E> = also {
    it.tooltipId(id, options.interactive)
    if (options.interactive) {
      attr("aria-haspopup", "dialog")
      attr("aria-expanded", "false")
    }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-tooltip)
 */
@MDCDsl
@Composable
public fun MDCRichTooltip(
  id: String,
  opts: Builder<MDCRichTooltipOpts>? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  anchorContent: ComposableBuilder<MDCRichTooltipAnchorScope>? = null,
  tooltipContent: ComposableBuilder<MDCRichTooltipScope>? = null,
) {
  val options = MDCRichTooltipOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-tooltip-wrapper--rich")
      attrs?.invoke(this)
    },
  ) {
    anchorContent?.let { MDCRichTooltipAnchorScope(options, this).it() }
    MDCTooltip(
      id = id,
      opts = { persistent = options.persistent },
      attrs = {
        classes("mdc-tooltip--rich")
        if (options.interactive) attr("role", "dialog")
        attrs?.invoke(this)
      },
      content = tooltipContent?.let { { MDCRichTooltipScope(this).it() } }
    )
  }
}
