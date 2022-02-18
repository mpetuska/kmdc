package local.sandbox.samples

import MDCDataTableBody
import MDCDataTableCell
import MDCDataTableHeader
import MDCDataTableHeaderCell
import MDCDataTableRow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.core.MDCInternalAPI
import dev.petuska.kmdc.core.rememberMutableStateOf
import dev.petuska.kmdc.data.table.MDCDataTable
import dev.petuska.kmdc.data.table.MDCDataTableAttrsScope
import dev.petuska.kmdc.data.table.MDCDataTableContainer
import dev.petuska.kmdc.data.table.onRowClick
import dev.petuska.kmdc.data.table.onRowSelectionChanged
import dev.petuska.kmdc.data.table.onSelectedAll
import dev.petuska.kmdc.data.table.onSorted
import dev.petuska.kmdc.data.table.onUnselectedAll
import local.sandbox.engine.Sample
import local.sandbox.engine.Samples
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.dom.Div

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

@OptIn(MDCInternalAPI::class)
private val Interactive by Sample {
  val selected = remember { mutableStateListOf(false, false, false) }
  var loading by rememberMutableStateOf(false)
  Div({
    style {
      display(DisplayStyle.Flex)
    }
  }) {
    MDCButton(if (loading) "Unload" else "Load", attrs = {
      onClick { loading = !loading }
    })
    MDCDataTable(
      loading = loading,
      attrs = {
        registerEvents()
        onSelectedAll {
          for (i in selected.indices) {
            selected[i] = true
          }
        }
        onUnselectedAll {
          for (i in selected.indices) {
            selected[i] = false
          }
        }
        onRowSelectionChanged {
          it.detail.let { d ->
            selected[d.rowIndex] = d.selected == true
          }
        }
        onSorted {
          it.detail.sortValue // TODO
        }
      }
    ) {
      MDCDataTableContainer {
        MDCDataTableHeader {
          MDCDataTableCell(selected.all { it }, label = "Toggle All")
          MDCDataTableCell("Dessert")
          MDCDataTableCell("Carbs (g)", true)
          MDCDataTableCell("Protein (g)", true)
          MDCDataTableCell("Comments")
        }
        MDCDataTableBody {
          MDCDataTableRow {
            MDCDataTableHeaderCell("Frozen yogurt", selected = selected[0])
            MDCDataTableCell("24", true)
            MDCDataTableCell("4.0", true)
            MDCDataTableCell("Super tasty")
          }
          MDCDataTableRow {
            MDCDataTableHeaderCell("Ice cream sandwich", selected = selected[1])
            MDCDataTableCell("37", true)
            MDCDataTableCell("4.33333333333", true)
            MDCDataTableCell("I like ice cream more")
          }
          MDCDataTableRow {
            MDCDataTableHeaderCell("Eclair", selected = selected[2])
            MDCDataTableCell("24", true)
            MDCDataTableCell("6.0", true)
            MDCDataTableCell("New filing flavor")
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
