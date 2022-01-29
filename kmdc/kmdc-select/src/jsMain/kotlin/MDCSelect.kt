import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.aria
import dev.petuska.kmdc.core.mdc
import dev.petuska.kmdc.core.role
import dev.petuska.kmdc.core.uniqueDomElementId
import dev.petuska.kmdc.list.MDCList
import dev.petuska.kmdc.list.MDCListItem
import dev.petuska.kmdc.list.MDCListItemGraphic
import dev.petuska.kmdc.list.MDCListItemText
import dev.petuska.kmdc.menu.surface.MDCMenuSurface
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.attributes.name
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.HiddenInput
import org.jetbrains.compose.web.dom.I
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.svg.Polygon
import org.jetbrains.compose.web.svg.Svg
import org.w3c.dom.Element
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement

@JsModule("@material/select/dist/mdc.select.css")
private external val MDCSelectCSS: dynamic

@JsModule("@material/select")
public external object MDCSelectModule {
  internal class MDCSelect(element: Element) {
    companion object {
      fun attachTo(element: Element): MDCSelect
    }

    fun destroy()

    var value: String?

    fun setValue(value: String?, skipNotify: Boolean)

    var disabled: Boolean

    var required: Boolean
  }

  public class MDCSelectChangeEventDetail {
    public val value: String
    public val index: Int
  }

  public class MDCSelectChangeEvent : MDCEvent<MDCSelectChangeEventDetail>
}

@JsModule("@material/select/constants")
internal external object MDCSelectConstants {

  @Suppress("ClassName")
  object strings {
    val CHANGE_EVENT: String
  }
}

@JsModule("@material/select/helper-text")
internal external object MDCSelectHelperTextModule {
  class MDCSelectHelperText(element: Element) {
    companion object {
      fun attachTo(element: Element): MDCSelectHelperText
    }

    fun destroy()
  }
}

public class MDCSelectAttrsScope private constructor() : AttrsBuilder<HTMLDivElement>()

