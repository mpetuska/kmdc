package dev.petuska.kmdc.image.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import dev.petuska.kmdc.core.AttrsBuilder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.ContentBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.classes
import dev.petuska.kmdc.core.reinterpret
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul
import org.w3c.dom.HTMLImageElement
import org.w3c.dom.HTMLLIElement
import org.w3c.dom.HTMLSpanElement
import org.w3c.dom.HTMLUListElement

@JsModule("@material/image-list/mdc-image-list.scss")
private external val MDCImageListStyles: dynamic

public enum class MDCImageListType(public vararg val classes: String) {
  Standard, Masonry("mdc-image-list--masonry")
}

public interface MDCImageListScope : ElementScope<HTMLUListElement>

private val MDCImageListTypeLocal = compositionLocalOf<MDCImageListType> { error("undefined") }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-image-list)
 */
@MDCDsl
@Composable
public fun MDCImageList(
  type: MDCImageListType = MDCImageListType.Standard,
  withTextProtection: Boolean = false,
  attrs: AttrsBuilder<HTMLUListElement>? = null,
  content: ComposableBuilder<MDCImageListScope>? = null
) {
  MDCImageListStyles
  CompositionLocalProvider(MDCImageListTypeLocal provides type) {
    Ul(
      attrs = {
        classes("mdc-image-list")
        classes(type.classes)
        if (withTextProtection) classes("mdc-image-list--with-text-protection")
        applyAttrs(attrs)
      }, content = content.reinterpret()
    )
  }
}

public interface MDCImageListItemScope : ElementScope<HTMLLIElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-image-list)
 */
@MDCDsl
@Composable
public fun MDCImageListScope.Item(
  attrs: AttrsBuilder<HTMLLIElement>? = null,
  content: ComposableBuilder<MDCImageListItemScope>? = null
) {
  Li(
    attrs = {
      classes("mdc-image-list__item")
      applyAttrs(attrs)
    }, content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-image-list)
 */
@MDCDsl
@Composable
public fun MDCImageListItemScope.Image(
  src: String,
  alt: String = "",
  attrs: AttrsBuilder<HTMLImageElement>? = null,
) {
  val innerContent = @Composable {
    Img(src = src, alt = alt, attrs = {
      classes("mdc-image-list__image")
      applyAttrs(attrs)
    })
  }
  if (MDCImageListTypeLocal.current != MDCImageListType.Masonry) {
    Div(attrs = {
      classes("mdc-image-list__image-aspect-container")
    }, content = {
      innerContent()
    })
  } else {
    innerContent()
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-image-list)
 */
@MDCDsl
@Composable
public fun MDCImageListItemScope.Label(
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null,
) {
  Div(
    attrs = {
      classes("mdc-image-list__supporting")
    },
    content = {
      Span(
        attrs = {
          classes("mdc-image-list__label")
          applyAttrs(attrs)
        },
        content = content
      )
    }
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-image-list)
 */
@MDCDsl
@Composable
public fun MDCImageListItemScope.Label(
  text: String,
  attrs: AttrsBuilder<HTMLSpanElement>? = null,
) {
  Label(attrs) { Text(text) }
}
