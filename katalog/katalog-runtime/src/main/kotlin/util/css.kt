package dev.petuska.katalog.runtime.util

import org.jetbrains.compose.web.css.*

internal fun <T : StylePropertyValue> StyleScope.setVariable(variable: CSSStyleVariable<T>, value: T) {
  property("--" + variable.name, value)
}
