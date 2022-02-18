package local.sandbox.samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonOpts
import dev.petuska.kmdc.core.MDCInternalAPI
import dev.petuska.kmdc.core.rememberMutableStateOf
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
import local.sandbox.engine.Sample
import local.sandbox.engine.Samples
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Suppress("unused")
private val DataTableSamples = Samples("MDCDataTable") {
  Simple()
  Interactive()
}

private val Simple by Sample {
  MDCDataTable(attrs = {
    registerEvents()
  }) {
    MDCDataTableContainer {
      MDCDataTableHeader {
        MDCDataTableCell("Dessert")
        MDCDataTableCell("Carbs (g)", true)
        MDCDataTableCell("Protein (g)", true)
        MDCDataTableCell("Comments")
      }
      MDCDataTableBody {
        MDCDataTableRow {
          MDCDataTableHeaderCell("Frozen yogurt")
          MDCDataTableCell("24", true)
          MDCDataTableCell("4.0", true)
          MDCDataTableCell("Super tasty")
        }
        MDCDataTableRow {
          MDCDataTableHeaderCell("Ice cream sandwich")
          MDCDataTableCell("37", true)
          MDCDataTableCell("4.33333333333", true)
          MDCDataTableCell("I like ice cream more")
        }
        MDCDataTableRow {
          MDCDataTableHeaderCell("Eclair")
          MDCDataTableCell("24", true)
          MDCDataTableCell("6.0", true)
          MDCDataTableCell("New filing flavor")
        }
      }
    }
  }
}

private data class Item(
  val dessert: String,
  val carbs: String,
  val proteins: String,
  val comments: String,
  val selected: Boolean = false,
)

@OptIn(MDCInternalAPI::class)
private val Interactive by Sample(
  "Adds row selection, data loading and sorting to the mix"
) {
  Div({
    style {
      display(DisplayStyle.Flex)
      flexDirection(FlexDirection.Column)
    }
  }) {
    var loading by rememberMutableStateOf(false)
    val items = remember {
      mutableStateListOf(
        Item("Frozen yogurt", "24", "4.0", "Super tasty"),
        Item("Ice cream sandwich", "37", "4.33333333333", "I like ice cream more"),
        Item("Eclair", "24", "6.0", "New filing flavor"),
      )
    }
    MDCButton(
      text = if (loading) "Stop" else "Load",
      opts = { type = MDCButtonOpts.Type.Outlined },
      attrs = {
        onClick { loading = !loading }
      }
    )
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
            1 -> Item::dessert
            2 -> Item::carbs
            3 -> Item::proteins
            4 -> Item::comments
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
        val id = rememberUniqueDomElementId()
        MDCDataTableHeader {
          MDCDataTableCheckCell(items.all(Item::selected), label = "Toggle All")
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
            MDCDataTableRow {
              MDCDataTableHeaderCell(it.dessert, selected = it.selected)
              MDCDataTableCell(it.carbs, true)
              MDCDataTableCell(it.proteins, true)
              MDCDataTableCell(it.comments)
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
