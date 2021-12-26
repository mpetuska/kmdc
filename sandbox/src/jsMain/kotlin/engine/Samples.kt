package local.sandbox.engine

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCell
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCellsScope
import dev.petuska.kmdc.layout.grid.MDCLayoutGridScope
import dev.petuska.kmdc.typography.MDCH5
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

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

class Sample @SampleDsl constructor(
  private val description: String? = null,
  private val span: UInt = 6u,
  private val content: @Composable MDCLayoutGridScope.(name: String) -> Unit
) : ReadOnlyProperty<Nothing?, @Composable MDCLayoutGridCellsScope.() -> Unit> {

  private var sample: @Composable (MDCLayoutGridCellsScope.() -> Unit)? = null

  override fun getValue(thisRef: Nothing?, property: KProperty<*>): @Composable MDCLayoutGridCellsScope.() -> Unit {
    return sample ?: run {
      val s: @Composable MDCLayoutGridCellsScope.() -> Unit = { Sample(property.name, description, span, content) }
      s.also { sample = it }
    }
  }
}

@SampleDsl
@Composable
fun MDCLayoutGridCellsScope.Sample(
  name: String,
  description: String? = null,
  span: UInt = 6u,
  content: @Composable MDCLayoutGridScope.(name: String) -> Unit
) {
  NamedCell(name, description, span) {
    MDCLayoutGridCell({ this.span = 12u }) {
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
