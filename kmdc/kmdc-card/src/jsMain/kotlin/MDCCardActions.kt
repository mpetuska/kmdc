package dev.petuska.kmdc.card

import androidx.compose.runtime.*
import dev.petuska.kmdc.button.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.icon.button.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

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
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
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
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
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
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
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
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
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
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  content: MDCContent<MDCIconButtonScope<HTMLButtonElement>>? = null
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
  attrs: MDCAttrsRaw<HTMLAnchorElement>? = null,
  content: MDCContent<MDCIconButtonScope<HTMLAnchorElement>>? = null
) {
  MDCIconLink(
    attrs = {
      classes("mdc-card__action", "mdc-card__action--icon")
      attrs?.invoke(this)
    },
    content = content
  )
}
