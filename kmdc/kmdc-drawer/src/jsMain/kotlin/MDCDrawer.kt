package dev.petuska.kmdc.drawer

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.*

@JsModule("@material/drawer/dist/mdc.drawer.css")
private external val MDCDrawerCSS: dynamic

public data class MDCDrawerOpts(
  var type: Type = Type.Dismissible,
  var state: State = State.Closed,
  var isOpen: Boolean = false,
) {
  public enum class Type(public vararg val classes: String) {
    Dismissible("mdc-drawer--dismissible"),
    Modal("mdc-drawer--modal"),
  }

  public enum class State(public vararg val classes: String) {
    Closed,
    Open("mdc-drawer--open"),
    Opening("mdc-drawer--opening"),
    Closing("mdc-drawer--closing"),
  }
}

public class MDCDrawerScope(scope: ElementScope<HTMLElement>) : ElementScope<HTMLElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-drawer)
 */
@MDCDsl
@Composable
public fun MDCDrawer(
  opts: MDCAttrs<MDCDrawerOpts>? = null,
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: MDCContent<MDCDrawerScope>? = null
) {
  MDCDrawerCSS
  val options = MDCDrawerOpts().apply { opts?.invoke(this) }
  Aside(
    attrs = {
      classes("mdc-drawer")
      classes(options.type.classes)
      classes(options.state.classes)
      attrs?.invoke(this)
    },
  ) {
    MDCInitEffect(MDCDrawerModule::MDCDrawer)
    MDCStateEffect(options.isOpen, MDCDrawerModule.MDCDrawer::open)
    content?.let { MDCDrawerScope(this).it() }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-drawer)
 */
@MDCDsl
@Composable
public fun MDCDrawerScrim(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null
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
@MDCAttrsDsl
public fun AttrsScope<*>.mdcDrawerAppContent() {
  classes("mdc-drawer-app-content")
}
