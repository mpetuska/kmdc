package dev.petuska.kmdc.select

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

@JsModule("@material/select/mdc-select.scss")
private external val Style: dynamic

public enum class MDCSelectType(public vararg val classes: String) {
  Filled("mdc-select--filled"),
  Outlined("mdc-select--outlined")
}

public enum class MDCSelectHelperTextType(public vararg val classes: String) {
  Default,
  Validation("mdc-select-helper-text--validation-msg"),
  PersistentValidation("mdc-select-helper-text--validation-msg", "mdc-select-helper-text--validation-msg-persistent")
}

public interface MDCSelectScope : ElementScope<HTMLDivElement>
public interface MDCSelectAttrsScope : AttrsScope<HTMLDivElement>

internal val MDCSelectTypeLocal = strictCompositionLocalOf<MDCSelectType>()
internal val MDCSelectHelperTextIdLocal = strictCompositionLocalOf<String?>()
internal val MDCSelectLeadingIconLocal = strictCompositionLocalOf<Boolean>()

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-select)
 */
@MDCContentDsl
@Composable
public fun MDCSelect(
  type: MDCSelectType = MDCSelectType.Filled,
  required: Boolean = false,
  disabled: Boolean = false,
  helperText: String? = null,
  helperTextType: MDCSelectHelperTextType = MDCSelectHelperTextType.Default,
  withLeadingIcon: Boolean = false,
  attrs: MDCAttrs<MDCSelectAttrsScope>? = null,
  content: MDCContent<MDCSelectScope>? = null,
) {
  Style
  val helperTextId = rememberUniqueDomElementId("helper")
  Div(
    attrs = {
      classes("mdc-select")
      classes(type.classes)
      if (required) classes("mdc-select--required")
      if (disabled) classes("mdc-select--disabled")
      if (withLeadingIcon) classes("mdc-select--with-leading-icon")
      applyAttrs(attrs)
    }
  ) {
    CompositionLocalProvider(
      MDCSelectTypeLocal provides type,
      MDCSelectHelperTextIdLocal provides helperTextId.takeIf { helperText != null },
      MDCSelectLeadingIconLocal provides withLeadingIcon,
    ) {
      MDCProvider(::MDCSelect, type) {
        MDCStateEffectNew(required, MDCSelect::required)
        MDCStateEffectNew(disabled, MDCSelect::disabled)
        applyContent(content)
      }
    }
  }
  if (helperText != null) {
    P(attrs = {
      id(helperTextId)
      classes("mdc-select-helper-text")
      classes(helperTextType.classes)
    }) {
      MDCProvider(::MDCSelectHelperText) {
        Text(helperText)
      }
    }
  }
}
