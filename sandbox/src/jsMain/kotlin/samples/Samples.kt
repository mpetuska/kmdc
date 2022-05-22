package samples

import androidx.compose.runtime.*
import dev.petuska.kmdc.layout.grid.*
import dev.petuska.kmdc.typography.*
import engine.*
import kotlin.random.*

typealias SamplesScope = MDCLayoutGridCellsScope
typealias SamplesRender = @Composable SamplesScope.(name: String) -> Unit
typealias Sample = @Composable SamplesScope.() -> Unit
typealias SampleScope = MDCLayoutGridScope
typealias SampleRender = @Composable SampleScope.(name: String) -> Unit


abstract class Samples(
  private val description: String? = null,
) {
  open val name: String by lazy { this::class.simpleName!! }

  protected abstract val content: SamplesRender

  protected fun randomImageUrl(
    seed: String,
    maxWidth: UInt = 300u,
    maxHeight: UInt = maxWidth,
    minWidth: UInt = 50u,
    minHeight: UInt = minWidth,
  ): String {
    val width: Int = Random.nextInt(maxWidth.toInt()) + minWidth.toInt()
    val height: Int = Random.nextInt(maxHeight.toInt()) + minHeight.toInt()
    return "https://picsum.photos/seed/$seed/$width/$height"
  }

  @Composable
  protected fun <T> rememberMutableStateOf(initial: T): MutableState<T> = remember { mutableStateOf(initial) }

  @Composable
  protected fun SamplesScope.Sample(
    name: String, description: String? = null, span: UInt = 6u, content: SampleRender
  ) {
    NamedCell(name, description, span, sample = true) {
      MDCLayoutGridCell({ this.span = 12u }, attrs = {
        classes("sample")
      }) {
        content(name)
      }
    }
  }

  @Composable
  protected fun SamplesScope.Sample(
    span: UInt = 6u, content: SampleRender
  ) {
    NamedCell(null, description, span, sample = true) {
      MDCLayoutGridCell({ this.span = 12u }, attrs = {
        classes("sample")
      }) {
        content(name)
      }
    }
  }

  protected fun Sample(
    name: String, description: String? = null, span: UInt = 6u, content: SampleRender
  ): Sample = {
    Sample(name, description, span, content)
  }

  protected fun Sample(
    span: UInt = 6u, content: SampleRender
  ): Sample = {
    Sample(span, content)
  }

  @Composable
  fun SamplesScope.render() {
    NamedCell(name, description, span = 12u, titleRender = { t, a -> MDCH5(t, a) }) {
      content(name)
    }
  }
}
