package sandbox.util

import androidx.compose.runtime.*
import dev.petuska.kmdc.form.field.*

@Composable
fun <T> ChunkedFormFields(items: Collection<T>, size: Int = 3, render: @Composable (T) -> Unit) {
  items.chunked(size).forEach { chunk ->
    MDCFormField {
      chunk.forEach {
        render(it)
      }
    }
  }
}
