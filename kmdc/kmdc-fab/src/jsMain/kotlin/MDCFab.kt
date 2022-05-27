package dev.petuska.kmdc.fab

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.ripple.MDCRippleLayout
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLSpanElement

@JsModule("@material/fab/mdc-fab.scss")
private external val Style: dynamic

public enum class MDCFabType(public vararg val classes: String) {
  Regular, Mini("mdc-fab--mini"), Extended("mdc-fab--extended")
}

public interface MDCFabScope : ElementScope<HTMLButtonElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-fab)
 */
@MDCContentDsl
@Composable
public fun MDCFab(
  type: MDCFabType = MDCFabType.Regular,
  exited: Boolean = false,
  touch: Boolean = false,
  attrs: MDCAttrsRaw<HTMLButtonElement>? = null,
  content: MDCContent<MDCFabScope>? = null
) {
  Style
  Button(
    attrs = {
      classes("mdc-fab")
      classes(type.classes)
      if (touch) classes("mdc-fab--touch")
      if (exited) classes("mdc-fab--exited")
      applyAttrs(attrs)
    }
  ) {
    Div(attrs = { classes("mdc-fab__ripple") })
    MDCRippleLayout(keys = arrayOf(type))
    applyContent(content)
    if (touch) Div(attrs = { classes("mdc-fab__touch") })
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-fab)
 */
@MDCContentDsl
@Composable
public fun MDCFabScope.Icon(
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContentRaw<HTMLSpanElement>? = null
) {
  Span(
    attrs = {
      classes("mdc-fab__icon")
      applyAttrs(attrs)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-fab)
 */
@MDCContentDsl
@Composable
public fun MDCFabScope.Label(
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContentRaw<HTMLSpanElement>? = null
) {
  Span(
    attrs = {
      classes("mdc-fab__label")
      applyAttrs(attrs)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-fab)
 */
@MDCContentDsl
@Composable
public fun MDCFabScope.Label(
  text: String,
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
) {
  Label(
    attrs = attrs,
    content = { Text(text) }
  )
}
