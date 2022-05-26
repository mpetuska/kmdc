package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.katalog.runtime.util.LoremIpsum
import dev.petuska.katalog.runtime.util.RickRollUrl
import dev.petuska.katalog.runtime.util.randomImageUrl
import dev.petuska.kmdc.button.Label
import dev.petuska.kmdc.card.*
import dev.petuska.kmdc.typography.MDCBody1
import dev.petuska.kmdc.typography.MDCH4
import dev.petuska.kmdc.typography.MDCSubtitle1
import dev.petuska.kmdcx.icons.MDCIcon
import org.jetbrains.compose.web.css.backgroundImage
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanControl
import sandbox.control.ChoiceControl
import sandbox.util.NamedGroup

private class MDCCardVM {
  var type by mutableStateOf(MDCCardType.Outlined)
  var mediaType by mutableStateOf(MDCCardMediaType.Cinema)
  var fullBleed by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCCard")
fun MDCCard() = InteractiveShowcase(
  viewModel = { MDCCardVM() },
  controls = {
    ChoiceControl("Type", MDCCardType.values().associateBy(MDCCardType::name), ::type)
    NamedGroup("Media") {
      ChoiceControl("Type", MDCCardMediaType.values().associateBy(MDCCardMediaType::name), ::mediaType)
    }
    NamedGroup("Actions") {
      BooleanControl("Full Bleed", ::fullBleed)
    }
  },
) {
  MDCCard(
    type = type,
  ) {
    PrimaryAction {
      Media(
        type = mediaType,
        attrs = {
          style {
            backgroundImage("url(\"${randomImageUrl()}\")")
          }
        }
      ) {
        MediaContent {
          MDCH4("Title")
          MDCSubtitle1("Subtitle")
        }
      }
      MDCBody1(LoremIpsum)
    }
    Actions(fullBleed = fullBleed) {
      if (fullBleed) {
        ActionButtonLink(href = RickRollUrl) { Label("Action 1") }
      } else {
        ActionButtons {
          ActionButton { Label("Action 1") }
          ActionButton { Label("Action 2") }
        }
        ActionIcons {
          ActionIconButton(attrs = {
            classes("material-icons")
            title("Share")
          }) { Text(MDCIcon.Share.type) }
          ActionIconButton(attrs = {
            classes("material-icons")
            title("More options")
          }) { Text(MDCIcon.MoreVert.type) }
        }
      }
    }
  }
}
