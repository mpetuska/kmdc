package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.katalog.runtime.util.LoremIpsum
import dev.petuska.kmdc.top.app.bar.*
import dev.petuska.kmdc.typography.MDCBody1
import dev.petuska.kmdcx.icons.MDCIcon
import dev.petuska.kmdcx.icons.mdcIcon
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.dom.Text
import sandbox.control.ChoiceControl

private class MDCTopAppBarVM {
  var type by mutableStateOf(MDCTopAppBarType.Default)

  var open by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCTopAppBar")
fun MDCTopAppBar() = InteractiveShowcase(
  viewModel = { MDCTopAppBarVM() },
  controls = {
    ChoiceControl("Type", MDCTopAppBarType.values().associateBy(MDCTopAppBarType::name), ::type)
  },
) {
  MDCTopAppBar(type = type) {
    TopAppBar(attrs = {
      registerEvents()
      onNav { open = !open }
      style {
        position(Position.Relative)
        if (open) variable("--mdc-theme-primary", "#494451")
      }
    }) {
      Row {
        Section(align = MDCTopAppBarSectionAlign.Start) {
          NavButton(attrs = { mdcIcon() }) { Text(if (open) MDCIcon.Close.type else MDCIcon.Menu.type) }
          Title("Contextual Title")
        }
        Section(
          align = MDCTopAppBarSectionAlign.End,
          attrs = {
            attr("role", "toolbar")
          }
        ) {
          ActionButton(attrs = { mdcIcon() }) { Text(MDCIcon.Share.type) }
          ActionButton(attrs = { mdcIcon() }) { Text(MDCIcon.Delete.type) }
          ActionButton(attrs = { mdcIcon() }) { Text(MDCIcon.MoreVert.type) }
        }
      }
    }
    Main {
      MDCBody1(LoremIpsum)
    }
  }
}

private fun MDCTopAppBarAttrsScope.registerEvents() {
  onNav { console.log("MDCTopAppBar#onNav", it.detail) }
}
