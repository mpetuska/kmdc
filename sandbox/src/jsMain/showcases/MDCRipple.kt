package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.ripple.MDCRipple
import dev.petuska.kmdc.typography.MDCBody1
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import sandbox.control.BooleanControl

private class MDCRippleVM {
  var disabled by mutableStateOf(false)
  var unbounded by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCRipple")
fun MDCRipple() = InteractiveShowcase(
  viewModel = { MDCRippleVM() },
  controls = {
    BooleanControl("Disabled", ::disabled)
    BooleanControl("Unbounded", ::unbounded)
  },
) {
  Div(attrs = {
    classes("kmdc-ripple")
    style {
      padding(1.em)
      property("width", "fit-content")
      border(0.05.em, LineStyle.Solid, Color.black)
      cursor("pointer")
      overflow(if (unbounded) "visible" else "hidden")
    }
  }) {
    MDCRipple(
      unbounded = unbounded,
      disabled = disabled,
    )
    MDCBody1("Click Me!")
  }
}
