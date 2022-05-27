package showcases

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.petuska.katalog.runtime.Showcase
import dev.petuska.katalog.runtime.layout.InteractiveShowcase
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.core.KMDCInternalAPI
import dev.petuska.kmdc.core.domain.Point
import dev.petuska.kmdc.menu.surface.*
import dev.petuska.kmdc.typography.MDCBody1
import sandbox.control.BooleanControl
import sandbox.control.ChoiceControl
import sandbox.util.NamedBlock
import sandbox.util.NamedGroup

private class MDCMenuSurfaceVM {
  var anchorCorner by mutableStateOf(Corner.BOTTOM_START)
  var fullWidth by mutableStateOf(true)
  var fixed by mutableStateOf(false)
  var quickOpen by mutableStateOf(false)
  var hoisted by mutableStateOf(false)
  var restoreFocusOnClose by mutableStateOf(false)

  var open1 by mutableStateOf(false)
  var open2 by mutableStateOf(false)
}

@Composable
@Showcase(id = "MDCMenuSurface")
fun MDCMenuSurface() = InteractiveShowcase(
  viewModel = { MDCMenuSurfaceVM() },
  controls = {
    ChoiceControl(
      title = "Anchor Corner",
      options = mapOf(
        "TOP_LEFT" to Corner.TOP_LEFT,
        "TOP_RIGHT" to Corner.TOP_RIGHT,
        "BOTTOM_LEFT" to Corner.BOTTOM_LEFT,
        "BOTTOM_RIGHT" to Corner.BOTTOM_RIGHT,
        "TOP_START" to Corner.TOP_START,
        "TOP_END" to Corner.TOP_END,
        "BOTTOM_START" to Corner.BOTTOM_START,
        "BOTTOM_END" to Corner.BOTTOM_END,
      ),
      selected = ::anchorCorner
    )
    BooleanControl("Full Width", ::fullWidth)
    BooleanControl("Fixed", ::fixed)
    BooleanControl("Quick Open", ::quickOpen)
    BooleanControl("Hoisted", ::hoisted)
    BooleanControl("Restore Focus on Close", ::restoreFocusOnClose)
    NamedGroup("Absolute") {
      BooleanControl("Open", ::open1)
    }
    NamedGroup("Anchored") {
      BooleanControl("Open", ::open2)
    }
  },
) {
  NamedBlock("Absolute") {
    MDCMenuSurface(
      open = open1,
      fullWidth = fullWidth,
      fixed = fixed,
      anchorCorner = anchorCorner,
      quickOpen = quickOpen,
      hoisted = hoisted,
      restoreFocusOnClose = restoreFocusOnClose,
      absolutePosition = Point(0.0, 0.0),
      attrs = {
        registerEvents()
        onClosed { open1 = false }
      }
    ) {
      MDCBody1("Menu Content...")
    }
  }
  @OptIn(KMDCInternalAPI::class)
  NamedBlock("Anchored") {
    MDCMenuSurfaceAnchor(attrs = {
      style {
        property("width", "fit-content")
      }
    }) {
      MDCButton(
        text = "Anchor",
        attrs = {
          onClick { open2 = !open2 }
        }
      )
      MDCMenuSurface(
        open = open2,
        fullWidth = fullWidth,
        fixed = fixed,
        anchorCorner = anchorCorner,
        quickOpen = quickOpen,
        hoisted = hoisted,
        restoreFocusOnClose = restoreFocusOnClose,
        attrs = {
          registerEvents()
          onClosed { open2 = false }
        }
      ) {
        MDCBody1("Menu Content...")
      }
    }
  }
}

private fun MDCMenuSurfaceAttrsScope.registerEvents() {
  onOpened { console.log("MDCMenuSurface#onOpened", it.detail) }
  onClosing { console.log("MDCMenuSurface#onClosing", it.detail) }
  onClosed { console.log("MDCMenuSurface#onClosed", it.detail) }
}
