package local.sandbox.engine

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCell
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCellsScope
import dev.petuska.kmdc.layout.grid.MDCLayoutGridScope
import dev.petuska.kmdc.typography.MDCH5

@SampleDsl
data class Samples(
  val name: String,
  val description: String?,
  private val content: SampleRender
) {
  constructor(name: String, content: SampleRender) : this(name, null, content)

  companion object {
    private val samples = mutableSetOf<Samples>()
    val all: Set<Samples> get() = samples
  }

  init {
    samples.add(this)
  }

  @SampleDsl
  @Composable
  operator fun MDCLayoutGridCellsScope.invoke() {
    NamedCell(name, description, titleRender = { t, a -> MDCH5(t, a) }) {
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
  description: String? = null,
  content: @Composable MDCLayoutGridScope.(name: String) -> Unit
) {
  NamedCell(name, description) {
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
  NamedCell(null, null, span) {
    MDCLayoutGridCell({ this.span = 12u }) {
      content()
    }
  }
}
