package dev.petuska.katalog.plugin.util

import com.google.devtools.ksp.symbol.*

public operator fun Collection<KSValueArgument>.get(name: String): KSValueArgument? = firstOrNull {
  it.name?.asString() == name
}
public operator fun Collection<KSValueParameter>.get(name: String): KSValueParameter? = firstOrNull {
  it.name?.asString() == name
}

public fun KSValueArgument?.asString(): String? = (this?.value as String?)?.takeIf(String::isNotBlank)
