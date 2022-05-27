package dev.petuska.kmdc.drawer

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Aside
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement

@JsModule("@material/drawer/mdc-drawer.scss")
private external val Style: dynamic

public enum class MDCDrawerType(public vararg val classes: String) {
  Dismissible("mdc-drawer--dismissible"),
  Modal("mdc-drawer--modal"),
}

public enum class MDCDrawerState(public vararg val classes: String) {
  Closed,
  Open("mdc-drawer--open"),
  Opening("mdc-drawer--opening"),
  Closing("mdc-drawer--closing"),
}

public interface MDCDrawerAttrsScope : AttrsScope<HTMLElement>
public interface MDCDrawerScope : ElementScope<HTMLElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-drawer)
 */
@MDCContentDsl
@Composable
public fun MDCDrawer(
  open: Boolean,
  type: MDCDrawerType = MDCDrawerType.Dismissible,
  attrs: MDCAttrs<MDCDrawerAttrsScope>? = null,
  content: MDCContent<MDCDrawerScope>? = null
) {
  Style
  Aside(
    attrs = {
      classes("mdc-drawer")
      classes(type.classes)
//      classes(state.classes)
      applyAttrs(attrs)
    },
  ) {
    MDCProvider(::MDCDrawer, type) {
      MDCStateEffectNew(open, MDCDrawer::open)
      applyContent(content)
    }
  }
  if (type == MDCDrawerType.Modal) {
    MDCDrawerScrim()
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-drawer)
 */
@MDCContentDsl
@Composable
private fun MDCDrawerScrim(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContentRaw<HTMLDivElement>? = null
) {
  Div(
    attrs = {
      classes("mdc-drawer-scrim")
      attrs?.invoke(this)
    },
    content = content,
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-drawer)
 */
@MDCContentDsl
@Composable
public fun MDCDrawerAppContent(
  attrs: MDCAttrsRaw<HTMLDivElement>? = null,
  content: MDCContentRaw<HTMLDivElement>? = null,
) {
  Div(
    attrs = {
      classes("mdc-drawer-app-content")
      applyAttrs(attrs)
    },
    content = content
  )
}
