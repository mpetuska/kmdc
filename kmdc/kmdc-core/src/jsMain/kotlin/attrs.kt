@file:Suppress("NOTHING_TO_INLINE")

package dev.petuska.kmdc.core

import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement

@KMDCInternalAPI
public inline fun <T : Element> AttrsScope<T>.aria(key: String, value: Any) {
  attr("aria-$key", "$value")
}

@KMDCInternalAPI
public inline fun <T : Element> AttrsScope<T>.data(key: String, value: Any) {
  attr("data-$key", "$value")
}

public typealias Classes = Array<String>

@KMDCInternalAPI
public inline fun <T : Element> AttrsScope<T>.classes(classes: Array<out String>) {
  classes.forEach { classes(it) }
}

@KMDCInternalAPI
public inline fun <T : HTMLElement> AttrsScope<T>.role(value: Any) {
  attr("role", "$value")
}
