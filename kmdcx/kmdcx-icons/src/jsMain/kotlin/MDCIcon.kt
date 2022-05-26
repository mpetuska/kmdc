package dev.petuska.kmdcx.icons

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.classes
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.I
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLSpanElement

@JsModule("material-icons/iconfont/material-icons.css")
private external val Style: dynamic

/**
 * [JS API](https://github.com/marella/material-icons/tree/v1.10.4)
 */
@MDCAttrsDsl
public fun AttrsScope<*>.mdcIcons(type: MDCIconType = MDCIconType.Filled) {
  classes(type.classes)
}

/**
 * [JS API](https://github.com/marella/material-icons/tree/v1.10.4)
 */
@MDCContentDsl
@Composable
public fun MDCIcon(
  base: MDCIconBase,
  icon: MDCIcon,
  type: MDCIconType = MDCIconType.Filled,
  attrs: MDCAttrsRaw<out HTMLElement>? = null
) {
  when (base) {
    MDCIconBase.Span -> MDCIconSpan(icon, type, attrs)
    MDCIconBase.I -> MDCIconI(icon, type, attrs)
  }
}

/**
 * [JS API](https://github.com/marella/material-icons/tree/v1.10.4)
 */
@MDCContentDsl
@Composable
public fun MDCIconSpan(
  icon: MDCIcon,
  type: MDCIconType = MDCIconType.Filled,
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null
) {
  Style
  Span(attrs = {
    mdcIcons(type)
    attrs?.invoke(this)
  }) {
    Text(icon.type)
  }
}

/**
 * [JS API](https://github.com/marella/material-icons/tree/v1.10.4)
 */
@MDCContentDsl
@Composable
public fun MDCIconI(
  icon: MDCIcon,
  type: MDCIconType = MDCIconType.Filled,
  attrs: AttrBuilderContext<HTMLElement>? = null
) {
  Style
  I(attrs = {
    mdcIcons(type)
    attrs?.invoke(this)
  }) {
    Text(icon.type)
  }
}

public enum class MDCIconBase { I, Span }

public enum class MDCIconType(public vararg val classes: String) {
  Filled("material-icons"),
  Outlined("material-icons-outlined"),
  Round("material-icons-round"),
  Sharp("material-icons-sharp"),
  TwoTone("material-icons-two-tone")
}
