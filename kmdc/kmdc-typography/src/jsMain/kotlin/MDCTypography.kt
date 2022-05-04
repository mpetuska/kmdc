package dev.petuska.kmdc.typography

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.H5
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLHeadingElement
import org.w3c.dom.HTMLParagraphElement
import org.w3c.dom.HTMLSpanElement

@JsModule("@material/typography/dist/mdc.typography.css")
private external val MDCTypographyCSS: dynamic

public enum class MDCTypographyStyle(public val style: String) {
  Headline1(style = "headline1"),
  Headline2(style = "headline2"),
  Headline3(style = "headline3"),
  Headline4(style = "headline4"),
  Headline5(style = "headline5"),
  Headline6(style = "headline6"),
  Subtitle1(style = "subtitle1"),
  Subtitle2(style = "subtitle2"),
  Body1(style = "body1"),
  Body2(style = "body2"),
  Caption(style = "caption"),
  Button(style = "button"),
  Overline(style = "overline"),
}

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
@MDCDsl
@Composable
private fun <T : HTMLElement> MDCText(
  style: MDCTypographyStyle,
  text: String,
  attrs: AttrBuilderContext<T>?,
  element: @Composable (attrs: AttrBuilderContext<T>?, content: ContentBuilder<T>?) -> Unit,
) {
  MDCTypographyCSS
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
@MDCDsl
@Composable
public fun MDCH1(text: String, attrs: AttrBuilderContext<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Headline1, text, attrs) { a, c ->
    H1(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCH2(text: String, attrs: AttrBuilderContext<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Headline2, text, attrs) { a, c ->
    H2(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCH3(text: String, attrs: AttrBuilderContext<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Headline3, text, attrs) { a, c ->
    H3(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCH4(text: String, attrs: AttrBuilderContext<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Headline4, text, attrs) { a, c ->
    H4(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCH5(text: String, attrs: AttrBuilderContext<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Headline5, text, attrs) { a, c ->
    H5(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCH6(text: String, attrs: AttrBuilderContext<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Headline6, text, attrs) { a, c ->
    H6(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCSubtitle1(text: String, attrs: AttrBuilderContext<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Subtitle1, text, attrs) { a, c ->
    H6(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCSubtitle2(text: String, attrs: AttrBuilderContext<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Subtitle2, text, attrs) { a, c ->
    H6(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCBody1(text: String, attrs: AttrBuilderContext<HTMLParagraphElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Body1, text, attrs) { a, c ->
    P(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCBody2(text: String, attrs: AttrBuilderContext<HTMLParagraphElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Body2, text, attrs) { a, c ->
    P(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCCaption(text: String, attrs: AttrBuilderContext<HTMLSpanElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Caption, text, attrs) { a, c ->
    Span(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCButtonText(text: String, attrs: AttrBuilderContext<HTMLSpanElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Button, text, attrs) { a, c ->
    Span(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCOverline(text: String, attrs: AttrBuilderContext<HTMLSpanElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Overline, text, attrs) { a, c ->
    Span(a, c)
  }
