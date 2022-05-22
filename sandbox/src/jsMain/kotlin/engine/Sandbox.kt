package engine

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import app.softwork.routingcompose.HashRouter
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdc.layout.grid.MDCLayoutGrid
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCell
import dev.petuska.kmdc.layout.grid.MDCLayoutGridCells
import dev.petuska.kmdc.typography.MDCH1
import dev.petuska.kmdc.typography.mdcTypography
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.flexWrap
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.paddingRight
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.dom.Div
import samples.Samples
import samples.SamplesScope
import showcases.allSamples

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
