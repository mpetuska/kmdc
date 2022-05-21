package dev.petuska.kmdc.textfield

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.KMDCInternalAPI
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCInitEffect
import dev.petuska.kmdc.core.applyContent
import dev.petuska.kmdc.core.role
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.I
import org.w3c.dom.HTMLElement

@Composable
@KMDCInternalAPI
internal fun MDCTextFieldScope.MDCTextFieldIcon(
  leading: Boolean,
  clickable: Boolean = false,
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: ContentBuilder<HTMLElement>? = null,
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
      MDCInitEffect(MDCTextFieldIconModule::MDCTextFieldIcon)
      applyContent(content)
    }
  )
}

@MDCDsl
@Composable
public fun MDCTextFieldScope.MDCTextFieldLeadingIcon(
  clickable: Boolean = false,
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: ContentBuilder<HTMLElement>? = null,
) {
  MDCTextFieldIcon(
    leading = true,
    clickable = clickable,
    attrs = attrs,
    content = content,
  )
}

@MDCDsl
@Composable
public fun MDCTextFieldScope.MDCTextFieldTrailingIcon(
  clickable: Boolean = false,
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: ContentBuilder<HTMLElement>? = null,
) {
  MDCTextFieldIcon(
    leading = false,
    clickable = clickable,
    attrs = attrs,
    content = content,
  )
}
