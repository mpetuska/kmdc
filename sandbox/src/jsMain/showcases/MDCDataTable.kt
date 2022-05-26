package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.core.KMDCInternalAPI
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.core.rememberUniqueDomElementId
import dev.petuska.kmdc.data.table.*
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanControl
import sandbox.util.NamedBlock

private class MDCDataTableVM {
  var loading by mutableStateOf(false)

  val items = mutableStateListOf(
    Item("Frozen yogurt", "24", "4.0", "Super tasty"),
    Item("Ice cream sandwich", "37", "4.33333333333", "I like ice cream more"),
    Item("Eclair", "24", "6.0", "New filing flavor"),
  )

  data class Item(
    val dessert: String,
    val carbs: String,
    val proteins: String,
    val comments: String,
    val selected: Boolean = false,
  )
}

@Composable
@Showcase(id = "MDCDataTable")
fun MDCDataTable() = InteractiveShowcase(
  viewModel = { MDCDataTableVM() },
  controls = {
    BooleanControl("Loading", ::loading)
  },
) {
  NamedBlock("Simple") {
    MDCDataTable(
      loading = loading,
      attrs = {
        registerEvents()
      }
    ) {
      Container {
        MDCDataTableHeader {
          Cell(text = "Dessert")
          Cell(text = "Carbs (g)", numeric = true)
          Cell(text = "Protein (g)", numeric = true)
          Cell(text = "Comments")
        }
        Body {
          Row {
            HeaderCell(text = "Frozen yogurt")
            Cell(text = "24", numeric = true)
            Cell(text = "4.0", numeric = true)
            Cell(text = "Super tasty")
          }
          Row {
            HeaderCell(text = "Ice cream sandwich")
            Cell(text = "37", numeric = true)
            Cell(text = "4.33333333333", numeric = true)
            Cell(text = "I like ice cream more")
          }
          Row {
            HeaderCell(text = "Eclair")
            Cell(text = "24", numeric = true)
            Cell(text = "6.0", numeric = true)
            Cell(text = "New filing flavor")
          }
        }
      }
    }
  }
  NamedBlock("Interactive") {
    MDCDataTable(
      loading = loading,
      attrs = {
        registerEvents()
        onSelectedAll {
          for (i in items.indices) {
            items[i] = items[i].copy(selected = true)
          }
        }
        onUnselectedAll {
          for (i in items.indices) {
            items[i] = items[i].copy(selected = false)
          }
        }
        onRowSelectionChanged {
          it.detail.let { d ->
            items[d.rowIndex] = items[d.rowIndex].copy(selected = d.selected == true)
          }
        }
        onSorted {
          val sortProp = when (val index = it.detail.columnIndex) {
            1 -> MDCDataTableVM.Item::dessert
            2 -> MDCDataTableVM.Item::carbs
            3 -> MDCDataTableVM.Item::proteins
            4 -> MDCDataTableVM.Item::comments
            else -> error("Unknown column sort index: $index")
          }
          @OptIn(MDCExternalAPI::class)
          if (it.detail.sortValue == SortValue.ASCENDING) {
            items.sortBy(sortProp)
          } else if (it.detail.sortValue == SortValue.DESCENDING) {
            items.sortByDescending(sortProp)
          }
        }
      }
    ) {
      Container {
        @OptIn(KMDCInternalAPI::class)
        val id = rememberUniqueDomElementId()
        MDCDataTableHeader {
          MDCDataTableCheckCell(selected = items.all(MDCDataTableVM.Item::selected), label = "Toggle All")
          MDCDataTableSortCell(columnId = "$id-0", label = "Dessert", buttonAttrs = {
            classes("material-icons")
          }) { Text("arrow_upward") }
          MDCDataTableSortCell(columnId = "$id-1", label = "Carbs (g)", numeric = true, buttonAttrs = {
            classes("material-icons")
          }) { Text("arrow_upward") }
          MDCDataTableSortCell(columnId = "$id-2", label = "Protein (g)", numeric = true, buttonAttrs = {
            classes("material-icons")
          }) { Text("arrow_upward") }
          MDCDataTableSortCell(columnId = "$id-3", label = "Comments", buttonAttrs = {
            classes("material-icons")
          }) { Text("arrow_upward") }
        }
        Body {
          items.forEach {
            Row(selected = it.selected) {
              HeaderCell(text = it.dessert, selected = it.selected)
              Cell(text = it.carbs, numeric = true)
              Cell(text = it.proteins, numeric = true)
              Cell(text = it.comments)
            }
          }
        }
      }
    }
  }
}

private fun MDCDataTableAttrsScope.registerEvents(name: String = "MDCDataTable") {
  onRowClick { console.info("$name#onRowClick", it.detail) }
  onSorted { console.info("$name#onSorted", it.detail) }
  onSelectedAll { console.info("$name#onSelectedAll", it.detail) }
  onUnselectedAll { console.info("$name#onUnselectedAll", it.detail) }
  onRowSelectionChanged { console.info("$name#onRowSelectionChanged", it.detail) }
}
