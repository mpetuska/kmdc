package dev.petuska.kmdc.select

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.initialiseMDC
import dev.petuska.kmdc.core.mdc
import dev.petuska.kmdc.core.role
import dev.petuska.kmdc.core.uniqueDomElementId
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
  var onChange: ((value: T) -> Unit)? = null,
  var label: String? = null,
  var required: Boolean = false,
  var disabled: Boolean = false,
  var hiddenInputName: String? = null,
  var helperText: MDCSelectHelperText? = null
) {
  public enum class Type(public val klass: String) {
    Outlined("mdc-select--outlined"),
    Filled("mdc-select--filled")
  }

  public fun <S> copyFrom(source: MDCSelectOpts<S>, map: S.() -> T, unmap: T.() -> S) {
    type = source.type
    value = source.value?.map()
    onChange = source.onChange?.let { listener -> { listener(it.unmap()) } }
    label = source.label
    required = source.required
    disabled = source.disabled
    hiddenInputName = source.hiddenInputName
    helperText = source.helperText
  }
}

public data class MDCSelectHelperText(
  val text: String,
  val type: Type
) {
  public enum class Type(public vararg val classes: String) {
    Default("mdc-select-helper-text"),
    Validation(*(Default.classes + "mdc-select-helper-text--validation-msg")),
    PersistentValidation(*(Validation.classes + "mdc-select-helper-text--validation-msg-persistent"))
  }
}

public class MDCSelectLeadingIconScope

public interface MDCSelectItem {
  public val value: String
  public val disabled: Boolean get() = false
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-select)
 */
@MDCDsl
@Composable
public fun <T : MDCSelectItem> MDCSelect(
  items: List<T>,
  opts: Builder<MDCSelectOpts<T>>? = null,
  attrs: Builder<AttrsBuilder<HTMLDivElement>>? = null,
  leadingIcon: ComposableBuilder<MDCSelectLeadingIconScope>? = null,
  renderItem: @Composable ElementScope<HTMLSpanElement>.(T) -> Unit
) {
  MDCSelectCSS
  val labelId = remember { uniqueDomElementId() }
  val selectedTextId = remember { uniqueDomElementId() }
  val helperTextId = remember { uniqueDomElementId() }
  val options = MDCSelectOpts<T>().apply { opts?.invoke(this) }

  Div(
    attrs = {
      with(options) {
        classes("mdc-select", type.klass)
        if (label == null) classes("mdc-select--no-label")
        if (required) classes("mdc-select--required")
        if (disabled) classes("mdc-select--disabled")
        if (required && value?.value.isNullOrBlank()) classes("mdc-select--invalid")
        if (leadingIcon != null) classes("mdc-select--with-leading-icon")
        if (helperText != null) {
          aria("controls", helperTextId)
          aria("describedby", helperTextId)
        }
      }
      initialiseMDC(MDCSelectModule.MDCSelect::attachTo)
      options.onChange?.let { listener ->
        addEventListener(MDCSelectModule.strings.CHANGE_EVENT) {
          val event = it.nativeEvent.unsafeCast<MDCSelectModule.MDCSelectChangeEvent>()
          listener(items[event.detail.index])
        }
      }
      attrs?.invoke(this)
    }
  ) {

    DomSideEffect(options.required) {
      it.mdc<MDCSelectModule.MDCSelect> { required = options.required }
    }
    DomSideEffect(options.disabled) {
      it.mdc<MDCSelectModule.MDCSelect> { disabled = options.disabled }
    }
    DomSideEffect(options.value) {
      it.mdc<MDCSelectModule.MDCSelect> { value = options.value?.value }
    }

    options.hiddenInputName?.let {
      HiddenInput { name(it) }
    }

    MDCSelectAnchor(labelId, options, leadingIcon, selectedTextId, items, renderItem)

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
              this.disabled = item.disabled
            },
            attrs = {
              attr("data-value", item.value)
              aria("selected", (item == options.value).toString())
              if (item.disabled) aria("disabled", "true")
              role("option")
            }
          ) {
            if (leadingIcon != null) {
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
    MDCSelectHelperText(helperTextId, helperText)
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-select)
 */
@MDCDsl
@Composable
public fun <T> MDCSelect(
  items: List<T>,
  opts: Builder<MDCSelectOpts<T>>? = null,
  attrs: Builder<AttrsBuilder<HTMLDivElement>>? = null,
  leadingIcon: ComposableBuilder<MDCSelectLeadingIconScope>? = null,
  renderItem: @Composable ElementScope<HTMLSpanElement>.(T) -> Unit
) {
  val selectItems = items.map { Item(it) }
  val selectOpts: Builder<MDCSelectOpts<Item<T>>>? = opts?.let {
    MDCSelectOpts<T>().apply(it).let { options ->
      {
        this.copyFrom(options, map = { Item(this) }, unmap = { original })
      }
    }
  }
  MDCSelect(selectItems, selectOpts, attrs, leadingIcon) {
    renderItem(it.original)
  }
}

private class Item<T>(val original: T) : MDCSelectItem {
  override val value = original.toString()
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-select)
 */
@MDCDsl
@Composable
public fun MDCSelect(
  items: List<String>,
  opts: Builder<MDCSelectOpts<String>>? = null,
  attrs: Builder<AttrsBuilder<HTMLDivElement>>? = null,
  leadingIcon: ComposableBuilder<MDCSelectLeadingIconScope>? = null
) {
  MDCSelect(items, opts, attrs, leadingIcon) {
    Text(it)
  }
}
