package dev.petuska.kmdc.top.app.bar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Main
import org.w3c.dom.HTMLElement

@JsModule("@material/top-app-bar/mdc-top-app-bar.scss")
private external val Style: dynamic

public enum class MDCTopAppBarType(public val mainAdjustClass: String, public vararg val classes: String) {
  Default("mdc-top-app-bar--fixed-adjust"),
  Short("mdc-top-app-bar--short-fixed-adjust", "mdc-top-app-bar--short"),
  ShortCollapsed("mdc-top-app-bar--short-fixed-adjust", "mdc-top-app-bar--short", "mdc-top-app-bar--short-collapsed"),
  Fixed("mdc-top-app-bar--fixed-adjust", "mdc-top-app-bar--fixed"),
  Prominent("mdc-top-app-bar--prominent-fixed-adjust", "mdc-top-app-bar--prominent"),
  Dense("mdc-top-app-bar--dense-fixed-adjust", "mdc-top-app-bar--dense")
}

internal val MDCTopAppBarTypeLocal = strictCompositionLocalOf<MDCTopAppBarType>()

public class MDCTopAppBarContextScope

public interface MDCTopAppBarAttrsScope : AttrsScope<HTMLElement>
public interface MDCTopAppBarScope : ElementScope<HTMLElement>

/**
 * If using this [TopAppBar] component, all the page content must be placed into [Main] container.
 *
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCContentDsl
@Composable
public fun MDCTopAppBar(
  type: MDCTopAppBarType = MDCTopAppBarType.Default,
  content: MDCContent<MDCTopAppBarContextScope>? = null
) {
  Style
  CompositionLocalProvider(MDCTopAppBarTypeLocal provides type) {
    content?.let { MDCTopAppBarContextScope().it() }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCContentDsl
@Composable
public fun MDCTopAppBarContextScope.TopAppBar(
  attrs: MDCAttrs<MDCTopAppBarAttrsScope>? = null,
  content: MDCContent<MDCTopAppBarScope>? = null
) {
  val type = MDCTopAppBarTypeLocal.current
  Header(
    attrs = {
      classes("mdc-top-app-bar")
      classes(type.classes)
      applyAttrs(attrs)
    },
  ) {
    MDCProvider(::MDCTopAppBar) {
      applyContent(content)
    }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-top-app-bar)
 */
@MDCContentDsl
@Composable
public fun MDCTopAppBarContextScope.Main(
  attrs: MDCAttrsRaw<HTMLElement>? = null,
  content: MDCContentRaw<HTMLElement>? = null
) {
  val type = MDCTopAppBarTypeLocal.current
  org.jetbrains.compose.web.dom.Main(
    attrs = {
      classes(type.mainAdjustClass)
      attrs?.invoke(this)
    },
    content = content
  )
}
