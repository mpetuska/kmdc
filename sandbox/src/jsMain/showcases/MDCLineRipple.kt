package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.kmdc.line.ripple.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import sandbox.control.*


private class MDCLineRippleVM {
  var active by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCLineRipple")
fun MDCLineRipple() = InteractiveShowcase(
  viewModel = { MDCLineRippleVM() },
  controls = {
    BooleanControl("Active", ::active)
  },
) {
  Div(attrs = {
    style {
      display(DisplayStyle.LegacyInlineFlex)
      position(Position.Relative)
    }
  }) {
    TextInput("Notice the thick line bellow", attrs = {
      disabled()
    })
    MDCLineRipple(active)
  }
}
