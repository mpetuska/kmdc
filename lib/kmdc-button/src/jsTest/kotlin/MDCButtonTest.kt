package dev.petuska.kmdc.button

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.testutils.runTest
import org.w3c.dom.HTMLButtonElement
import kotlin.test.Test
import kotlin.test.assertEquals

class MDCButtonTest {
  @Test
  fun render() = runTest {
    var count by mutableStateOf(0)
    composition {
      MDCButton("Clicked $count times", attrs = { onClick { count++ } })
    }
    assertEquals(
      "<button class=\"mdc-button\"><span class=\"mdc-button__ripple\"></span>Clicked 0 times</button>", root.innerHTML
    )
    root.firstElementChild.unsafeCast<HTMLButtonElement>().click()
    waitForRecompositionComplete()
    assertEquals(
      "<button class=\"mdc-button\"><span class=\"mdc-button__ripple\"></span>Clicked 1 times</button>", root.innerHTML
    )
    count = 10
    waitForRecompositionComplete()
    assertEquals(
      "<button class=\"mdc-button\"><span class=\"mdc-button__ripple\"></span>Clicked 10 times</button>", root.innerHTML
    )
  }
}
