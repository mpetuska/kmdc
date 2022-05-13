package dev.petuska.katalog.plugin.util

import com.google.devtools.ksp.symbol.KSValueArgument
import com.google.devtools.ksp.symbol.KSValueParameter

operator fun Collection<KSValueArgument>.get(name: String) = firstOrNull { it.name?.asString() == name }
operator fun Collection<KSValueParameter>.get(name: String) = firstOrNull { it.name?.asString() == name }

fun KSValueArgument?.asString(): String? = (this?.value as String?)?.takeIf(String::isNotBlank)
