package dev.petuska.kmdc.textfield.icon

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.textfield.MDCTextFieldScope
import org.jetbrains.compose.web.dom.I
import org.w3c.dom.HTMLElement

@Composable
@KMDCInternalAPI
internal fun MDCTextFieldScope.MDCTextFieldIcon(
  leading: Boolean,
  clickable: Boolean = false,
  attrs: MDCAttrsRaw<HTMLElement>? = null,
  content: MDCContentRaw<HTMLElement>? = null,
) {
  I(
    attrs = {
      classes("mdc-text-field__icon")
      if (leading) {
        classes("mdc-text-field__icon--leading")
      } else {
        classes("mdc-text-field__icon--trailing")
      }
      if (clickable) {
        tabIndex(0)
        role("button")
      }
      attrs?.invoke(this)
    },
    content = {
      MDCProvider(::MDCTextFieldIcon) {
        applyContent(content)
      }
    }
  )
}

@MDCContentDsl
@Composable
public fun MDCTextFieldScope.MDCTextFieldLeadingIcon(
  clickable: Boolean = false,
  attrs: MDCAttrsRaw<HTMLElement>? = null,
  content: MDCContentRaw<HTMLElement>? = null,
) {
  MDCTextFieldIcon(
    leading = true,
    clickable = clickable,
    attrs = attrs,
    content = content,
  )
}

@MDCContentDsl
@Composable
public fun MDCTextFieldScope.MDCTextFieldTrailingIcon(
  clickable: Boolean = false,
  attrs: MDCAttrsRaw<HTMLElement>? = null,
  content: MDCContentRaw<HTMLElement>? = null,
) {
  MDCTextFieldIcon(
    leading = false,
    clickable = clickable,
    attrs = attrs,
    content = content,
  )
}
