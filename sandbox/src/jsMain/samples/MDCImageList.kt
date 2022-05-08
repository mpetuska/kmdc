package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.core.KMDCInternalAPI
import dev.petuska.kmdc.core.rememberMutableStateOf
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdc.image.list.Image
import dev.petuska.kmdc.image.list.Item
import dev.petuska.kmdc.image.list.Label
import dev.petuska.kmdc.image.list.MDCImageList
import dev.petuska.kmdc.image.list.MDCImageListType
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Hr

object MDCImageList : Samples() {
  override val content: SamplesRender = {
    Standard()
    Masonry()
  }

  @OptIn(KMDCInternalAPI::class)
  @Composable
  private fun Layout(
    content: @Composable (withTextProtection: Boolean) -> Unit
  ) {
    require("./MDCImageList.scss")
    var withTextProtection by rememberMutableStateOf(false)
    Div {
      MDCFormField {
        MDCCheckbox(
          checked = withTextProtection, attrs = {
            onInput { withTextProtection = !withTextProtection }
          }, label = "With text protection"
        )
      }
    }
    Hr()
    Div {
      content(withTextProtection)
    }
  }

  private val Standard = Sample("Standard") {
    Layout { withTextProtection ->
      MDCImageList(
        withTextProtection = withTextProtection,
        attrs = {
          classes("kmdc-image-list-standard")
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
  }

  private val Masonry = Sample("Masonry") {
    Layout { withTextProtection ->
      MDCImageList(
        type = MDCImageListType.Masonry, withTextProtection = withTextProtection,
        attrs = {
          classes("kmdc-image-list-masonry")
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
  }
}
