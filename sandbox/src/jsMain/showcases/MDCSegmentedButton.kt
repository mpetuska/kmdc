package showcases

import androidx.compose.runtime.*
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.segmented.button.*
import dev.petuska.kmdc.touch.target.MDCTouchTarget
import dev.petuska.kmdcx.icons.MDCIcon
import dev.petuska.kmdcx.icons.mdcIcon
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Text
import sandbox.control.BooleanControl

private class MDCSegmentedButtonVM {
  var disabled by mutableStateOf(false)
  var singleSelect by mutableStateOf(false)
  var touch by mutableStateOf(false)

  var selected = mutableStateListOf<String?>()
}

@Composable
@Showcase(id = "MDCSegmentedButton")
fun MDCSegmentedButton() = InteractiveShowcase(
  viewModel = { MDCSegmentedButtonVM() },
  controls = {
    BooleanControl("Disabled", ::disabled)
    BooleanControl("Single Select", ::singleSelect)

    BooleanControl("Touch", ::touch)
  },
) {
  MDCTouchTarget {
    MDCSegmentedButton(
      singleSelect = singleSelect,
      attrs = {
        registerEvents()
        onSelected {
          if (singleSelect) selected.clear()
          if (!it.detail.selected) {
            selected.remove(it.detail.segmentId)
          } else {
            selected.add(it.detail.segmentId)
          }
        }
      }
    ) {
      Segment(
        touch = touch,
        segmentId = "mdc-segmented-button-segment-0",
        selected = "mdc-segmented-button-segment-0" in selected,
        attrs = {
          registerEvents()
          if (disabled) disabled()
        }
      ) {
        Icon(attrs = {
          mdcIcon()
        }) { Text(MDCIcon.Favorite.type) }
      }
      Segment(
        text = "One",
        segmentId = "mdc-segmented-button-segment-1",
        touch = touch,
        selected = "mdc-segmented-button-segment-1" in selected,
        attrs = {
          registerEvents()
          if (disabled) disabled()
        }
      )
      Segment(
        touch = touch,
        segmentId = "mdc-segmented-button-segment-2",
        selected = "mdc-segmented-button-segment-2" in selected,
        attrs = {
          registerEvents()
          if (disabled) disabled()
        }
      ) {
        Icon(attrs = {
          mdcIcon()
        }) { Text(MDCIcon.Favorite.type) }
        Label("Two")
      }
    }
  }
}

private fun MDCSegmentedButtonAttrsScope.registerEvents() {
  onChange { console.log("MDCSegmentedButton#onSegmentChange", it.detail) }
  onSelected { console.log("MDCSegmentedButton#onSegmentSelected", it.detail) }
}

private fun MDCSegmentedButtonSegmentAttrsScope.registerEvents() {
  onSelected { console.log("MDCSegmentedButton#onSelected", it.detail) }
  onClicked { console.log("MDCSegmentedButton#onClicked", it.detail) }
}
