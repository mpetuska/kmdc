package dev.petuska.kmdc.chips.action

import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

public interface MDCChipActionScope<T : HTMLElement> : ElementScope<T>

internal val MDCChipActionTypeLocal = compositionLocalOf<String> { error("undefined") }
