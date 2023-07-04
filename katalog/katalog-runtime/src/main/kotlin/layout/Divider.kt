package dev.petuska.katalog.runtime.layout

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Hr

@Composable
public fun Divider(style: (StyleScope.() -> Unit)? = null) {
  Hr(attrs = {
    style {
      width(100.percent)
      opacity(0.5)
      position(Position.Sticky)
      left(0.em)
      marginTop(1.em)
      property("border-style", "dashed")
      style?.invoke(this)
    }
  })
}
