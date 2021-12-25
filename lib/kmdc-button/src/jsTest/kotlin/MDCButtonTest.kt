package dev.petuska.kmdc.button

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.klip.api.assertKlip
import org.jetbrains.compose.web.testutils.runTest
import org.w3c.dom.HTMLButtonElement
import kotlin.test.Test

class MDCButtonTest {
  @Test
  fun render() = runTest {
    var count by mutableStateOf(0)
    composition {
      MDCButton("Clicked $count times", attrs = { onClick { count++ } })
    }
    println(root.innerHTML)
    root.firstElementChild.unsafeCast<HTMLButtonElement>().click()
    waitForRecompositionComplete()
    println(root.innerHTML)
    count = 10
    println(root.innerHTML)
    waitForRecompositionComplete()
  }
}
