package dev.petuska.katalog.runtime.util

import org.jetbrains.compose.web.css.CSSStyleVariable
import org.jetbrains.compose.web.css.StylePropertyValue
import org.jetbrains.compose.web.css.StyleScope

internal fun <T : StylePropertyValue> StyleScope.setVariable(variable: CSSStyleVariable<T>, value: T) {
  property("--" + variable.name, value)
}
