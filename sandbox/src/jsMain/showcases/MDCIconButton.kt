package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.icon.button.Icon
import dev.petuska.kmdc.icon.button.MDCIconButton
import dev.petuska.kmdc.icon.button.MDCIconButtonAttrsScope
import dev.petuska.kmdc.icon.button.onChange
import dev.petuska.kmdc.touch.target.MDCTouchTarget
import dev.petuska.kmdcx.icons.MDCIcon
import dev.petuska.kmdcx.icons.mdcIcon
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanControl
import sandbox.control.ChoiceControl

private class MDCIconButtonVM {
  var disabled by mutableStateOf(false)
  var on by mutableStateOf<Boolean?>(true)
  var touch by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCIconButton")
fun MDCIconButton() = InteractiveShowcase(
  viewModel = { MDCIconButtonVM() },
  controls = {
    ChoiceControl(
      title = "On",
      options = mapOf(
        "true" to true,
        "false" to false,
        "null" to null,
      ),
      selected = ::on
    )
    BooleanControl("Disabled", ::disabled)
    BooleanControl("Touch", ::touch)
  },
) {
  MDCTouchTarget {
    MDCIconButton(
      on = on,
      touch = touch,
      attrs = {
        if (disabled) disabled()
        if (on == null) mdcIcon()
        registerEvents()
        onChange { on = it.detail.isOn }
      }
    ) {
      if (on != null) {
        Icon(on = true, attrs = { mdcIcon() }) {
          Text(MDCIcon.Favorite.type)
        }
        Icon(on = false, attrs = { mdcIcon() }) {
          Text(MDCIcon.FavoriteBorder.type)
        }
      } else {
        Text(MDCIcon.Favorite.type)
      }
    }
  }
}

private fun MDCIconButtonAttrsScope<*>.registerEvents() {
  onChange { console.log("MDCIconButton#onChange", it.detail) }
}
