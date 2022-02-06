@file:Suppress("NOTHING_TO_INLINE")

package dev.petuska.kmdc.core

import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement

@MDCInternalDsl
public inline fun <T : Element> AttrsBuilder<T>.aria(key: String, value: Any): AttrsBuilder<T> =
  attr("aria-$key", "$value")

@MDCInternalDsl
public inline fun <T : HTMLElement> AttrsBuilder<T>.role(value: Any): AttrsBuilder<T> =
  attr("role", "$value")
