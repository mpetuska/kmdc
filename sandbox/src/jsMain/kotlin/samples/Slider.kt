package local.sandbox.samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.slider.MDCSlider
import dev.petuska.kmdc.slider.MDCSliderAttrsScope
import dev.petuska.kmdc.slider.onSliderChange
import dev.petuska.kmdc.slider.onSliderInput
import dev.petuska.kmdc.typography.MDCBody1
import local.sandbox.engine.Sample
import local.sandbox.engine.Samples

@Suppress("unused")
@EagerInitialization
private val SliderSamples = Samples("MDCSlider") {
  Sample("Continuous") { name ->
    var v1 by remember { mutableStateOf(50) }
    MDCBody1("Value: $v1")
    MDCSlider(
      opts = {
        value = v1
      },
      attrs = {
        registerEvents(name)
        onSliderInput {
          v1 = it.detail.value.toInt()
        }
      }
    )
  }
  Sample("Continuous Range") { name ->
    var v1 by remember { mutableStateOf(25) }
    var v2 by remember { mutableStateOf(75) }
    MDCBody1("Values: $v1:$v2")
    MDCSlider(
      opts = {
        value = v1
        value2 = v2
      },
      attrs = {
        registerEvents(name)
        onSliderInput {
          it.detail.let { detail ->
            if (detail.thumb == 1) {
              v1 = detail.value.toInt()
            } else {
              v2 = detail.value.toInt()
            }
          }
        }
      }
    )
  }
  Sample("Discrete") { name ->
    var v1 by remember { mutableStateOf(50) }
    MDCBody1("Value: $v1")
    MDCSlider(
      opts = {
        discrete = true
        value = v1
      },
      attrs = {
        registerEvents(name)
        onSliderInput {
          it.detail.let { detail ->
            v1 = detail.value.toInt()
          }
        }
      }
    )
  }
  Sample("Discrete Range") { name ->
    var v1 by remember { mutableStateOf(25) }
    var v2 by remember { mutableStateOf(75) }
    MDCBody1("Values: $v1:$v2")
    MDCSlider(
      opts = {
        discrete = true
        value = v1
        value2 = v2
      },
      attrs = {
        registerEvents(name)
        onSliderInput {
          it.detail.let { detail ->
            if (detail.thumb == 1) {
              v1 = detail.value.toInt()
            } else {
              v2 = detail.value.toInt()
            }
          }
        }
      }
    )
  }
  Sample("Discrete with Ticks") { name ->
    var v1 by remember { mutableStateOf(50) }
    MDCBody1("Value: $v1")
    MDCSlider(
      opts = {
        discrete = true
        tickMarks = true
        value = v1
        step = 10
      },
      attrs = {
        registerEvents(name)
        onSliderInput {
          it.detail.let { detail ->
            v1 = detail.value.toInt()
          }
        }
      }
    )
  }
  Sample("Discrete Range with Ticks") { name ->
    var v1 by remember { mutableStateOf(20) }
    var v2 by remember { mutableStateOf(80) }
    MDCBody1("Values: $v1:$v2")
    MDCSlider(
      opts = {
        discrete = true
        tickMarks = true
        value = v1
        value2 = v2
        step = 10
      },
      attrs = {
        registerEvents(name)
        onSliderInput {
          it.detail.let { detail ->
            if (detail.thumb == 1) {
              v1 = detail.value.toInt()
            } else {
              v2 = detail.value.toInt()
            }
          }
        }
      }
    )
  }
}

private fun MDCSliderAttrsScope.registerEvents(name: String) {
  onSliderInput { console.log("$name#onSliderInput", it.detail) }
  onSliderChange { console.log("$name#onSliderChange", it.detail) }
}
