@file:Suppress("NOTHING_TO_INLINE")

package dev.petuska.kmdc.core

import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement

@MDCInternalAPI
public inline fun <T : Element> AttrsScope<T>.aria(key: String, value: Any) {
  attr("aria-$key", "$value")
}

@MDCInternalAPI
public inline fun <T : HTMLElement> AttrsScope<T>.role(value: Any) {
  attr("role", "$value")
}