public data class MDCSelectOpts(
  var type: Type = Type.Filled,
  var label: String? = null,
  var required: Boolean = false,
  var disabled: Boolean = false,
  var hiddenInputName: String? = null,
  var helperText: MDCSelectHelperText? = null
) {
  public enum class Type(public vararg val classes: String) {
    Outlined("mdc-select--outlined"),
    Filled("mdc-select--filled")
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

public data class MDCSelectItem(val value: String, val text: String, val disabled: Boolean = false)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-select)
 */
@MDCDsl
@Composable
public fun MDCSelect(
  items: List<MDCSelectItem>,
  selectedValue: String = "",
  opts: Builder<MDCSelectOpts>? = null,
  attrs: Builder<MDCSelectAttrsScope>? = null,
  leadingIcon: ComposableBuilder<MDCSelectLeadingIconScope>? = null,
) {
  MDCSelectCSS
  val labelId = remember { uniqueDomElementId() }
  val selectedTextId = remember { uniqueDomElementId() }
  val helperTextId = remember { uniqueDomElementId() }
  val options = MDCSelectOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-select", *options.type.classes)
      if (options.label == null) classes("mdc-select--no-label")
      if (options.required) classes("mdc-select--required")
      if (options.disabled) classes("mdc-select--disabled")
      if (options.required && selectedValue.isBlank()) classes("mdc-select--invalid")
      if (leadingIcon != null) classes("mdc-select--with-leading-icon")
      if (options.helperText != null) {
        aria("controls", helperTextId)
        aria("describedby", helperTextId)
      }
      ref {
        it.mdc = MDCSelectModule.MDCSelect.attachTo(it)
        onDispose {
          it.mdc<MDCSelectModule.MDCSelect> { destroy() }
        }
      }
      attrs?.invoke(this.unsafeCast<MDCSelectAttrsScope>())
    }
  ) {

    DomSideEffect(options.required) {
      it.mdc<MDCSelectModule.MDCSelect> { required = options.required }
    }
    DomSideEffect(options.disabled) {
      it.mdc<MDCSelectModule.MDCSelect> { disabled = options.disabled }
    }
    DomSideEffect(selectedValue) {
      it.mdc<MDCSelectModule.MDCSelect> { value = selectedValue }
    }

    options.hiddenInputName?.let {
      HiddenInput { name(it) }
    }

    Div(
      attrs = {
        classes("mdc-select__anchor")
        role("button")
        aria("haspopup", "listbox")
        aria("expanded", "false")
        aria("labelledby", labelId)
      }
    ) {

      // floating label
      when (options.type) {
        MDCSelectOpts.Type.Filled -> {
          Span(attrs = { classes("mdc-select__ripple") })
          options.label?.let {
            mdcSelectLabel(labelId, it)
          }
        }
        MDCSelectOpts.Type.Outlined -> {
          Span(
            attrs = { classes("mdc-notched-outline") }
          ) {
            Span(attrs = { classes("mdc-notched-outline__leading") })
            options.label?.let {
              Span(attrs = { classes("mdc-notched-outline__notch") }) {
                mdcSelectLabel(labelId, it)
              }
            }
            Span(attrs = { classes("mdc-notched-outline__trailing") })
          }
        }
      }

      // leading icon
      leadingIcon?.invoke(MDCSelectLeadingIconScope())

      // selected text
      Span(
        attrs = {
          classes("mdc-select__selected-text-container")
        }
      ) {
        Span(
          attrs = {
            classes("mdc-select__selected-text")
            id(selectedTextId)
          }
        ) {
          items.firstOrNull { it.value == selectedValue }?.let {
            Text(it.text)
          }
        }
      }

      // down arrow icon
      mdcSelectDropdownIcon()

      Span(attrs = { classes("mdc-line-ripple") })
    }

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
              this.selected = item.value == selectedValue
              this.disabled = item.disabled
            },
            attrs = {
              attr("data-value", item.value)
              aria("selected", (item.value == selectedValue).toString())
              if (item.disabled) aria("disabled", "true")
              role("option")
            }
          ) {
            if (leadingIcon != null) {
              MDCListItemGraphic()
            }
            MDCListItemText(item.text)
          }
        }
      }
    }
  }
  options.helperText?.let { helperText ->
    P(
      attrs = {
        id(helperTextId)
        classes(*helperText.type.classes)
        ref {
          it.mdc = MDCSelectHelperTextModule.MDCSelectHelperText.attachTo(it)
          onDispose {
            it.mdc<MDCSelectHelperTextModule.MDCSelectHelperText> { destroy() }
          }
        }
      }
    ) {
      Text(helperText.text)
    }
  }
}

@OptIn(ExperimentalComposeWebSvgApi::class)
@Composable
private fun mdcSelectDropdownIcon() {
  Span(
    attrs = { classes("mdc-select__dropdown-icon") }
  ) {
    Svg(
      viewBox = "7 10 10 5",
      attrs = {
        attr("focusable", "false")
        classes("mdc-select__dropdown-icon-graphic")
      }
    ) {
      Polygon(
        7, 10, 12, 15, 17, 10,
        attrs = {
          classes("mdc-select__dropdown-icon-inactive")
          attr("stroke", "none")
          attr("fill-rule", "evenodd")
        }
      )
      Polygon(
        7, 15, 12, 10, 17, 15,
        attrs = {
          classes("mdc-select__dropdown-icon-active")
          attr("stroke", "none")
          attr("fill-rule", "evenodd")
        }
      )
    }
  }
}

@Composable
private fun mdcSelectLabel(id: String, label: String) {
  Span(
    attrs = {
      classes("mdc-floating-label", "mdc-floating-label--float-above")
      id(id)
    }
  ) {
    Text(label)
  }
}

@MDCAttrsDsl
public fun AttrsBuilder<HTMLElement>.mdcSelectIcon(clickable: Boolean) {
  classes("mdc-select__icon")
  if (clickable) {
    tabIndex(0)
    role("button")
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-select)
 */
@Suppress("unused")
@MDCDsl
@Composable
public fun MDCSelectLeadingIconScope.MDCSelectLeadingIcon(
  clickable: Boolean = true,
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: ContentBuilder<HTMLElement>? = null,
) {
  I(
    attrs = {
      mdcSelectIcon(clickable)
      attrs?.invoke(this)
    },
    content = content
  )
}
