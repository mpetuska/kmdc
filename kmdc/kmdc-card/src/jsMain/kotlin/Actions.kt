package dev.petuska.kmdc.card

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.button.*
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContent
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.reinterpret
import dev.petuska.kmdc.icon.button.MDCIconButton
import dev.petuska.kmdc.icon.button.MDCIconButtonScope
import dev.petuska.kmdc.icon.button.MDCIconLink
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement

public interface MDCCardActionsScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCContentDsl
@Composable
public fun MDCCardScope.Actions(
  fullBleed: Boolean = false,
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCCardActionsScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-card__actions")
      if (fullBleed) classes("mdc-card__actions--full-bleed")
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCContentDsl
@Composable
public fun MDCCardActionsScope.ActionButtons(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCCardActionsScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-card__action-buttons")
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCContentDsl
@Composable
public fun MDCCardActionsScope.ActionButton(
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  touch: Boolean = false,
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  content: MDCContent<MDCButtonScope<HTMLButtonElement>>? = null
) {
  MDCButton(
    type = type,
    icon = icon,
    touch = touch,
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
@MDCContentDsl
@Composable
public fun MDCCardActionsScope.ActionButtonLink(
  href: String? = null,
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  touch: Boolean = false,
  attrs: MDCAttrsRaw<HTMLAnchorElement>? = null,
  content: MDCContent<MDCButtonScope<HTMLAnchorElement>>? = null
) {
  MDCButtonLink(
    href = href,
    type = type,
    icon = icon,
    touch = touch,
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
@MDCContentDsl
@Composable
public fun MDCCardActionsScope.ActionIcons(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContent<MDCCardActionsScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-card__action-icons")
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-card)
 */
@MDCContentDsl
@Composable
public fun MDCCardActionsScope.ActionIconButton(
  on: Boolean = false,
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  content: MDCContent<MDCIconButtonScope<HTMLButtonElement>>? = null
) {
  MDCIconButton(
    on = on,
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
@MDCContentDsl
@Composable
public fun MDCCardActionsScope.ActionIconLink(
  on: Boolean? = null,
  attrs: MDCAttrsRaw<HTMLAnchorElement>? = null,
  content: MDCContent<MDCIconButtonScope<HTMLAnchorElement>>? = null
) {
  MDCIconLink(
    on = on,
    attrs = {
      classes("mdc-card__action", "mdc-card__action--icon")
      attrs?.invoke(this)
    },
    content = content
  )
}
