package local.sandbox.samples

import dev.petuska.kmdc.data.table.MDCDataTable
import dev.petuska.kmdc.data.table.MDCDataTableAttrsScope
import dev.petuska.kmdc.data.table.onRowClick
import dev.petuska.kmdc.data.table.onRowSelectionChanged
import dev.petuska.kmdc.data.table.onSelectedAll
import dev.petuska.kmdc.data.table.onSorted
import dev.petuska.kmdc.data.table.onUnselectedAll
import local.sandbox.engine.Sample
import local.sandbox.engine.Samples

@Suppress("unused")
private val DataTableSamples = Samples("MDCDataTable") {
  Sample("Basic") {
    MDCDataTable(attrs = {
      registerEvents()
    }) {
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
