package dev.petuska.kmdc.chips.action

import androidx.compose.runtime.compositionLocalOf
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLElement

public interface MDCChipActionScope<T : HTMLElement> : ElementScope<T>

internal val MDCChipActionTypeLocal = compositionLocalOf<String> { error("undefined") }
