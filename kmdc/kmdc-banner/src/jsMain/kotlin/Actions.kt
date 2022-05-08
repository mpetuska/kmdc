package dev.petuska.kmdc.banner

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonIconType
import dev.petuska.kmdc.button.MDCButtonLabel
import dev.petuska.kmdc.button.MDCButtonScope
import dev.petuska.kmdc.button.MDCButtonType
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.reinterpret
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement

public interface MDCBannerActionsScope : ElementScope<HTMLDivElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCDsl
@Composable
public fun MDCBannerScope.Actions(
  attrs: AttrsBuilder<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCBannerActionsScope>? = null,
) {
  Div(
    attrs = {
      classes("mdc-banner__actions")
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}

public interface MDCBannerActionScope : ElementScope<HTMLButtonElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCDsl
@Composable
private fun MDCBannerActionsScope.Action(
  primary: Boolean,
  type: MDCButtonType,
  icon: MDCButtonIconType,
  attrs: AttrsBuilder<HTMLButtonElement>?,
  content: ComposableBuilder<MDCButtonScope>?,
) {
  MDCButton(
    type = type,
    icon = icon,
    attrs = {
      classes("mdc-banner__${if (primary) "primary" else "secondary"}-action")
      type(ButtonType.Button)
      applyAttrs(attrs)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCDsl
@Composable
public fun MDCBannerActionsScope.PrimaryAction(
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  attrs: AttrsBuilder<HTMLButtonElement>? = null,
  content: ComposableBuilder<MDCButtonScope>? = null,
) {
  Action(true, type, icon, attrs, content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCDsl
@Composable
public fun MDCBannerActionsScope.PrimaryAction(
  text: String,
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  attrs: AttrsBuilder<HTMLButtonElement>? = null,
) {
  Action(true, type, icon, attrs) {
    MDCButtonLabel(text)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCDsl
@Composable
public fun MDCBannerActionsScope.SecondaryAction(
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  attrs: AttrsBuilder<HTMLButtonElement>? = null,
  content: ComposableBuilder<MDCButtonScope>? = null,
) {
  Action(false, type, icon, attrs, content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCDsl
@Composable
public fun MDCBannerActionsScope.SecondaryAction(
  text: String,
  type: MDCButtonType = MDCButtonType.Text,
  icon: MDCButtonIconType = MDCButtonIconType.None,
  attrs: AttrsBuilder<HTMLButtonElement>? = null,
) {
  Action(false, type, icon, attrs) {
    MDCButtonLabel(text)
  }
}
