package local.sandbox.samples

import dev.petuska.kmdc.segmented.button.MDCSegmentedButton
import dev.petuska.kmdc.segmented.button.MDCSegmentedButtonAttrsScope
import dev.petuska.kmdc.segmented.button.MDCSegmentedButtonIcon
import dev.petuska.kmdc.segmented.button.MDCSegmentedButtonLabel
import dev.petuska.kmdc.segmented.button.MDCSegmentedButtonSegment
import dev.petuska.kmdc.segmented.button.MDCSegmentedButtonSegmentAttrsScope
import dev.petuska.kmdc.segmented.button.onSegmentChange
import dev.petuska.kmdc.segmented.button.onSegmentClick
import dev.petuska.kmdc.segmented.button.onSegmentSelected
import local.sandbox.engine.Sample
import local.sandbox.engine.Samples
import org.jetbrains.compose.web.dom.Text

@Suppress("unused")
@EagerInitialization
private val SegmentedButtonSamples = Samples(
  name = "MDCSegmentedButton",
  description = "See custom event logs in the console"
) {
  MultiSelect()
  SingleSelect()
}

private fun MDCSegmentedButtonAttrsScope.registerEvents(name: String) {
  onSegmentChange { console.log("$name#onSegmentChange", it.detail) }
  onSegmentSelected { console.log("$name#onSegmentSelected", it.detail) }
}

private fun MDCSegmentedButtonSegmentAttrsScope.registerEvents(name: String) {
  onSegmentSelected { console.log("$name#onSegmentSelected", it.detail) }
  onSegmentClick { console.log("$name#onSegmentClick", it.detail) }
}

private val MultiSelect by Sample { name ->
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

private val SingleSelect by Sample { name ->
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
