package dev.petuska.kmdc.top.app.bar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCInitEffect
import dev.petuska.kmdc.core.applyContent
import dev.petuska.kmdc.core.classes
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Main
import org.w3c.dom.HTMLElement

@JsModule("@material/top-app-bar/dist/mdc.top-app-bar.css")
private external val MDCTopAppBarStyle: dynamic

public data class MDCTopAppBarContextOpts(
  var type: Type = Type.Default,
) {
  public enum class Type(public val mainAdjustClass: String, public vararg val classes: String) {
    Default("mdc-top-app-bar--fixed-adjust"),
    Short("mdc-top-app-bar--short-fixed-adjust", "mdc-top-app-bar--short"),
    ShortCollapsed("mdc-top-app-bar--short-fixed-adjust", "mdc-top-app-bar--short", "mdc-top-app-bar--short-collapsed"),
    Fixed("mdc-top-app-bar--fixed-adjust", "mdc-top-app-bar--fixed"),
    Prominent("mdc-top-app-bar--prominent-fixed-adjust", "mdc-top-app-bar--prominent"),
    Dense("mdc-top-app-bar--dense-fixed-adjust", "mdc-top-app-bar--dense")
  }
}

public val MDCTopAppBarType: ProvidableCompositionLocal<MDCTopAppBarContextOpts.Type> =
  compositionLocalOf { MDCTopAppBarContextOpts.Type.Default }

public class MDCTopAppBarContextScope

public interface MDCTopAppBarScope : ElementScope<HTMLElement>

/**
 * If using this [MDCTopAppBar] component, all the page content must be placed into [MDCTopAppBarMain] container.
 *
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCDsl
@Composable
public fun MDCTopAppBarContext(
  opts: Builder<MDCTopAppBarContextOpts>? = null,
  content: ComposableBuilder<MDCTopAppBarContextScope>? = null
) {
  MDCTopAppBarStyle
  val options = MDCTopAppBarContextOpts().apply { opts?.invoke(this) }
  CompositionLocalProvider(MDCTopAppBarType provides options.type) {
    content?.let { MDCTopAppBarContextScope().it() }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCDsl
@Composable
public fun MDCTopAppBarContextScope.MDCTopAppBar(
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: ComposableBuilder<MDCTopAppBarScope>? = null
) {
  val type = MDCTopAppBarType.current
  Header(
    attrs = {
      classes("mdc-top-app-bar")
      classes(type.classes)
      attrs?.invoke(this)
    },
  ) {
    MDCInitEffect(MDCTopAppBarModule::MDCTopAppBar)
    applyContent(content)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCDsl
@Composable
public fun MDCTopAppBarContextScope.MDCTopAppBarMain(
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: ContentBuilder<HTMLElement>? = null
) {
  val type = MDCTopAppBarType.current
  Main(
    attrs = {
      classes(type.mainAdjustClass)
      attrs?.invoke(this)
    },
    content = content
  )
}
