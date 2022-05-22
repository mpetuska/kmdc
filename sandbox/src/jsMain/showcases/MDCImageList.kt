package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.*
import dev.petuska.katalog.runtime.layout.*
import dev.petuska.kmdc.image.list.*
import sandbox.control.*
import sandbox.util.*

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
