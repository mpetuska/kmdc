package dev.petuska.katalog.runtime

import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.padding

public object UtilStyle : StyleSheet() {
  public val roundedBoxShadow: String by style {
    borderRadius(.25.em)
    property("box-shadow", "rgba(50, 50, 93, 0.25) 0px 2px 5px -1px, rgba(0, 0, 0, 0.3) 0px 1px 3px -1px")
    padding(1.em)
  }
}
