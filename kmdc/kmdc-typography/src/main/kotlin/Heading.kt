package dev.petuska.kmdc.typography

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrsRaw
import dev.petuska.kmdc.core.MDCContentDsl
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLHeadingElement

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCContentDsl
@Composable
public fun MDCH1(text: String, attrs: MDCAttrsRaw<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Headline1, text, attrs) { a, c ->
    H1(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCContentDsl
@Composable
public fun MDCH2(text: String, attrs: MDCAttrsRaw<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Headline2, text, attrs) { a, c ->
    H2(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCContentDsl
@Composable
public fun MDCH3(text: String, attrs: MDCAttrsRaw<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Headline3, text, attrs) { a, c ->
    H3(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCContentDsl
@Composable
public fun MDCH4(text: String, attrs: MDCAttrsRaw<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Headline4, text, attrs) { a, c ->
    H4(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCContentDsl
@Composable
public fun MDCH5(text: String, attrs: MDCAttrsRaw<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Headline5, text, attrs) { a, c ->
    H5(a, c)
  }

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-typography)
 */
@MDCContentDsl
@Composable
public fun MDCH6(text: String, attrs: MDCAttrsRaw<HTMLHeadingElement>? = null): Unit =
  MDCText(MDCTypographyStyle.Headline6, text, attrs) { a, c ->
    H6(a, c)
  }
