package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.list.*
import dev.petuska.kmdc.list.item.*
import sandbox.control.BooleanControl
import sandbox.control.ChoiceControl
import sandbox.util.NamedGroup

private class MDCListVM {
  var type by mutableStateOf(MDCListType.Default)
  var size by mutableStateOf(MDCListSize.SingleLine)
  var selection by mutableStateOf(MDCListSelection.Single)
  var dense by mutableStateOf(false)
  var wrapFocus by mutableStateOf(false)

  var divider by mutableStateOf(false)
  var inset by mutableStateOf(MDCListDividerInset.None)

  val items = listOf("Java", "Kotlin", "Scala", "Groovy", "JavaScript", "TypeScript")
}

@Composable
@Showcase(id = "MDCList")
fun MDCList() = InteractiveShowcase(
  viewModel = { MDCListVM() },
  controls = {
    ChoiceControl("Type", MDCListType.values().associateBy(MDCListType::name), ::type)
    ChoiceControl("Size", MDCListSize.values().associateBy(MDCListSize::name), ::size)
    ChoiceControl("Selection", MDCListSelection.values().associateBy(MDCListSelection::name), ::selection)
    BooleanControl("Dense", ::dense)
    BooleanControl("Wrap Focus", ::wrapFocus)
    NamedGroup("Divider") {
      BooleanControl("Enabled", ::divider)
      ChoiceControl("Inset", MDCListDividerInset.values().associateBy(MDCListDividerInset::name), ::inset)
    }
  },
) {
  MDCList(
    type = type,
    size = size,
    selection = selection,
    attrs = {
      registerEvents()
    }
  ) {
    items.chunked(2).forEachIndexed { i, group ->
      MDCListGroup {
        Subheader("Group $i")
        MDCList(
          type = type,
          size = size,
          selection = selection,
          dense = dense,
          wrapFocus = wrapFocus,
        ) {
          group.forEachIndexed { j, item ->
            ListItem {
              val id = "kmdc-list-item-${i * 2 + j}"
              when (selection) {
                MDCListSelection.SingleRadio -> RadioGraphic(false, id)
                MDCListSelection.MultiCheckbox -> CheckboxGraphic(false, id)
                else -> {}
              }
              if (size == MDCListSize.TwoLine) {
                Label(forId = id) {
                  Primary(item)
                  Secondary("$item description")
                }
              } else {
                Label(text = item, forId = id)
              }
            }
            if (divider && j == 0) Divider(inset = inset)
          }
        }
        if (divider && i % 2 == 0) Divider(inset = inset)
      }
    }
  }
}

private fun MDCListAttrsScope<*>.registerEvents() {
  onAction { console.log("MDCList#onAction", it.detail) }
  onSelectionChanged { console.log("MDCList#onSelectionChanged", it.detail) }
}
