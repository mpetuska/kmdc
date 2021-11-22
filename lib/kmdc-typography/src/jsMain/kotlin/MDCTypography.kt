package dev.petuska.kmdc.typography

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCDsl
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.H5
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

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
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-typography)
 */
@MDCAttrsDsl
public fun AttrsBuilder<*>.mdcTypography() {
  classes("mdc-typography")
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCText(
  style: MDCTypographyStyle,
  text: String,
) {
  MDCTypographyCSS
  val clazz = "mdc-typography--${style.style}"
  when (style) {
    MDCTypographyStyle.Headline1 -> H1({ classes(clazz) }) { Text(text) }
    MDCTypographyStyle.Headline2 -> H2({ classes(clazz) }) { Text(text) }
    MDCTypographyStyle.Headline3 -> H3({ classes(clazz) }) { Text(text) }
    MDCTypographyStyle.Headline4 -> H4({ classes(clazz) }) { Text(text) }
    MDCTypographyStyle.Headline5 -> H5({ classes(clazz) }) { Text(text) }
    MDCTypographyStyle.Headline6 -> H6({ classes(clazz) }) { Text(text) }
    MDCTypographyStyle.Subtitle1 -> H6({ classes(clazz) }) { Text(text) }
    MDCTypographyStyle.Subtitle2 -> H6({ classes(clazz) }) { Text(text) }
    MDCTypographyStyle.Body1 -> P({ classes(clazz) }) { Text(text) }
    MDCTypographyStyle.Body2 -> P({ classes(clazz) }) { Text(text) }
    MDCTypographyStyle.Caption -> Span({ classes(clazz) }) { Text(text) }
    MDCTypographyStyle.Button -> Span({ classes(clazz) }) { Text(text) }
    MDCTypographyStyle.Overline -> Span({ classes(clazz) }) { Text(text) }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCH1(text: String): Unit = MDCText(MDCTypographyStyle.Headline1, text)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCH2(text: String): Unit = MDCText(MDCTypographyStyle.Headline2, text)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCH3(text: String): Unit = MDCText(MDCTypographyStyle.Headline3, text)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCH4(text: String): Unit = MDCText(MDCTypographyStyle.Headline4, text)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCH5(text: String): Unit = MDCText(MDCTypographyStyle.Headline5, text)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCH6(text: String): Unit = MDCText(MDCTypographyStyle.Headline6, text)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCSubtitle1(text: String): Unit = MDCText(MDCTypographyStyle.Subtitle1, text)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCSubtitle2(text: String): Unit = MDCText(MDCTypographyStyle.Subtitle2, text)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCBody1(text: String): Unit = MDCText(MDCTypographyStyle.Body1, text)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCBody2(text: String): Unit = MDCText(MDCTypographyStyle.Body2, text)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCCaption(text: String): Unit = MDCText(MDCTypographyStyle.Caption, text)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCButtonText(text: String): Unit = MDCText(MDCTypographyStyle.Button, text)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-typography)
 */
@MDCDsl
@Composable
public fun MDCOverline(text: String): Unit = MDCText(MDCTypographyStyle.Overline, text)
