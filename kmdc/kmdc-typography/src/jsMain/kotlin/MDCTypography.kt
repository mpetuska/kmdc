package dev.petuska.kmdc.typography

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentDsl
import dev.petuska.kmdc.core.MDCContentRaw
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLHeadingElement
import org.w3c.dom.HTMLParagraphElement
import org.w3c.dom.HTMLSpanElement

@JsModule("@material/typography/mdc-typography.scss")
private external val Style: dynamic

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCAttrsDsl
public fun AttrsScope<*>.mdcTypography() {
  classes("mdc-typography")
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCContentDsl
@Composable
internal fun <T : HTMLElement> MDCText(
  style: MDCTypographyStyle,
  text: String,
  attrs: MDCAttrsRaw<T>?,
  element: @Composable (attrs: MDCAttrsRaw<T>?, content: MDCContentRaw<T>?) -> Unit,
) {
  Style
  val clazz = "mdc-typography--${style.style}"
  element({
    classes(clazz)
    attrs?.invoke(this)
  }) {
    Text(text)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCContentDsl
@Composable
public fun MDCSubtitle1(text: String, attrs: MDCAttrsRaw<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Subtitle1, text, attrs) { a, c ->
    H6(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCContentDsl
@Composable
public fun MDCSubtitle2(text: String, attrs: MDCAttrsRaw<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Subtitle2, text, attrs) { a, c ->
    H6(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCContentDsl
@Composable
public fun MDCBody1(text: String, attrs: MDCAttrsRaw<HTMLParagraphElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Body1, text, attrs) { a, c ->
    P(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCContentDsl
@Composable
public fun MDCBody2(text: String, attrs: MDCAttrsRaw<HTMLParagraphElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Body2, text, attrs) { a, c ->
    P(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCContentDsl
@Composable
public fun MDCCaption(text: String, attrs: MDCAttrsRaw<HTMLSpanElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Caption, text, attrs) { a, c ->
    Span(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCContentDsl
@Composable
public fun MDCButtonText(text: String, attrs: MDCAttrsRaw<HTMLSpanElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Button, text, attrs) { a, c ->
    Span(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCContentDsl
@Composable
public fun MDCOverline(text: String, attrs: MDCAttrsRaw<HTMLSpanElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Overline, text, attrs) { a, c ->
    Span(a, c)
  }
