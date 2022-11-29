package dev.petuska.kmdc.image.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLImageElement
import org.w3c.dom.HTMLLIElement
import org.w3c.dom.HTMLSpanElement
import org.w3c.dom.HTMLUListElement

@JsModule("@material/image-list/mdc-image-list.scss")
private external val Style: dynamic

public enum class MDCImageListType(public vararg val classes: String) {
  Standard, Masonry("mdc-image-list--masonry")
}

public interface MDCImageListScope : ElementScope<HTMLUListElement>

private val MDCImageListTypeLocal = strictCompositionLocalOf<MDCImageListType>()

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-image-list)
 */
@MDCContentDsl
@Composable
public fun MDCImageList(
  type: MDCImageListType = MDCImageListType.Standard,
  withTextProtection: Boolean = false,
  attrs: MDCAttrsRaw<HTMLUListElement>? = null,
  content: MDCContent<MDCImageListScope>? = null
) {
  Style
  CompositionLocalProvider(MDCImageListTypeLocal provides type) {
    Ul(
      attrs = {
        classes("mdc-image-list")
        classes(type.classes)
        if (withTextProtection) classes("mdc-image-list--with-text-protection")
        applyAttrs(attrs)
      },
      content = content.reinterpret()
    )
  }
}

public interface MDCImageListItemScope : ElementScope<HTMLLIElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-image-list)
 */
@MDCContentDsl
@Composable
public fun MDCImageListScope.Item(
  attrs: MDCAttrsRaw<HTMLLIElement>? = null,
  content: MDCContent<MDCImageListItemScope>? = null
) {
  Li(
    attrs = {
      classes("mdc-image-list__item")
      applyAttrs(attrs)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-image-list)
 */
@MDCContentDsl
@Composable
public fun MDCImageListItemScope.Image(
  src: String,
  alt: String = "",
  attrs: MDCAttrsRaw<HTMLImageElement>? = null,
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
@MDCContentDsl
@Composable
public fun MDCImageListItemScope.Label(
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
  content: MDCContentRaw<HTMLSpanElement>? = null,
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
@MDCContentDsl
@Composable
public fun MDCImageListItemScope.Label(
  text: String,
  attrs: MDCAttrsRaw<HTMLSpanElement>? = null,
) {
  Label(attrs) { Text(text) }
}
