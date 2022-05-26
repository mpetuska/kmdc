package dev.petuska.kmdc.dialog

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

public interface MDCDialogTitleScope<T : Element> : ElementScope<T>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCContentDsl
@Composable
public fun MDCDialogTitleScope<*>.Title(
  attrs: MDCAttrsRaw<HTMLHeadingElement>? = null,
  content: MDCContentRaw<HTMLHeadingElement>? = null
) {
  val titleId = TitleIdLocal.current
  H2(
    attrs = {
      classes("mdc-dialog__title")
      id(titleId)
      attrs?.invoke(this)
    },
    content = content.reinterpret()
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-dialog)
 */
@MDCContentDsl
@Composable
public fun MDCDialogTitleScope<*>.Title(
  title: String,
  attrs: MDCAttrsRaw<HTMLHeadingElement>? = null
) {
  Title(attrs) { Text(title) }
}
