package dev.petuska.kmdc.dialog

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

public class MDCDialogTitleScope(scope: ElementScope<HTMLHeadingElement>) : ElementScope<HTMLHeadingElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCDsl
@Composable
public fun MDCDialogScope.MDCDialogTitle(
  attrs: AttrBuilderContext<HTMLHeadingElement>? = null,
  content: MDCContent<MDCDialogTitleScope>? = null
) {
  MDCDialogTitleImpl(titleId, attrs, content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCDsl
@Composable
public fun MDCDialogScope.MDCDialogTitle(
  title: String,
  attrs: AttrBuilderContext<HTMLHeadingElement>? = null
) {
  MDCDialogTitleImpl(titleId, attrs) { Text(title) }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCDsl
@Composable
public fun MDCDialogHeaderScope.MDCDialogTitle(
  attrs: AttrBuilderContext<HTMLHeadingElement>? = null,
  content: MDCContent<MDCDialogTitleScope>? = null
) {
  MDCDialogTitleImpl(titleId, attrs, content)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCDsl
@Composable
public fun MDCDialogHeaderScope.MDCDialogTitle(
  title: String,
  attrs: AttrBuilderContext<HTMLHeadingElement>? = null
) {
  MDCDialogTitleImpl(titleId, attrs) { Text(title) }
}

@Composable
private fun MDCDialogTitleImpl(
  titleId: String,
  attrs: AttrBuilderContext<HTMLHeadingElement>? = null,
  content: MDCContent<MDCDialogTitleScope>? = null
) {
  H3(
    attrs = {
      classes("mdc-dialog__title")
      id(titleId)
      attrs?.invoke(this)
    },
    content = {
      content?.let { MDCDialogTitleScope(this).it() }
    }
  )
}
