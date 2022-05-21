package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.core.KMDCInternalAPI
import dev.petuska.kmdc.core.MDCExternalAPI
import dev.petuska.kmdc.core.rememberUniqueDomElementId
import dev.petuska.kmdc.data.table.MDCDataTable
import dev.petuska.kmdc.data.table.MDCDataTableAttrsScope
import dev.petuska.kmdc.data.table.MDCDataTableBody
import dev.petuska.kmdc.data.table.MDCDataTableCell
import dev.petuska.kmdc.data.table.MDCDataTableCheckCell
import dev.petuska.kmdc.data.table.MDCDataTableContainer
import dev.petuska.kmdc.data.table.MDCDataTableHeader
import dev.petuska.kmdc.data.table.MDCDataTableHeaderCell
import dev.petuska.kmdc.data.table.MDCDataTableModule
import dev.petuska.kmdc.data.table.MDCDataTableRow
import dev.petuska.kmdc.data.table.MDCDataTableSortCell
import dev.petuska.kmdc.data.table.onRowClick
import dev.petuska.kmdc.data.table.onRowSelectionChanged
import dev.petuska.kmdc.data.table.onSelectedAll
import dev.petuska.kmdc.data.table.onSorted
import dev.petuska.kmdc.data.table.onUnselectedAll
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanControl
import sandbox.control.NamedBlock

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
      MDCDataTableContainer {
        MDCDataTableHeader {
          MDCDataTableCell(text = "Dessert")
          MDCDataTableCell(text = "Carbs (g)", numeric = true)
          MDCDataTableCell(text = "Protein (g)", numeric = true)
          MDCDataTableCell(text = "Comments")
        }
        MDCDataTableBody {
          MDCDataTableRow {
            MDCDataTableHeaderCell(text = "Frozen yogurt")
            MDCDataTableCell(text = "24", numeric = true)
            MDCDataTableCell(text = "4.0", numeric = true)
            MDCDataTableCell(text = "Super tasty")
          }
          MDCDataTableRow {
            MDCDataTableHeaderCell(text = "Ice cream sandwich")
            MDCDataTableCell(text = "37", numeric = true)
            MDCDataTableCell(text = "4.33333333333", numeric = true)
            MDCDataTableCell(text = "I like ice cream more")
          }
          MDCDataTableRow {
            MDCDataTableHeaderCell(text = "Eclair")
            MDCDataTableCell(text = "24", numeric = true)
            MDCDataTableCell(text = "6.0", numeric = true)
            MDCDataTableCell(text = "New filing flavor")
          }
        }
      }
    }
  }
  NamedBlock("Interactive") {
    @OptIn(MDCExternalAPI::class)
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
          if (it.detail.sortValue == MDCDataTableModule.SortValue.ASCENDING) {
            items.sortBy(sortProp)
          } else if (it.detail.sortValue == MDCDataTableModule.SortValue.DESCENDING) {
            items.sortByDescending(sortProp)
          }
        }
      }
    ) {
      MDCDataTableContainer {
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
        MDCDataTableBody {
          items.forEach {
            MDCDataTableRow(selected = it.selected) {
              MDCDataTableHeaderCell(text = it.dessert, selected = it.selected)
              MDCDataTableCell(text = it.carbs, numeric = true)
              MDCDataTableCell(text = it.proteins, numeric = true)
              MDCDataTableCell(text = it.comments)
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
