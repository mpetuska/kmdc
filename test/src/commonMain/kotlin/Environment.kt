package local.test

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

expect object Environment {
  operator fun get(key: String): String?
}

operator fun Environment.getValue(thisRef: Nothing?, property: KProperty<*>): String? = get(property.name)

infix fun Environment.or(default: String): ReadOnlyProperty<Nothing?, String> =
  ReadOnlyProperty { _, property -> Environment[property.name] ?: default }
