package local.test

import kotlin.js.Json

private external val process: Json

actual object Environment {
  private val env: Json = process["env"].unsafeCast<Json>()
  actual operator fun get(key: String): String? = env[key]?.toString()
}
