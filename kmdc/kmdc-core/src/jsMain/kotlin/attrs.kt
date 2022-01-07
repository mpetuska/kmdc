@file:Suppress("NOTHING_TO_INLINE")

package dev.petuska.kmdc.core

import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement

public inline fun <T : Element> AttrsBuilder<T>.aria(key: String, value: String): AttrsBuilder<T> =
  attr("aria-$key", value)

public inline fun <T : HTMLElement> AttrsBuilder<T>.role(value: String): AttrsBuilder<T> =
  attr("role", value)
