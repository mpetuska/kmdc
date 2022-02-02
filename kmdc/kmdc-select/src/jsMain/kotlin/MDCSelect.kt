package dev.petuska.kmdc.select

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.initialiseMDC
import dev.petuska.kmdc.core.mdc
import dev.petuska.kmdc.core.rememberUniqueDomElementId
import dev.petuska.kmdc.core.role
import dev.petuska.kmdc.list.MDCList
import dev.petuska.kmdc.list.MDCListItem
import dev.petuska.kmdc.list.MDCListItemGraphic
import dev.petuska.kmdc.list.MDCListItemText
import dev.petuska.kmdc.menu.surface.MDCMenuSurface
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.attributes.name
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.HiddenInput
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLSpanElement

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

public class MDCSelectAttrsScope<T> private constructor() : AttrsBuilder<HTMLDivElement>()

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-select)
 */
@MDCDsl
@Composable
public fun <T> MDCSelect(
  items: List<T>,
  opts: Builder<MDCSelectOpts<T>>? = null,
  attrs: Builder<MDCSelectAttrsScope<T>>? = null,
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
      initialiseMDC(
        mdcInit = { MDCSelectModule.MDCSelect.attachTo<T>(it) },
        postInit = { _, mdc -> mdc.items = items }
      )
      attrs?.invoke(this.unsafeCast<MDCSelectAttrsScope<T>>())
    }
  ) {

    DomSideEffect(options.required) {
      it.mdc<MDCSelectModule.MDCSelect<T>> { required = options.required }
    }
    DomSideEffect(options.disabled) {
      it.mdc<MDCSelectModule.MDCSelect<T>> { disabled = options.disabled }
    }
    DomSideEffect(options.value) {
      it.mdc<MDCSelectModule.MDCSelect<T>> { value = options.value?.itemValue() }
    }

    options.hiddenInputName?.let {
      HiddenInput { name(it) }
    }

    MDCSelectAnchor(labelId, options, selectedTextId, items, renderItem)

    MDCMenuSurface(
      opts = { fullwidth = true },
      attrs = {
        classes("mdc-select__menu", "mdc-menu")
      }
    ) {
      MDCList(
        opts = { singleSelection = true },
        attrs = {
          options.label?.let { aria("label", it) }
        }
      ) {
        items.forEach { item ->
          MDCListItem(
            opts = {
              this.selected = item == options.value
              this.disabled = item.itemDisabled()
            },
            attrs = {
              attr("data-value", item.itemValue())
              aria("selected", (item == options.value).toString())
              if (item.itemDisabled()) aria("disabled", "true")
              role("option")
            }
          ) {
            if (hasLeadingIcon) {
              MDCListItemGraphic()
            }
            MDCListItemText {
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
