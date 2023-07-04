package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.katalog.runtime.util.randomImageUrl
import dev.petuska.kmdc.image.list.*
import sandbox.control.BooleanControl
import sandbox.control.ChoiceControl
import sandbox.util.requireModule

private class MDCImageListVM {
  var type by mutableStateOf(MDCImageListType.Standard)
  var withTextProtection by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCImageList")
fun MDCImageList() = InteractiveShowcase(
  viewModel = { MDCImageListVM() },
  controls = {
    ChoiceControl("Type", MDCImageListType.values().associateBy(MDCImageListType::name), ::type)
    BooleanControl("With Text Protection", ::withTextProtection)
  },
) {
  requireModule("./MDCImageList.scss")
  MDCImageList(
    type = type,
    withTextProtection = withTextProtection,
    attrs = {
      classes("kmdc-image-list")
    }
  ) {
    repeat(7) {
      Item {
        Image(src = randomImageUrl("kmdc-$it"))
        Label("Image #$it")
      }
    }
  }
}
