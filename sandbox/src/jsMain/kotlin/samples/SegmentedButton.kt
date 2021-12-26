package local.sandbox.samples

import dev.petuska.kmdc.segmented.button.MDCSegmentedButton
import dev.petuska.kmdc.segmented.button.MDCSegmentedButtonIcon
import dev.petuska.kmdc.segmented.button.MDCSegmentedButtonLabel
import dev.petuska.kmdc.segmented.button.MDCSegmentedButtonSegment
import dev.petuska.kmdc.segmented.button.onSegmentChange
import local.sandbox.engine.Sample
import local.sandbox.engine.Samples
import org.jetbrains.compose.web.dom.Text

@Suppress("unused")
private val SegmentedButtonSamples = Samples(
  name = "MDCSegmentedButton",
  description = "See custom event logs in the console"
) {
  MultiSelect()
  SingleSelect()
}

private val MultiSelect by Sample {
  MDCSegmentedButton(attrs = {
    onSegmentChange { console.log("onSegmentChange", it.detail) }
  }) {
    MDCSegmentedButtonSegment(
      attrs = {
        id("mdc-segmented-button-ms-segment-0")
        onSegmentSelected { console.log("onSegmentSelected", it.detail) }
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
        onSegmentSelected { console.log("onSegmentSelected", it.detail) }
      }
    )
    MDCSegmentedButtonSegment(
      attrs = {
        id("mdc-segmented-button-ms-segment-2")
        onSegmentSelected { console.log("onSegmentSelected", it.detail) }
      }
    ) {
      MDCSegmentedButtonIcon(attrs = {
        classes("material-icons")
      }) { Text("favorite") }
      MDCSegmentedButtonLabel("Two")
    }
  }
}

private val SingleSelect by Sample {
  MDCSegmentedButton(
    opts = { singleSelect = true },
    attrs = {
      onSegmentChange { console.log("onSegmentChange", it.detail) }
    }
  ) {
    MDCSegmentedButtonSegment(
      opts = { selected = true },
      attrs = { onSegmentSelected { console.log("onSegmentSelected", it.detail) } }
    ) {
      MDCSegmentedButtonIcon(attrs = {
        classes("material-icons")
      }) { Text("favorite") }
    }
    MDCSegmentedButtonSegment(
      text = "A",
      attrs = { onSegmentSelected { console.log("onSegmentSelected", it.detail) } }
    )
    MDCSegmentedButtonSegment(
      attrs = { onSegmentSelected { console.log("onSegmentSelected", it.detail) } }
    ) {
      MDCSegmentedButtonIcon(attrs = {
        classes("material-icons")
      }) { Text("favorite") }
      MDCSegmentedButtonLabel("B")
    }
  }
}
