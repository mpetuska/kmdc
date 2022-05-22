package dev.petuska.kmdc.card

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonScope
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.classes
import dev.petuska.kmdc.icon.button.MDCIconButton
import dev.petuska.kmdc.icon.button.MDCIconButtonScope
import dev.petuska.kmdc.icon.button.MDCIconLink
import dev.petuska.kmdc.icon.button.MDCIconLinkScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement

public data class MDCCardActionsOpts(var type: Type = Type.Normal) {
  public enum class Type(public vararg val classes: String) {
    Normal,
    FullBleed("mdc-card__actions--full-bleed")
  }
}

public class MDCCardActionsScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCDsl
@Composable
public fun MDCCardScope.MDCCardActions(
  opts: MDCAttrs<MDCCardActionsOpts>? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCCardActionsScope>? = null
) {
  val options = MDCCardActionsOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-card__actions")
      classes(options.type.classes)
      attrs?.invoke(this)
    },
    content = content?.let { { MDCCardActionsScope(this).it() } }
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCDsl
@Composable
public fun MDCCardActionsScope.MDCCardActionButtons(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCCardActionsScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-card__action-buttons")
      attrs?.invoke(this)
    },
    content = content?.let { { MDCCardActionsScope(this).it() } }
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCDsl
@Composable
public fun MDCCardActionsScope.MDCCardActionButton(
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: MDCContent<MDCButtonScope>? = null
) {
  MDCButton(
    attrs = {
      classes("mdc-card__action", "mdc-card__action--button")
      attrs?.invoke(this)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCDsl
@Composable
public fun MDCCardActionsScope.MDCCardActionIcons(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: MDCContent<MDCCardActionsScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-card__action-icons")
      attrs?.invoke(this)
    },
    content = content?.let { { MDCCardActionsScope(this).it() } }
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCDsl
@Composable
public fun MDCCardActionsScope.MDCCardActionIconButton(
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: MDCContent<MDCIconButtonScope>? = null
) {
  MDCIconButton(
    attrs = {
      classes("mdc-card__action", "mdc-card__action--icon")
      attrs?.invoke(this)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCDsl
@Composable
public fun MDCCardActionsScope.MDCCardActionIconLink(
  attrs: AttrBuilderContext<HTMLAnchorElement>? = null,
  content: MDCContent<MDCIconLinkScope>? = null
) {
  MDCIconLink(
    attrs = {
      classes("mdc-card__action", "mdc-card__action--icon")
      attrs?.invoke(this)
    },
    content = content
  )
}
