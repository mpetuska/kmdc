package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.typography.MDCCaption
import dev.petuska.kmdcx.icons.MDCIcon
import dev.petuska.kmdcx.icons.MDCIconBase
import dev.petuska.kmdcx.icons.MDCIconType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import sandbox.control.ChoiceControl
import sandbox.control.RangeControl

private class MDCIconVM {
  var base by mutableStateOf(MDCIconBase.I)
  var type by mutableStateOf(MDCIconType.Filled)
  var size by mutableStateOf(24)
}

@Composable
@Showcase(id = "MDCIcon")
fun MDCIcon() = InteractiveShowcase(
  viewModel = { MDCIconVM() },
  controls = {
    ChoiceControl("Base", MDCIconBase.values().associateBy(MDCIconBase::name), ::base)
    ChoiceControl("Type", MDCIconType.values().associateBy(MDCIconType::name), ::type)
    RangeControl("Size", size, min = 12, max = 240, step = 12) { size = it.toInt() }
  },
) {
  Div(attrs = {
    style {
      display(DisplayStyle.Flex)
      flexFlow(FlexDirection.Row, FlexWrap.Wrap)
    }
  }) {
    MDCIcon.values().forEach { icon ->
      Div(attrs = {
        style {
          padding(0.5.em)
          display(DisplayStyle.Flex)
          flexDirection(FlexDirection.Column)
          alignItems(AlignItems.Center)
          justifyContent(JustifyContent.Center)
        }
      }) {
        MDCIcon(
          base = base,
          type = type,
          icon = icon,
          attrs = {
            style {
              fontSize(size.px)
            }
          }
        )
        MDCCaption(icon.name)
        MDCCaption("(${icon.type})")
      }
    }
  }
}
