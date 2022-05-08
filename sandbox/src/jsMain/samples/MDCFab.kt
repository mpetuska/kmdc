package samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.core.KMDCInternalAPI
import dev.petuska.kmdc.core.rememberMutableStateOf
import dev.petuska.kmdc.fab.Icon
import dev.petuska.kmdc.fab.Label
import dev.petuska.kmdc.fab.MDCFab
import dev.petuska.kmdc.fab.MDCFabType
import dev.petuska.kmdc.form.field.MDCFormField
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Hr
import org.jetbrains.compose.web.dom.Text

object MDCFab : Samples() {
  override val content: SamplesRender = {
    Regular()
    Mini()
    Accessible()
    Extended()
  }

  @OptIn(KMDCInternalAPI::class)
  @Composable
  private fun Layout(
    content: @Composable (exited: Boolean) -> Unit
  ) {
    var exited by rememberMutableStateOf(false)
    Div {
      MDCFormField {
        MDCCheckbox(
          checked = exited, attrs = {
            onInput { exited = !exited }
          }, label = "Exited"
        )
      }
    }
    Hr()
    Div {
      content(exited)
    }
  }

  private val Accessible = Sample("Accessible", span = 3u) {
    Layout { exited ->
      Div(attrs = {
        classes("mdc-touch-target-wrapper")
      }) {
        MDCFab(touch = true, exited = exited, type = MDCFabType.Mini, attrs = {
          attr("aria-label", "Favorite")
        }) {
          Icon(attrs = { classes("material-icons") }) { Text("favorite") }
        }
      }
    }
  }

  private val Regular = Sample("Regular", span = 3u) {
    Layout { exited ->
      MDCFab(exited = exited, attrs = {
        attr("aria-label", "Favorite")
      }) {
        Icon(attrs = { classes("material-icons") }) { Text("favorite") }
      }
    }
  }

  private val Mini = Sample("Mini", span = 3u) {
    Layout { exited ->
      MDCFab(type = MDCFabType.Mini, exited = exited, attrs = {
        attr("aria-label", "Favorite")
      }) {
        Icon(attrs = { classes("material-icons") }) { Text("favorite") }
      }
    }
  }

  private val Extended = Sample("Extended", span = 3u) {
    Layout { exited ->
      MDCFab(type = MDCFabType.Extended, exited = exited, attrs = {}) {
        Label("Create")
        Icon(attrs = { classes("material-icons") }) { Text("add") }
      }
    }
  }
}
