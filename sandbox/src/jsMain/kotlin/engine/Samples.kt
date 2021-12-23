package local.sandbox.engine

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCell
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCellsScope
import dev.petuska.kmdc.layout.grid.MDCLayoutGridScope

@SampleDsl
data class Samples(private val _name: String, private val content: SampleRender) {
  companion object {
    private val samples = mutableSetOf<Samples>()
    val all: Set<Samples> get() = samples
  }

  val name = "MDC" + _name.removePrefix("MDC")

  init {
    samples.add(this)
  }

  @SampleDsl
  @Composable
  operator fun MDCLayoutGridCellsScope.invoke() {
    NamedCell(name) {
      content()
    }
  }
}

typealias SampleRender = @Composable MDCLayoutGridCellsScope.() -> Unit

@DslMarker
annotation class SampleDsl

@SampleDsl
@Composable
fun MDCLayoutGridCellsScope.Sample(
  name: String,
  content: @Composable MDCLayoutGridScope.(name: String) -> Unit
) {
  NamedCell(name) {
    MDCLayoutGridCell({ span = 12u }) {
      content(name)
    }
  }
}

@SampleDsl
@Composable
fun MDCLayoutGridCellsScope.Sample(
  span: UInt = 6u,
  content: @Composable MDCLayoutGridScope.() -> Unit
) {
  NamedCell(null, span) {
    MDCLayoutGridCell({ this.span = 12u }) {
      content()
    }
  }
}
