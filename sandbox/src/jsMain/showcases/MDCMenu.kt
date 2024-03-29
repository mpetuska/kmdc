package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.core.KMDCInternalAPI
import dev.petuska.kmdc.core.domain.Point
import dev.petuska.kmdc.core.rememberMutableStateOf
import dev.petuska.kmdc.list.item.CheckboxGraphic
import dev.petuska.kmdc.list.item.Label
import dev.petuska.kmdc.list.item.Text
import dev.petuska.kmdc.menu.*
import dev.petuska.kmdc.menu.surface.*
import dev.petuska.kmdc.textfield.MDCTextField
import dev.petuska.kmdc.textfield.MDCTextFieldType
import dev.petuska.kmdc.textfield.icon.MDCTextFieldTrailingIcon
import dev.petuska.kmdcx.icons.MDCIcon
import dev.petuska.kmdcx.icons.mdcIcon
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanControl
import sandbox.control.ChoiceControl
import sandbox.util.NamedBlock
import sandbox.util.NamedGroup

private class MDCMenuVM {
  var anchorCorner by mutableStateOf(Corner.BOTTOM_START)
  var defaultFocusState by mutableStateOf(DefaultFocusState.NONE)
  var disabled by mutableStateOf(false)
  var fullWidth by mutableStateOf(true)
  var fixed by mutableStateOf(false)
  var quickOpen by mutableStateOf(false)
  var hoisted by mutableStateOf(false)
  var wrapFocus by mutableStateOf(false)

  var open by mutableStateOf(false)
  var selectedIds = mutableStateListOf<Int>()

  var selectedId by mutableStateOf<Int?>(null)

  val menuItems = listOf("Java", "Kotlin", "Scala", "Groovy", "JavaScript", "TypeScript")
}

@Composable
@Showcase(id = "MDCMenu")
fun MDCMenu() = InteractiveShowcase(
  viewModel = { MDCMenuVM() },
  controls = {
    ChoiceControl(
      title = "Anchor Corner",
      options = mapOf(
        "TOP_LEFT" to Corner.TOP_LEFT,
        "TOP_RIGHT" to Corner.TOP_RIGHT,
        "BOTTOM_LEFT" to Corner.BOTTOM_LEFT,
        "BOTTOM_RIGHT" to Corner.BOTTOM_RIGHT,
        "TOP_START" to Corner.TOP_START,
        "TOP_END" to Corner.TOP_END,
        "BOTTOM_START" to Corner.BOTTOM_START,
        "BOTTOM_END" to Corner.BOTTOM_END,
      ),
      selected = ::anchorCorner
    )
    ChoiceControl(
      title = "Default Focus State",
      options = mapOf(
        "NONE" to DefaultFocusState.NONE,
        "LIST_ROOT" to DefaultFocusState.LIST_ROOT,
        "FIRST_ITEM" to DefaultFocusState.FIRST_ITEM,
        "LAST_ITEM" to DefaultFocusState.LAST_ITEM,
      ),
      selected = ::defaultFocusState
    )
    BooleanControl("Disabled", ::disabled)
    BooleanControl("Full Width", ::fullWidth)
    BooleanControl("Fixed", ::fixed)
    BooleanControl("Quick Open", ::quickOpen)
    BooleanControl("Hoisted", ::hoisted)
    BooleanControl("Wrap Focus", ::wrapFocus)
    NamedGroup("Absolute") {
      BooleanControl("Open", ::open)
    }
  },
) {
  NamedBlock("Absolute | multi-select") {
    MDCMenu(
      open = open,
      selectedIds = selectedIds,
      fullWidth = fullWidth,
      fixed = fixed,
      anchorCorner = anchorCorner,
      quickOpen = quickOpen,
      hoisted = hoisted,
      wrapFocus = wrapFocus,
      defaultFocusState = defaultFocusState,
      absolutePosition = Point(0.0, 0.0),
      attrs = {
        registerEvents()
        onClosed { open = false }
        onSelected {
          val id = it.detail.index
          if (id in selectedIds) selectedIds.remove(id) else selectedIds.add(id)
        }
      }
    ) {
      menuItems.chunked(2).forEachIndexed { i1, items ->
        SelectionGroup {
          items.forEachIndexed { i2, text ->
            MenuItem(
              disabled = disabled,
            ) {
              val id = "mdc-menu-item-${i1 * 2 + i2}"
              CheckboxGraphic(checked = i1 * 2 + i2 in selectedIds, id = id)
              Label(text = text, forId = id)
            }
          }
        }
      }
    }
  }
  @OptIn(KMDCInternalAPI::class)
  NamedBlock("Anchored | single-select") {
    var open by rememberMutableStateOf(false)
    var input by rememberMutableStateOf("")
    MDCMenuSurfaceAnchor(attrs = {
      style {
        property("width", "fit-content")
      }
    }) {
      MDCTextField(
        value = input,
        label = "Favourite Language",
        type = MDCTextFieldType.Outlined,
        attrs = {
          onFocus { open = true }
          onClick { open = true }
          onInput {
            input = it.value
            open = true
          }
          onChange { e ->
            val candidate = menuItems.firstOrNull { it.equals(e.value, true) }
              ?: menuItems.filter { it.contains(e.value, true) }.takeIf { it.size == 1 }?.first()
            selectedId = candidate?.let(menuItems::indexOf) ?: selectedId
            input = selectedId?.let(menuItems::get) ?: ""
            e.target.blur()
            open = false
          }
        },
        trailingIcon = {
          MDCTextFieldTrailingIcon(clickable = true, attrs = {
            onClick { open = !open }
            mdcIcon()
          }) {
            Text(
              if (open) {
                MDCIcon.ArrowDropUp.type
              } else {
                MDCIcon.ArrowDropDown.type
              }
            )
          }
        }
      )
      MDCMenu(
        open = open,
        selectedId = selectedId,
        fullWidth = fullWidth,
        fixed = fixed,
        anchorCorner = anchorCorner,
        quickOpen = quickOpen,
        hoisted = hoisted,
        wrapFocus = wrapFocus,
        defaultFocusState = defaultFocusState,
        attrs = {
          registerEvents()
          onSelected {
            selectedId = it.detail.index
            input = menuItems[it.detail.index]
            open = false
          }
          onClosed { open = false }
        }
      ) {
        menuItems.forEach {
          MenuItem(
            disabled = disabled,
            activated = input.isNotBlank() && it.contains(input, ignoreCase = true)
          ) {
            Text(it)
          }
        }
      }
    }
  }
}

private fun MDCMenuAttrsScope.registerEvents() {
  onSelected { console.log("MDCMenu#onSelected", it.detail) }
  onOpened { console.log("MDCMenu#onOpened", it.detail) }
  onClosing { console.log("MDCMenu#onClosing", it.detail) }
  onClosed { console.log("MDCMenu#onClosed", it.detail) }
}
