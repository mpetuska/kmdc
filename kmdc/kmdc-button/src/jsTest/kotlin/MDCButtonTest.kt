package dev.petuska.kmdc.button

import androidx.compose.runtime.*
import org.jetbrains.compose.web.testutils.*
import org.w3c.dom.*
import kotlin.test.*

class MDCButtonTest {
  @Test
  fun render() = runTest {
    fun HTMLElement.assertHtml(count: Int, upgraded: Boolean) {
      assertEquals(
        expected = """<button class="mdc-button${
        if (upgraded) " mdc-ripple-upgraded" else ""
        }">""" + """<div class="mdc-elevation-overlay"></div>""" + """<span class="mdc-button__ripple"></span>""" + """<span class="mdc-button__focus-ring"></span>""" + """<span class="mdc-button__label">Clicked $count times</span></button>""",
        actual = innerHTML
      )
    }

    var count by mutableStateOf(0)
    composition {
      MDCButton("Clicked $count times", attrs = { onClick { count++ } })
    }
    root.assertHtml(0, false)
    root.firstElementChild.unsafeCast<HTMLButtonElement>().click()
    waitForRecompositionComplete()
    root.assertHtml(1, true)
    count = 10
    waitForRecompositionComplete()
    root.assertHtml(10, true)
  }
}
