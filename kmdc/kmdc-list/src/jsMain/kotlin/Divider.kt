package dev.petuska.kmdc.list

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.MDCAttrs
import dev.petuska.kmdc.core.MDCContentRaw
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.classes
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Hr
import org.jetbrains.compose.web.dom.Li
import org.w3c.dom.HTMLHRElement
import org.w3c.dom.HTMLLIElement

public enum class MDCListDividerInset(public vararg var classes: String) {
  None,
  Leading("mdc-deprecated-list-divider--inset-leading"),
  Trailing("mdc-deprecated-list-divider--inset-trailing"),
  Padding("mdc-deprecated-list-divider--inset-padding")
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListScope<*>.Divider(
  inset: MDCListDividerInset = MDCListDividerInset.None,
  attrs: MDCAttrs<AttrsScope<HTMLLIElement>>? = null,
  content: MDCContentRaw<HTMLLIElement>? = null,
) {
  Li(
    attrs = {
      classes("mdc-deprecated-list-divider")
      classes(inset.classes)
      attr("role", "separator")
      attrs?.invoke(this)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCDsl
@Composable
public fun MDCListGroupScope.Divider(
  inset: MDCListDividerInset = MDCListDividerInset.None,
  attrs: MDCAttrs<AttrsScope<HTMLHRElement>>? = null,
) {
  Hr(
    attrs = {
      classes("mdc-deprecated-list-divider")
      classes(inset.classes)
      attrs?.invoke(this)
    },
  )
}
