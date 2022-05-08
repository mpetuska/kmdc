package samples

import dev.petuska.kmdc.segmented.button.MDCSegmentedButton
import dev.petuska.kmdc.segmented.button.MDCSegmentedButtonAttrsScope
import dev.petuska.kmdc.segmented.button.MDCSegmentedButtonIcon
import dev.petuska.kmdc.segmented.button.MDCSegmentedButtonLabel
import dev.petuska.kmdc.segmented.button.MDCSegmentedButtonSegment
import dev.petuska.kmdc.segmented.button.MDCSegmentedButtonSegmentAttrsScope
import dev.petuska.kmdc.segmented.button.onChange
import dev.petuska.kmdc.segmented.button.onClicked
import dev.petuska.kmdc.segmented.button.onSelected
import org.jetbrains.compose.web.dom.Text

object MDCSegmentedButton : Samples(description = "See custom event logs in the console") {
  override val content: SamplesRender = {
    MultiSelect()
    SingleSelect()
  }

  private fun MDCSegmentedButtonAttrsScope.registerEvents(name: String) {
    onChange { console.log("$name#onSegmentChange", it.detail) }
    onSelected { console.log("$name#onSegmentSelected", it.detail) }
  }

  private fun MDCSegmentedButtonSegmentAttrsScope.registerEvents(name: String) {
    onSelected { console.log("$name#onSelected", it.detail) }
    onClicked { console.log("$name#onClicked", it.detail) }
  }

  private val MultiSelect = Sample("MultiSelect") { name ->
    MDCSegmentedButton(attrs = {
      registerEvents(name)
    }) {
      MDCSegmentedButtonSegment(
        attrs = {
          id("mdc-segmented-button-ms-segment-0")
          registerEvents(name)
        }
      ) {
        MDCSegmentedButtonIcon(attrs = {
          classes("material-icons")
        }) { Text("favorite") }
      }
      MDCSegmentedButtonSegment(
        text = "One",
        attrs = {
          id("mdc-segmented-button-ms-segment-1")
          registerEvents(name)
        }
      )
      MDCSegmentedButtonSegment(
        attrs = {
          id("mdc-segmented-button-ms-segment-2")
          registerEvents(name)
        }
      ) {
        MDCSegmentedButtonIcon(attrs = {
          classes("material-icons")
        }) { Text("favorite") }
        MDCSegmentedButtonLabel("Two")
      }
    }
  }

  private val SingleSelect = Sample("SingleSelect") { name ->
    MDCSegmentedButton(
      opts = { singleSelect = true },
      attrs = {
        registerEvents(name)
      }
    ) {
      MDCSegmentedButtonSegment(
        opts = { selected = true },
        attrs = {
          registerEvents(name)
        }
      ) {
        MDCSegmentedButtonIcon(attrs = {
          classes("material-icons")
        }) { Text("favorite") }
      }
      MDCSegmentedButtonSegment(
        text = "A",
        attrs = {
          registerEvents(name)
        }
      )
      MDCSegmentedButtonSegment(
        attrs = {
          registerEvents(name)
        }
      ) {
        MDCSegmentedButtonIcon(attrs = {
          classes("material-icons")
        }) { Text("favorite") }
        MDCSegmentedButtonLabel("B")
      }
    }
  }
}
