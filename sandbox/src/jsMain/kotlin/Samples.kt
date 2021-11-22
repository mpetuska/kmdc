package local.sandbox

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCell
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCellsScope
import dev.petuska.kmdc.layout.grid.MDCLayoutGridScope

@DslMarker
annotation class SampleDsl

typealias Sample = @Composable MDCLayoutGridCellsScope.() -> Unit

private val samples = mutableSetOf<Sample>()

object Samples : Set<Sample> by samples {
  @SampleDsl
  operator fun invoke(sample: Sample): Sample = sample.also {
    samples.add(sample)
  }
  
  @SampleDsl
  @Composable
  fun MDCLayoutGridCellsScope.Sample(content: ComposableBuilder<MDCLayoutGridScope>) {
    MDCLayoutGridCell(content = content)
  }
}
