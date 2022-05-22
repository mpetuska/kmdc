package engine

import androidx.compose.runtime.*
import app.softwork.routingcompose.*
import dev.petuska.kmdc.checkbox.*
import dev.petuska.kmdc.form.field.*
import dev.petuska.kmdc.layout.grid.*
import dev.petuska.kmdc.typography.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import samples.*
import showcases.*

@Composable
fun Sandbox() {
  Header()
  var enabledSamples by remember { mutableStateOf(setOf<Samples>()) }
  val samplesMap = remember { allSamples.associateBy(Samples::name) }
  HashRouter(initRoute = "") {
    (parameters?.map?.get("sample") ?: listOf())
      .mapNotNull { name -> samplesMap[name] }
      .toSet()
      .let { enabledSamples = it }
    noMatch {
      MDCLayoutGrid(attrs = { mdcTypography() }) {
        MDCLayoutGridCells {
          SamplesList(parameters?.map, enabledSamples)
          SamplesView(enabledSamples)
        }
      }
    }
  }
}

@Composable
private fun Header() {
  MDCH1("KMDC Sandbox") {
    style {
      textAlign("center")
      cursor("pointer")
    }
    onClick {
      HashRouter.navigate("")
    }
  }
}

@Composable
private fun SamplesScope.SamplesList(
  parameters: Map<String, List<String>>?,
  enabledSamples: Collection<Samples>
) {
  MDCLayoutGridCell({ span = 12u }) {
    Div({
      style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        justifyContent(JustifyContent.SpaceAround)
        alignItems(AlignItems.Center)
        flexWrap(FlexWrap.Wrap)
      }
    }) {
      allSamples.forEach { sample ->
        MDCFormField(attrs = {
          style {
            paddingRight(1.em)
            border(1.px, LineStyle.Dotted, Color.gray)
            borderRadius(1.em)
            margin(0.25.em)
          }
        }) {
          val checked = sample in enabledSamples
          MDCCheckbox(
            checked = checked,
            label = sample.name,
            attrs = {
              onInput {
                val currentSamples = parameters?.get("sample")?.toMutableSet() ?: mutableListOf()
                if (checked) {
                  currentSamples -= sample.name
                } else {
                  currentSamples += sample.name
                }
                val params = (parameters ?: mapOf()).let {
                  it + ("sample" to currentSamples)
                }.flatMap { (key, values) ->
                  values.map { "$key=$it" }
                }.takeIf(List<String>::isNotEmpty)?.joinToString(
                  prefix = "?",
                  separator = "&"
                ) ?: ""
                HashRouter.navigate("/$params")
              }
            }
          )
        }
      }
    }
  }
}

@Composable
private fun SamplesScope.SamplesView(enabledSamples: Collection<Samples>) {
  MDCLayoutGridCell({ span = 12u }) {
    MDCLayoutGrid {
      MDCLayoutGridCells {
        enabledSamples.forEach { sample -> with(sample) { render() } }
      }
    }
  }
}
