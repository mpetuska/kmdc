package dev.petuska.kmdc.select

import androidx.compose.runtime.*
import dev.petuska.kmdc.core.*
import dev.petuska.kmdc.list.*
import dev.petuska.kmdc.list.item.*
import dev.petuska.kmdc.menu.surface.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

@JsModule("@material/select/dist/mdc.select.css")
private external val MDCSelectCSS: dynamic

public data class MDCSelectOpts<T>(
  var type: Type = Type.Filled,
  var value: T? = null,
  var itemValue: T.() -> String = { toString() },
  var itemDisabled: T.() -> Boolean = { false },
  var label: String? = null,
  var required: Boolean = false,
  var disabled: Boolean = false,
  var hiddenInputName: String? = null,
  var helperText: String? = null,
  var helperTextType: HelperTextType = HelperTextType.Default,
  var leadingIcon: String? = null,
  var leadingIconClickable: Boolean = false,
  var leadingIconClasses: List<String> = listOf("material-icons")
) {
  public enum class Type(public val klass: String) {
    Outlined("mdc-select--outlined"),
    Filled("mdc-select--filled")
  }

  public enum class HelperTextType(public vararg val classes: String) {
    Default,
    Validation("mdc-select-helper-text--validation-msg"),
    PersistentValidation("mdc-select-helper-text--validation-msg", "mdc-select-helper-text--validation-msg-persistent")
  }
}

public class MDCSelectAttrsScope<T>(scope: AttrsScope<HTMLDivElement>) : AttrsScope<HTMLDivElement> by scope

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-select)
 */
@MDCDsl
@Composable
public fun <T> MDCSelect(
  items: List<T>,
  opts: MDCAttrs<MDCSelectOpts<T>>? = null,
  attrs: MDCAttrs<MDCSelectAttrsScope<T>>? = null,
  renderItem: @Composable ElementScope<HTMLSpanElement>.(T) -> Unit = { Text(it.toString()) }
) {
  MDCSelectCSS
  val labelId = rememberUniqueDomElementId()
  val selectedTextId = rememberUniqueDomElementId()
  val helperTextId = rememberUniqueDomElementId()
  val options = MDCSelectOpts<T>().apply { opts?.invoke(this) }
  val hasLeadingIcon = options.leadingIcon != null

  fun T.itemValue() = with(options) { itemValue() }
  fun T.itemDisabled() = with(options) { itemDisabled() }

  Div(
    attrs = {
      with(options) {
        classes("mdc-select", type.klass)
        if (label == null) classes("mdc-select--no-label")
        if (required) classes("mdc-select--required")
        if (disabled) classes("mdc-select--disabled")
        if (required && value?.itemValue().isNullOrBlank()) classes("mdc-select--invalid")
        if (hasLeadingIcon) classes("mdc-select--with-leading-icon")
        if (helperText != null) {
          aria("controls", helperTextId)
          aria("describedby", helperTextId)
        }
      }
      attrs?.invoke(MDCSelectAttrsScope(this))
    }
  ) {
    DisposableEffect(items) {
      scopeElement.asDynamic().mdc = MDCSelectModule.MDCSelect.attachTo<T>(scopeElement)
      scopeElement.mdc<MDCSelectModule.MDCSelect<T>> {
        this.items = items
        required = options.required
        disabled = options.disabled
      }
      onDispose {
        scopeElement.mdc<MDCSelectModule.MDCSelect<T>> { destroy() }
      }
    }
    MDCStateEffect(options.required, MDCSelectModule.MDCSelect<T>::required)
    MDCStateEffect(options.disabled, MDCSelectModule.MDCSelect<T>::disabled)
    MDCSideEffect<MDCSelectModule.MDCSelect<T>>(options.value) {
      value = options.value?.itemValue()
    }

    options.hiddenInputName?.let {
      HiddenInput { name(it) }
    }

    MDCSelectAnchor(labelId, options, selectedTextId, items, renderItem)

    MDCMenuSurface(
      fullWidth = true,
      attrs = {
        classes("mdc-select__menu", "mdc-menu")
      }
    ) {
      MDCList(
        attrs = {
          options.label?.let { aria("label", it) }
        }
      ) {
        items.forEach { item ->
          ListItem(
            selected = item == options.value,
            disabled = item.itemDisabled(),
            attrs = {
              attr("data-value", item.itemValue())
              aria("selected", (item == options.value).toString())
              if (item.itemDisabled()) aria("disabled", "true")
              role("option")
            }
          ) {
            if (hasLeadingIcon) {
              Graphic()
            }
            Text {
              renderItem(item)
            }
          }
        }
      }
    }
  }
  options.helperText?.let { helperText ->
    MDCSelectHelperText(helperTextId, helperText, options.helperTextType)
  }
}
