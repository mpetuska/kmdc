package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.core.KMDCInternalAPI
import dev.petuska.kmdc.core.domain.Point
import dev.petuska.kmdc.core.rememberMutableStateOf
import dev.petuska.kmdc.list.item.CheckboxGraphic
import dev.petuska.kmdc.list.item.Text
import dev.petuska.kmdc.menu.DefaultFocusState
import dev.petuska.kmdc.menu.MDCMenu
import dev.petuska.kmdc.menu.MDCMenuAttrsScope
import dev.petuska.kmdc.menu.MenuItem
import dev.petuska.kmdc.menu.SelectionGroup
import dev.petuska.kmdc.menu.onSelected
import dev.petuska.kmdc.menu.surface.Corner
import dev.petuska.kmdc.menu.surface.MDCMenuSurfaceAnchor
import dev.petuska.kmdc.menu.surface.onClosed
import dev.petuska.kmdc.menu.surface.onClosing
import dev.petuska.kmdc.menu.surface.onOpened
import dev.petuska.kmdc.textfield.MDCTextField
import dev.petuska.kmdc.textfield.MDCTextFieldTrailingIcon
import dev.petuska.kmdc.textfield.MDCTextFieldType
import dev.petuska.kmdcx.icons.MDCIconOpts
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanControl
import sandbox.control.ChoiceControl
import sandbox.control.NamedBlock
import sandbox.control.NamedGroup

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
          items.forEachIndexed { i2, it ->
            MenuItem(
              disabled = disabled,
            ) {
              CheckboxGraphic(i1 * 2 + i2 in selectedIds)
              Text(it)
            }
          }
        }
      }
    }
  }
  NamedBlock("Anchored | single-select") {
    @OptIn(KMDCInternalAPI::class)
    var open by rememberMutableStateOf(false)
    MDCMenuSurfaceAnchor(attrs = {
      style {
        property("width", "fit-content")
      }
    }) {
      MDCTextField(
        value = selectedId?.let(menuItems::get) ?: "",
        label = "Favourite Language",
        type = MDCTextFieldType.Outlined,
        attrs = {
          onClick {
            open = true
          }
        },
        trailingIcon = {
          MDCTextFieldTrailingIcon(clickable = true, attrs = {
            onClick { open = !open }
            classes("material-icons")
          }) {
            Text(if (open) MDCIconOpts.MDCIconType.ArrowDropUp.iconType else MDCIconOpts.MDCIconType.ArrowDropDown.iconType)
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
            open = false
          }
          onClosed { open = false }
        }) {
        menuItems.forEach { it ->
          MenuItem(
            disabled = disabled,
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
