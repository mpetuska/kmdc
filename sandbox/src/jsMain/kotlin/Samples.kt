package local.sandbox

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.layout.grid.MDCLayoutGrid
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCell
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCells
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCellsScope
import dev.petuska.kmdc.layout.grid.MDCLayoutGridScope
import dev.petuska.kmdc.typography.MDCH5
import dev.petuska.kmdc.typography.MDCH6
import org.jetbrains.compose.web.dom.Div

@DslMarker
annotation class SampleDsl

typealias SampleRender = @Composable MDCLayoutGridCellsScope.() -> Unit

data class Sample(val name: String?, private val content: SampleRender) {
  @Composable
  operator fun invoke() {
    Div {
      name?.let { MDCH5(it) }
      MDCLayoutGrid {
        MDCLayoutGridCells {
          content()
        }
      }
    }
  }
}

private val samples = mutableSetOf<Sample>()

object Samples : Set<Sample> by samples {
  @SampleDsl
  operator fun invoke(name: String? = null, render: SampleRender): Sample = Sample(name, render).also(samples::add)

  @SampleDsl
  @Composable
  fun MDCLayoutGridCellsScope.Sample(name: String? = null, content: ComposableBuilder<MDCLayoutGridScope>) {
    MDCLayoutGridCell {
      name?.let { MDCH6(it) }
      content()
    }
  }
}
