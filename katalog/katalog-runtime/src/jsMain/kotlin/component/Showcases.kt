package dev.petuska.katalog.runtime.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import app.softwork.routingcompose.HashRouter
import app.softwork.routingcompose.NavLink
import dev.petuska.katalog.runtime.UtilStyle
import dev.petuska.katalog.runtime.domain.Showcase
import dev.petuska.katalog.runtime.katalog
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.marginRight
import org.jetbrains.compose.web.css.minWidth
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.value
import org.jetbrains.compose.web.css.variable
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.Text

private object ShowcasesStyle : StyleSheet() {
  val container by style {
    display(DisplayStyle.Flex)
    flexDirection(FlexDirection.Row)
    margin(1.em)
  }
  val sideBar by style {
    height(100.percent)
    minWidth(20.em)
    marginRight(1.em)
  }
  val content by style {
    height(100.percent)
    width(100.percent)
    display(DisplayStyle.Flex)
    flexDirection(FlexDirection.Column)
  }
  private val navBg by variable<CSSColorValue>()
  val navLink by style {
    navBg(Color("#F2BB05"))
    cursor("pointer")
    universal style {
      margin(0.em)
      padding(0.5.em)
      property("transition-property", "background-color,border-color")
      property("transition-duration", ".25s")
      property("transition-timing-function", "ease-in-out")
      borderRadius(0.25.em)
      border(color = Color.transparent, width = 0.1.em, style = LineStyle.Solid)
      self + hover style {
        property("border-color", navBg.value())
      }
    }
  }
  val navLinkSelected by style {
    universal style {
      backgroundColor(navBg.value())
    }
  }
}

@Composable
internal fun Showcases() {
  Style(ShowcasesStyle)
  HashRouter(initRoute = "") {
    Div(attrs = {
      classes(ShowcasesStyle.container)
    }) {
      val katalog = katalog
      val showcases = remember { katalog.showcases.associateBy(Showcase::id) }
      string { id ->
        val showcase = showcases[id]
        SideBar(showcase)
        Content(showcase)
      }
      noMatch {
        SideBar(null)
      }
    }
  }
}

@Composable
private fun SideBar(selected: Showcase?) {
  Div(attrs = {
    classes(ShowcasesStyle.sideBar, UtilStyle.roundedBoxShadow)
  }) {
    katalog.showcases.forEach { showcase ->
      NavLink(showcase.id, attrs = {
        classes(ShowcasesStyle.navLink)
        showcase.description?.let {
          title(it)
        }
        if (selected == showcase) classes(ShowcasesStyle.navLinkSelected)
      }) {
        H4 { Text(showcase.title) }
      }
    }
  }
}

@Composable
private fun Content(showcase: Showcase?) {
  Div(attrs = {
    classes(ShowcasesStyle.content, UtilStyle.roundedBoxShadow)
  }) {
    if (showcase != null) {
      ShowcaseBox(showcase)
    }
  }
}
